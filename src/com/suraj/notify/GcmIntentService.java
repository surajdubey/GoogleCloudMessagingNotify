package com.suraj.notify;

import android.app.IntentService;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

public class GcmIntentService extends IntentService{

	Context context;
	public static final int NOTIFICATION_ID = 1;
	
	private NotificationManager mNotificationManager;
	NotificationCompat.Builder builder;
	
	public GcmIntentService(String name) {
		super("GCMIntentService");
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
