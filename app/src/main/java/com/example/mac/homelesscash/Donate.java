package com.example.mac.homelesscash;

import android.content.Intent;
import android.graphics.Color;
//import android.support.v7.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import mehdi.sakout.fancybuttons.FancyButton;
import top.androidman.SuperButton;

public class Donate extends AppCompatActivity {
    Button btnDonate;
    SuperButton money_5, money_10, money_2;
    String Money;

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_donate);
        TextView tv = ((TextView)findViewById(R.id.infoDisplay));
        tv.setText(getIntent().getStringExtra("what?"));

        money_2 = (SuperButton)findViewById(R.id.money_2);
        money_5 = (SuperButton)findViewById(R.id.money_5);
        money_10 = (SuperButton)findViewById(R.id.money_10);
        btnDonate = (Button)findViewById(R.id.btnDonate);

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



        btnDonate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Donate.this,TY.class);
                intent.putExtra("data",Money);
                startActivity(intent);

            }
        });
    }
}
