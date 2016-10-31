package com.example.layzzweekend.tools;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

/**
 * Created by Administrator on 2016/10/12.
 */
public class MemoroyCache {

    //   参数最大存储空间   coolge 官方建议使用4m 内存来存储图片
    private static LruCache<String,Bitmap> lruCache = new LruCache<String,Bitmap>(4*1024*1024) {
        private Object key;
        private Object value;

        /**
         * 计算每一个缓存图片的大小
         * @param key
         * @param value
         * @return
         */
        @Override
        protected int sizeOf(String key, Bitmap value) {
            return value.getByteCount();
        }
    };
    public static  void save(String key,Bitmap bitmap){
        lruCache.put(key,bitmap);
    }
    public  static Bitmap get(String key){
        return  lruCache.get(key);
    }
}
