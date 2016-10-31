package com.example.layzzweekend.tools;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import com.example.layzzweekend.R;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

public class ImageAsyncTaskLoadTools {
	public static ImageAsyncTask load(String imgPath,ImageView imageView){
		imageView.setTag(imgPath);
		imageView.setImageResource(R.mipmap.ic_launcher);
		return new ImageAsyncTask(imgPath, imageView);
	}
     public  static class ImageAsyncTask extends AsyncTask<String, Integer, Bitmap>{
       private String imgPath;
       private ImageView imageView;
		public ImageAsyncTask(String imgPath, ImageView imageView) {
		  this.imgPath = imgPath;
		  this.imageView=imageView;
		}
		public void execute(){
			this.execute(imgPath);
		}
		@Override
		protected Bitmap doInBackground(String... params) {
			InputStream is = null;
			try {
				URL url = new URL(params[0]);
				HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
				httpURLConnection.connect();
				if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
					is = httpURLConnection.getInputStream();
					int len = 0;
					byte[] buffer = new byte[1024];
					ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
					while((len = is.read(buffer)) != -1) {
						byteStream.write(buffer, 0, len);
					}
					byteStream.flush();
					byte[] streamByte = byteStream.toByteArray();
					Bitmap bitmap = BitmapFactory.decodeByteArray(streamByte, 0, streamByte.length);
					return bitmap;
				}
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				close(is);
			}
			return null;
		}
	
		@Override
    	protected void onPostExecute(Bitmap result) {
    		super.onPostExecute(result);
    		if (result == null ) {
    			imageView.setImageResource(R.mipmap.ic_launcher);
			} else if (imgPath.equals(imageView.getTag().toString())){
				imageView.setImageBitmap(result);
			}
//    		imageView.setImageBitmap(result);
    	}
      }	
      private static void close(Closeable closeable) {
			if (closeable != null) {
				try {
					closeable.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
}
