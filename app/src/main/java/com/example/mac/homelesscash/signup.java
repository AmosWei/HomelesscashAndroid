package com.example.mac.homelesscash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class signup extends AppCompatActivity {
    Button okB;
    EditText emET,pwET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        okB = (Button)findViewById(R.id.okB);
        emET = (EditText)findViewById(R.id.emET);
        pwET = (EditText)findViewById(R.id.pwET);

        okB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(signup.this, homepage.class);
         //       if (emET.getText().toString() == "123@gmail.com" && pwET.getText().toString() == "123")
                    startActivity(intent);

                }

        });

    }
}
