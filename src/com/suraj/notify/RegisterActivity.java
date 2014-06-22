package com.suraj.notify;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterActivity extends ActionBarActivity {
	
	Button btnRegister;
	EditText etUserName;
	TextView tvError;
	Context context;

	String str = "";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_register);
		btnRegister = (Button) findViewById(R.id.btnRegister);
		etUserName = (EditText) findViewById(R.id.etUserName);
		tvError = (TextView) findViewById(R.id.tvError);
		
		
		btnRegister.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				

				str = etUserName.getText().toString();
			
				if(str.length()<5)
				{
					tvError.setText("Username should be at least 5 characters long!!");
					
				}
				
				else
				{
					finish();
					context = getApplicationContext();
					Intent intent = new Intent(context, MainActivity.class);
					intent.putExtra("username", str);
					startActivity(intent);
				}
				
			}
		});
			
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.register, menu);
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


	private class RegisterUser extends AsyncTask<String,String,String>
	{

		@Override
		protected void onPreExecute() {
		
			
		}
		@Override
		protected String doInBackground(String... params) {
			return null;
			
		}
		
		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
		}
		
		
	}
}
