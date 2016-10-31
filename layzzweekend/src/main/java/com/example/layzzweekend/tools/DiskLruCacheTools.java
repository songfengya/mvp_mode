package com.example.layzzweekend.tools;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import com.jakewharton.disklrucache.DiskLruCache;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Administrator on 2016/10/12.
 */
public class DiskLruCacheTools {
    private static DiskLruCache diskLruCache;
    public  static  void init(Context context){
       File cacheFiles  = getCacheFile(context);
        try {
            if (diskLruCache == null) {
                diskLruCache = DiskLruCache.open(cacheFiles, 1, 1, 4 * 1024 * 1024);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static  File getCacheFile(Context context){
        File cacheDir = null;
        // 判断是否挂载
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
            cacheDir = context.getExternalCacheDir();
        }else {
            cacheDir = context.getCacheDir();
        }
        return  cacheDir;
    }
    // 给图片地址加密 并返回16进制的字符串
    private static  String formatKey(String imgPath){
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(imgPath.getBytes());
            byte[] digest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i <digest.length ; i++) {
                String hexStr = Integer.toHexString(digest[i]& 0xff);
                if (hexStr.length() > 1 ){
                    sb.append(hexStr);
                }else {
                    sb.append("0").append(hexStr);
                }
            }
            return  sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return  String.valueOf(imgPath.hashCode());
    }
    // 存数据
    public static  void save(String path, Bitmap bitmap){
        String imgPath = formatKey(path);
        try {
            DiskLruCache.Editor editor = diskLruCache.edit(imgPath);
            OutputStream outputStream = editor.newOutputStream(0);
            boolean compress = bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
            if (compress) {
                editor.commit();
            }else {
                editor.abort();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public  static  Bitmap read(String path){
        String formatKey = formatKey(path);
        try {
            DiskLruCache.Snapshot snapshot = diskLruCache.get(formatKey);
            if (snapshot != null){
                InputStream inputStream = snapshot.getInputStream(0);
                    Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                    return  bitmap;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
         return  null;
    }
    /**
     * 刷新日志文件：建议在APP退出的时候执行
     */
    public  static  void flush(){
        if (diskLruCache != null) {
            try {
                diskLruCache.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
