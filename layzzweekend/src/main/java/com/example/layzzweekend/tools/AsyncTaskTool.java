package com.example.layzzweekend.tools;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import android.os.AsyncTask;

public class AsyncTaskTool {

	public static MyGiftTask load(String path) {
		return new MyGiftTask(path);
	}
	
	public static class MyGiftTask extends AsyncTask<String, Integer, String> {

		private IMyCallback callback;
		private String params;
		private String path;
	   private boolean isPost;
		public MyGiftTask(String path) {
			super();
			this.isPost = false;
			this.path = path;
		}
		public MyGiftTask post(String params){
			this.params = params;
			isPost = true;
			return this;
		}
     public void execute(IMyCallback callback){
    	 this.callback = callback;
    	 this.execute(path,params);
     }
		@Override
		protected String doInBackground(String... params) {
			String path = params[0];
			InputStream is = null;
			StringBuilder builder = new StringBuilder();
			try {
				URL url = new URL(path);
				HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
				if (isPost) {
					httpURLConnection.setDoOutput(true);
					httpURLConnection.setRequestMethod("POST");
					httpURLConnection.getOutputStream().write(params[1].getBytes());
					httpURLConnection.getOutputStream().flush();
				}
				httpURLConnection.connect();
				if (httpURLConnection.getResponseCode() == 200) {
					is = httpURLConnection.getInputStream();
					int len = 0;
					byte[] buffer = new byte[1024];
					while((len = is.read(buffer)) != -1) {
						builder.append(new String(buffer, 0, len));
					}
				}
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				close(is);
			}
			
			return builder.toString();
		}
		
		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);
			callback.success(result);
			
		}
		private void close(Closeable close) {
			if (close != null) {
				try {
					close.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public interface IMyCallback {
		void success(String result);
	}

}
