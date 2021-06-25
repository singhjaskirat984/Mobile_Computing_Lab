package com.example.experiment_4_send_sms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText no;
    EditText message;
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        no = (EditText) findViewById(R.id.editTextnumber);
        message = (EditText) findViewById(R.id.editText2msg);
        send = (Button) findViewById(R.id.button);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = no.getText().toString();
                String msg = message.getText().toString();
                try {
                    SmsManager sms = SmsManager.getDefault();
                    sms.sendTextMessage(number, null, msg, null, null);
                    Toast.makeText(getApplicationContext(), "send", Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "not send", Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        });
    }
}
