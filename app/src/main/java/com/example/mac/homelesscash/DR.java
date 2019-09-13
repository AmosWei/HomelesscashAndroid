package com.example.mac.homelesscash;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import mehdi.sakout.fancybuttons.FancyButton;
import top.androidman.SuperButton;

public class DR extends AppCompatActivity {

    SuperButton btn_left, btn_middle, btn_right;
    FancyButton btnDR2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dr);
        btn_left = (SuperButton)findViewById(R.id.money2);
        btn_middle = (SuperButton)findViewById(R.id.money5);
        btn_right = (SuperButton)findViewById(R.id.money10);
        btnDR2 = (FancyButton)findViewById(R.id.btn_DR2);

        btn_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_left.setButtonBackgroundColor(200);
            }
        });
        btn_middle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_middle.setButtonBackgroundColor(200);
            }
        });
        btn_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_right.setButtonBackgroundColor(200);
            }
        });
        btnDR2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
