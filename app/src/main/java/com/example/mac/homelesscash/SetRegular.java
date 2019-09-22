package com.example.mac.homelesscash;

import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import top.androidman.SuperButton;

public class SetRegular extends AppCompatActivity {

    SuperButton money_5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_regular);

        money_5 = (SuperButton)findViewById(R.id.money5);
        Intent intent = getIntent();
        money_5.setText(intent.getStringExtra("data"));
    }
}
