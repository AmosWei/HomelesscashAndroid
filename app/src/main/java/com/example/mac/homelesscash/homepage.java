package com.example.mac.homelesscash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class homepage extends AppCompatActivity {
    TextView dn;
    TextView dh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        dh = (TextView)findViewById(R.id.DH);
        dn = (TextView)findViewById(R.id.donations);
        dh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(homepage.this,Donations_History.class);
                startActivity(intent);
            }
        });
        dn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_1 = new Intent(homepage.this,Donate.class);
                startActivity(intent_1);
            }
        });

    }
}
