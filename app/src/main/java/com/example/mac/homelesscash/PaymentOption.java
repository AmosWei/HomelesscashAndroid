package com.example.mac.homelesscash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class PaymentOption extends AppCompatActivity {
    Button cnButton;
    RadioButton visaRadio, paypalRadio, wwRadio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_option);
        visaRadio = (RadioButton)findViewById(R.id.visaCheckBox);
        paypalRadio = (RadioButton)findViewById(R.id.paypalCheckBox);
        wwRadio = (RadioButton)findViewById(R.id.wwCheckBox);
        cnButton = (Button)findViewById(R.id.cnButton);
        cnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PaymentOption.this,TY.class);
                startActivity(intent);

            }
        });
    }
}
