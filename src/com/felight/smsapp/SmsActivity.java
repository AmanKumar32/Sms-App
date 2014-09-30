package com.felight.smsapp;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SmsActivity extends Activity {

	Button btnsend;
	EditText etphoneNo;
	EditText etmessage;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sms);

		btnsend = (Button) findViewById(R.id.btnsend);
		etphoneNo = (EditText) findViewById(R.id.etphoneNo);
		etmessage = (EditText) findViewById(R.id.etmessage);
	}

	public void send(View view) {

		btnsend.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				String phoneNo = etphoneNo.getText().toString();
				String sms = etmessage.getText().toString();

				try {
					SmsManager smsManager = SmsManager.getDefault();
					smsManager.sendTextMessage(phoneNo, null, sms, null, null);
					Toast.makeText(getApplicationContext(), "SMS Sent!",
							Toast.LENGTH_LONG).show();
				} catch (Exception e) {
					Toast.makeText(getApplicationContext(),
							"SMS faild, please try again later!",
							Toast.LENGTH_LONG).show();
					e.printStackTrace();
				}

			}
		});
	}

}
