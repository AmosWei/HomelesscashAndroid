package com.example.mac.homelesscash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PaymentOption extends AppCompatActivity {
    Button cnButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_option);
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
