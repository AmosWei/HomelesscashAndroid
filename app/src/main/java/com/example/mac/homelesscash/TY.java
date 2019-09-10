package com.example.mac.homelesscash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class TY extends AppCompatActivity {
    TextView text_DR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ty);
        text_DR = (TextView)findViewById(R.id.DR_TEXT);
        text_DR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TY.this, DR.class );
                startActivity(intent);
            }
        });
    }
}
