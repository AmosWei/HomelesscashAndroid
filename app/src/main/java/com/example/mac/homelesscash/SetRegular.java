package com.example.mac.homelesscash;

import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import top.androidman.SuperButton;

public class SetRegular extends AppCompatActivity {
    Button weekly;
    Button daily;

    SuperButton money_5;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_regular);
        weekly = (Button)findViewById(R.id.everyweek);
        daily = (Button)findViewById(R.id.everyday);
        daily.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(SetRegular.this,HomePage.class);
                startActivity(intent1);

            }
        });
        weekly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(SetRegular.this,HomePage.class);
                startActivity(intent2);
            }
        });
        money_5 = (SuperButton)findViewById(R.id.money5);
        Intent intent = getIntent();
        money_5.setText(intent.getStringExtra("data"));
    }
}
