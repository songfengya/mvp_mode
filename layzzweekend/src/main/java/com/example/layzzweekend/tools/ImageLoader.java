package com.example.layzzweekend.tools;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2016/10/12.
 */
public class ImageLoader {
    private static ExecutorService executorService;
    private static void init(){
        if (executorService == null){
         executorService = Executors.newFixedThreadPool(4);
        }
    }
    /**
     * @context  上下文文
     * @param path  图片的地址
     * @param imageView 图片控件
     * @param width  宽度压缩比
     * @param height 高度压缩比
     */
    public static void load(Context context , String path, ImageView imageView,int width,int height){
        init();

       DiskLruCacheTools.init(context);
        Bitmap bitmap = MemoroyCache.get(path);
        if (bitmap == null) {
            executorService.execute(new ImageThread(path,imageView,width,height));
        }else {
            imageView.setImageBitmap(bitmap);
        }
    }
}
