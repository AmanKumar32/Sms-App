package com.felight.sms;

import com.felight.smsapp.R;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
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
		setContentView(R.layout.sms_layout);

		Log.i("sms", "not");

		etphoneNo = (EditText) findViewById(R.id.etphoneNo);
		etmessage = (EditText) findViewById(R.id.etmessage);
		//btnsend = (Button) findViewById(R.id.btnsend);

	}

	public void send(View view) {
		final String phoneNo = etphoneNo.getText().toString();
		final String sms = etmessage.getText().toString();

		try {
			SmsManager smsManager = SmsManager.getDefault();
			smsManager.sendTextMessage(phoneNo, null, sms, null, null);
			Toast.makeText(getApplicationContext(), "SMS Sent!",
					Toast.LENGTH_LONG).show();
		} catch (Exception e) {
			Toast.makeText(getApplicationContext(),
					"SMS faild, please try again later!", Toast.LENGTH_LONG)
					.show();
			e.printStackTrace();
		}

	}

}
