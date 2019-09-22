package com.example.mac.homelesscash;

import android.content.Intent;
import android.graphics.Color;
//import android.support.v7.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import mehdi.sakout.fancybuttons.FancyButton;
import top.androidman.SuperButton;

public class DR extends AppCompatActivity {

    SuperButton money_2, money_5, money_10;
    Button btnDR2;
    String Money;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dr);
        money_2 = (SuperButton)findViewById(R.id.money2);
        money_5 = (SuperButton)findViewById(R.id.money5);
        money_10 = (SuperButton)findViewById(R.id.money10);
        btnDR2 = (Button)findViewById(R.id.btn_DR2);

        money_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                money_2.setButtonBackgroundColor(Color.parseColor("#afdcd8"));
                money_5.setButtonBackgroundColor(Color.parseColor("#dbdbdb"));
                money_10.setButtonBackgroundColor(Color.parseColor("#dbdbdb"));
                Money = "$2";
            }
        });
        money_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                money_5.setButtonBackgroundColor(200);
                money_5.setButtonBackgroundColor(Color.parseColor("#afdcd8"));
                money_2.setButtonBackgroundColor(Color.parseColor("#dbdbdb"));
                money_10.setButtonBackgroundColor(Color.parseColor("#dbdbdb"));
                Money = "$5";
            }
        });

        money_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                money_10.setButtonBackgroundColor(200);
                money_10.setButtonBackgroundColor(Color.parseColor("#afdcd8"));
                money_2.setButtonBackgroundColor(Color.parseColor("#dbdbdb"));
                money_5.setButtonBackgroundColor(Color.parseColor("#dbdbdb"));
                Money = "$10";
            }
        });

        btnDR2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DR.this,SetRegular.class);
                intent.putExtra("data",Money);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {

        // Put your own code here which you want to run on back button click.

        Intent intent2 = new Intent(DR.this,HomePage.class);
        startActivity(intent2);

        super.onBackPressed();
    }
}
