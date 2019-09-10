package com.example.mac.homelesscash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import mehdi.sakout.fancybuttons.FancyButton;
import top.androidman.SuperButton;

public class Donate extends AppCompatActivity {
    FancyButton btnDonate;
    SuperButton money_5, money_10, money_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate);
        btnDonate = (FancyButton)findViewById(R.id.btnDonate);
        money_2 = (SuperButton)findViewById(R.id.money_2);
        money_5 = (SuperButton)findViewById(R.id.money_5);
        money_10 = (SuperButton)findViewById(R.id.money_10);



        btnDonate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Donate.this,TY.class);
                startActivity(intent);

            }
        });
    }
}
