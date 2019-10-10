package com.example.mac.homelesscash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class PaymentOption extends AppCompatActivity {
    Button btnVisa, btnPaypal,btnWW;
    String Money, Name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_option);
        btnVisa = (Button)findViewById(R.id.visaCheckBox);
        btnPaypal = (Button)findViewById(R.id.paypalCheckBox);
        btnWW = (Button)findViewById(R.id.wwCheckBox);

        Intent intent = getIntent();
        Money = intent.getStringExtra("data");
        Name = intent.getStringExtra("Name");

        btnVisa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(PaymentOption.this,TY.class);
                intent1.putExtra("data",Money);
                intent1.putExtra("Name",Name);
                startActivity(intent1);

            }
        });
        btnPaypal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(PaymentOption.this,TY.class);
                intent2.putExtra("data",Money);
                intent2.putExtra("Name",Name);
                startActivity(intent2);
            }
        });
        btnWW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(PaymentOption.this,TY.class);
                intent3.putExtra("data",Money);
                intent3.putExtra("Name",Name);
                startActivity(intent3);
            }
        });

    }
}
