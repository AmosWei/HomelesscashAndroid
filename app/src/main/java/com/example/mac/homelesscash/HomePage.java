package com.example.mac.homelesscash;

import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HomePage extends AppCompatActivity {
    TextView donations;
    TextView donationHistory;
    TextView donationmap;
    TextView beaconscanner;
    TextView usernameTV;
    TextView people;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        FacebookSdk.sdkInitialize(getApplicationContext());
//        AppEventsLogger.activateApp(this);
        setContentView(R.layout.activity_homepage);
        donationHistory = (TextView)findViewById(R.id.DH);
        donations = (TextView)findViewById(R.id.donations);
        donationmap = (TextView)findViewById(R.id.average);
        beaconscanner = (TextView)findViewById(R.id.mainDonation);
        usernameTV = (TextView)findViewById(R.id.name);
        people = findViewById(R.id.people);
        donationHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomePage.this, DonationsHistory.class);
                startActivity(intent);
            }
        });
        donations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_1 = new Intent(HomePage.this,Donate.class);
                startActivity(intent_1);
            }
        });
        donationmap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_mapview = new Intent(HomePage.this,DH2.class); //direct to page with map view
                startActivity(intent_mapview);
            }
        });
        beaconscanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_scanner = new Intent(HomePage.this,ibeacon_scan.class); //direct to page to scanner
                startActivity(intent_scanner);
            }
        });

        usernameTV.setText(Login.donor.username);
        donations.setText(Login.donor.numberOfDonation);
        people.setText(Login.donor.numberOfRecipient);

    }

}
