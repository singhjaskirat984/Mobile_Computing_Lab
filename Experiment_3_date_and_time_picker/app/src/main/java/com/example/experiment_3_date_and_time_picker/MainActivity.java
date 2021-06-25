package com.example.experiment_3_date_and_time_picker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatePicker datepicker;
    TimePicker timepicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        datepicker = (DatePicker) findViewById(R.id.datePicker);
        timepicker = (TimePicker) findViewById(R.id.timePicker);
//timepicker.setIs24HourView(true);
        Button button = (Button) findViewById(R.id.datebutton);
        Button button1 = (Button) findViewById(R.id.timebutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "Date : "
                        + (datepicker.getMonth() + 1)
                        + "/" + datepicker.getDayOfMonth() + "/" + datepicker.getYear(), Toast.LENGTH_LONG).show();
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "Time Selected : " + timepicker.getCurrentHour() + ":" + timepicker.getCurrentMinute(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
