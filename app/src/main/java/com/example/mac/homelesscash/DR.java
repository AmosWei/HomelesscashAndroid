package com.example.mac.homelesscash;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import mehdi.sakout.fancybuttons.FancyButton;
import top.androidman.SuperButton;

public class DR extends AppCompatActivity {

    SuperButton btn_2, btn_5, btn_10;
    FancyButton btnDR2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dr);
        btn_2 = (SuperButton)findViewById(R.id.money2);
        btn_5 = (SuperButton)findViewById(R.id.money5);
        btn_10 = (SuperButton)findViewById(R.id.money10);
        btnDR2 = (FancyButton)findViewById(R.id.btn_DR2);

        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_2.setButtonBackgroundColor(200);
            }
        });
        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_5.setButtonBackgroundColor(200);
            }
        });
        btn_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_10.setButtonBackgroundColor(200);
            }
        });
        btnDR2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
