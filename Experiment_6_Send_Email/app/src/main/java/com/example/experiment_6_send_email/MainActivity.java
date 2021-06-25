package com.example.experiment_6_send_email;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText to;
    EditText subject;
    EditText message;
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        to = (EditText) findViewById(R.id.editTextmail);
        subject = (EditText) findViewById(R.id.editText2sub);
        message = (EditText) findViewById(R.id.editText3msg);
        send = (Button) findViewById(R.id.button);
        send.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String textto = to.getText().toString();
                String textsub = subject.getText().toString();
                String textmsg = message.getText().toString();
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{textto});
                email.putExtra(Intent.EXTRA_SUBJECT, textsub);
                email.putExtra(Intent.EXTRA_TEXT, textmsg);
                email.setType("text/plain");
                startActivity(Intent.createChooser(email, "choose email:"));
            }
        });
    }
}
