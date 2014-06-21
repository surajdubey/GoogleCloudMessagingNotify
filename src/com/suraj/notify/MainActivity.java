package com.suraj.notify;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.gms.gcm.GoogleCloudMessaging;

public class MainActivity extends ActionBarActivity {
	
	// variable declaration
	
	static final String TAG = "NotifyApp";
	GoogleCloudMessaging gcm;
	TextView mDisplay;
	Context context;
	String regId;
	
	String SENDER_ID = "916067693415"; //project number here

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		context = getApplicationContext();
		mDisplay = (TextView) findViewById(R.id.display);
		
		gcm = GoogleCloudMessaging.getInstance(this);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}
	
	class RegisterBackGround extends AsyncTask<String, String, String>
	{

		@Override
		protected String doInBackground(String... args0) {
			// TODO Auto-generated method stub
			String msg = "";
			try{
				if(gcm == null)
				{
					gcm = GoogleCloudMessaging.getInstance(context);
					
					msg = "Device Registered: RegID = "+regId;
					Log.d("111", msg);
					
					// Device Registered. Save to database
					saveRegistrationId(regId);
				}
				
				regId = gcm.register(SENDER_ID);
			}
			catch (IOException e) {
				msg = "Error: = " +e.getMessage();
			}
			
			return msg;
		}
		
		@Override
		protected void onPostExecute(String msg) {
			
			mDisplay.append(msg+"\n");
		}
		
		private void saveRegistrationId(String regId)
		{
			//data is sent to server and saved into database on server
			
			String url="";
			
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			
			params.add(new BasicNameValuePair("regid", regId));
			DefaultHttpClient httpclient = new DefaultHttpClient();
			HttpPost httppost = new HttpPost(url);
			
			try{
				httppost.setEntity(new UrlEncodedFormEntity(params));
				
			}
			
			catch(Exception e1)
			{
				e1.printStackTrace();
				
			}
			
		}
		
		
	}



}
