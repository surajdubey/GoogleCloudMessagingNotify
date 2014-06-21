package com.suraj.notify;

import org.json.JSONObject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class ReceiveActivity extends ActionBarActivity {
	
	TextView deal;
	TextView address;
	TextView valid;
	TextView name;
	JSONObject json;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_receive);

		Intent intent = getIntent();
		name = (TextView) findViewById(R.id.name);
		deal = (TextView) findViewById(R.id.deal);
		address = (TextView) findViewById(R.id.address);
		valid = (TextView) findViewById(R.id.valid);
		
		String message = intent.getExtras().getString("message");
		
		try{
			json = new JSONObject(message);
			String stime = json.getString("name");
			name.setText(stime);
			
			String slectureName = json.getString("deal");
			deal.setText(slectureName);
			
			String sroom = json.getString("valid");
			valid.setText(sroom);
			
			String sfaculty = json.getString("address");
			address.setText(sfaculty);
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.receive, menu);
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



}
