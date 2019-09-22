package com.example.mac.homelesscash;

import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import mehdi.sakout.fancybuttons.FancyButton;

public class DH2 extends AppCompatActivity {
    FancyButton btnDR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dh2);
        btnDR = (FancyButton)findViewById(R.id.btn_DR1);
        btnDR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DH2.this,DR.class);
                startActivity(intent);
            }
        });
    }
}
