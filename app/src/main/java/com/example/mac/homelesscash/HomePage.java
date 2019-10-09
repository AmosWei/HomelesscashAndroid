package com.example.mac.homelesscash;

import android.app.PendingIntent;
import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.TextView;

import org.altbeacon.beacon.Beacon;
import org.altbeacon.beacon.BeaconManager;
import org.altbeacon.beacon.Region;
import org.altbeacon.beacon.startup.BootstrapNotifier;

import static android.app.PendingIntent.getActivity;

public class HomePage extends AppCompatActivity implements BootstrapNotifier {
    TextView donations;
    TextView donationHistory;
    TextView donationmap;
    TextView beaconscanner;
    TextView usernameTV;
    TextView people;

    //BeaconManager
    private BeaconManager beaconManager;




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Service initializer code//
        this.beaconManager = BeaconManager.getInstanceForApplication(this);

        Intent intent = new Intent(this, backgroundScanner.class);
        //PendingIntent pendingIntent = new PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        ContextCompat.startForegroundService(this, intent);






















        super.onCreate(savedInstanceState);
//        FacebookSdk.sdkInitialize(getApplicationContext());
//        AppEventsLogger.activateApp(this);
        setContentView(R.layout.activity_homepage);
//        donationHistory = (TextView)findViewById(R.id.DH);
        donations = (TextView)findViewById(R.id.donations);
        donationmap = (TextView)findViewById(R.id.average);
        beaconscanner = (TextView)findViewById(R.id.mainDonation);
        usernameTV = (TextView)findViewById(R.id.name);
        people = findViewById(R.id.people);
//        donationHistory.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(HomePage.this, DonationsHistory.class);
//                startActivity(intent);
//            }
//        });
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

//        usernameTV.setText(Login.donor.username);
//        int numberOfDonation = Login.donor.numberOfDonation;
//        String numberOfDonationStr = String.valueOf(numberOfDonation);
//        int numberOfRecipient = Login.donor.numberOfRecipient;
//        String numberOfRecipientStr = String.valueOf(numberOfRecipient);
//        donations.setText(numberOfDonationStr);
//        people.setText(numberOfRecipientStr);

    }

    @Override
    public void didEnterRegion(Region region) {
        //null
    }

    @Override
    public void didExitRegion(Region region) {
        //null
    }

    @Override
    public void didDetermineStateForRegion(int i, Region region) {
        //null
    }
}
