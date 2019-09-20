package com.example.mac.homelesscash;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import mehdi.sakout.fancybuttons.FancyButton;
import top.androidman.SuperButton;

public class DonateNow extends AppCompatActivity {

    SuperButton btn_left, btn_middle, btn_right;
    FancyButton btnDR2;
    String Money;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate_now);


        TextView tv = ((TextView)findViewById(R.id.infoDisplay));
        tv.setText(getIntent().getStringExtra("what?"));


        btn_left = (SuperButton)findViewById(R.id.money2);
        btn_middle = (SuperButton)findViewById(R.id.money5);
        btn_right = (SuperButton)findViewById(R.id.money10);
        btnDR2 = (FancyButton)findViewById(R.id.btn_DR2);

        btn_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_left.setButtonBackgroundColor(200);
                Money = "$2";
            }
        });
        btn_middle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_middle.setButtonBackgroundColor(200);
                Money = "$5";
            }
        });
        btn_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_right.setButtonBackgroundColor(200);
                Money = "$10";
            }
        });
        btnDR2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DonateNow.this,TY.class);
                intent.putExtra("data",Money);
                startActivity(intent);
            }
        });
    }
}
