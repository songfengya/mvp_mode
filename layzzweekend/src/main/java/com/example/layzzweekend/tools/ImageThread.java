package com.example.layzzweekend.tools;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Administrator on 2016/10/12.
 */
public class ImageThread implements  Runnable {
    private String imgPath;
    public  int MAX_WIDTH ;
    public  int MAX_HEIGHT ;
    private ImageView imageView;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            // 防止图片加载出现崩溃
            if (imageView.getTag().equals(imgPath)) {
                Bitmap bitmap = (Bitmap) msg.obj;
                MemoroyCache.save(imgPath,bitmap);
                imageView.setImageBitmap(bitmap);
            }
        }
    } ;

    /**
     * @param imgPath  图片的地址
     * @param imageView 图片控件
     * @param width  宽度压缩比
     * @param height 高度压缩比
     */
    public ImageThread(String imgPath, ImageView imageView,int width,int height) {
        this.imgPath = imgPath;
        this.imageView = imageView;
        this.MAX_WIDTH = width;
        this.MAX_HEIGHT = height;
        imageView.setTag(imgPath);
    }

    @Override
    public void run() {
        // 从磁盘中读取bitmap对象
        Bitmap cacheBitmap = DiskLruCacheTools.read(imgPath);
        // 如果磁盘中有 这直接返回主线程
        if (cacheBitmap != null) {
            Message message = handler.obtainMessage();
            message.obj = cacheBitmap;
            handler.sendMessage(message);
            return;
        }
        // 如果磁盘中没有则 通过网络下载
        InputStream in = null;
        ByteArrayOutputStream out = null;
        try {
            URL url = new URL(imgPath);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            if (connection.getResponseCode() == 200) {
                in = connection.getInputStream();
                int len = 0;
                byte []buffer = new byte[1024];
                out = new ByteArrayOutputStream();
                while ((len = in.read(buffer))!= -1){
                    out.write(buffer,0,len);

                }
                out.flush();
                byte[] bt = out.toByteArray();
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds =true;// 仅仅获得图片大小
                BitmapFactory.decodeByteArray(bt,0,bt.length,options);
                int outWidth = options.outWidth;
                int outHeight = options.outHeight;
                // 计算压缩比
                int widthRatio = outWidth/MAX_WIDTH;
                int heightRatio = outHeight/MAX_HEIGHT;
                int ratio = widthRatio > heightRatio ? widthRatio:heightRatio;
                options.inJustDecodeBounds= false;
                options.inSampleSize = ratio;
                Bitmap bitmap = BitmapFactory.decodeByteArray(bt, 0, bt.length, options);
                // 存入磁盘
                DiskLruCacheTools.save(imgPath,bitmap);
                Message message = handler.obtainMessage();
                message.obj = bitmap;
                handler.sendMessage(message);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
