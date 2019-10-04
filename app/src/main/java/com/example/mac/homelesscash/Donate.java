package com.example.mac.homelesscash;

import android.content.Intent;
import android.graphics.Color;
//import android.support.v7.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import mehdi.sakout.fancybuttons.FancyButton;
import top.androidman.SuperButton;

public class Donate extends AppCompatActivity {
    Button btnDonate;
    SuperButton money_5, money_10, money_2;
    String Money= "0";
    String Name;
    String InMoney;
    EditText Input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_donate);
        TextView tv = ((TextView)findViewById(R.id.infoDisplay));
        Name = getIntent().getStringExtra("what?");
        tv.setText(getIntent().getStringExtra("what?"));

        money_2 = (SuperButton)findViewById(R.id.money_2);
        money_5 = (SuperButton)findViewById(R.id.money_5);
        money_10 = (SuperButton)findViewById(R.id.money_10);
        btnDonate = (Button)findViewById(R.id.btnDonate);
        Input = (EditText)findViewById(R.id.cus_acc);
        InMoney = Input.getText().toString();

        money_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                money_2.setButtonBackgroundColor(Color.parseColor("#afdcd8"));
                money_5.setButtonBackgroundColor(Color.parseColor("#dbdbdb"));
                money_10.setButtonBackgroundColor(Color.parseColor("#dbdbdb"));
                Money = "$2";
            }
        });

        money_5.setOnClickListener(
                new View.OnClickListener() {
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

                if(Money.equals("0")){
                    Intent intent = new Intent(Donate.this,TY.class);
                    intent.putExtra("data","$"+Input.getText().toString());
                    intent.putExtra("Name",Name);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(Donate.this, TY.class);
                    intent.putExtra("data", Money);
                    intent.putExtra("Name", Name);
                    startActivity(intent);

                }

            }
        });
    }
}
