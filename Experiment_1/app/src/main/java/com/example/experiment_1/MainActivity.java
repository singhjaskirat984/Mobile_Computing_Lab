package com.example.experiment_1;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText first,second;
    RadioButton add,sub,mul,div;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void calculateButtonClick(View v)
    {
        first=(EditText)findViewById (R.id.firstNum);
        second=(EditText)findViewById (R.id.secondNum);
        float firstNo = Integer.parseInt(first.getText().toString());
        float secondNo = Integer.parseInt(second.getText().toString());
        add =(RadioButton) findViewById(R.id.addno);
        sub =(RadioButton) findViewById(R.id.subno);
        mul =(RadioButton) findViewById(R.id.mulno);
        div =(RadioButton) findViewById(R.id.divno);
        float result = 0;
        if(add.isChecked())
        {
            result = firstNo + secondNo;
        } else if (sub.isChecked()) {
            result = firstNo - secondNo;
        } else if (mul.isChecked()){
            result = firstNo * secondNo;
        } else if (div.isChecked()){
            result = firstNo / secondNo;
        }
        TextView res = (TextView)findViewById(R.id.result);
        res.setText("Result : " +result);
    }
}