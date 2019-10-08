package com.example.mac.homelesscash;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
//import android.support.v7.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.altbeacon.beacon.BeaconManager;
import org.altbeacon.beacon.Region;
import org.altbeacon.beacon.startup.BootstrapNotifier;

/*
 * Created by Hubert, modified on 16/09/19
 */
public class Login extends AppCompatActivity implements BootstrapNotifier {
    Button okB;
    EditText emET,pwET;
    TextView sgTV;
    private FirebaseDatabase firebaseDatabase;      // database object
    private DatabaseReference databaseReference;    // reference object
    private ValueEventListener valueEventListener;
    DataSnapshot ds;

    private BeaconManager beaconManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.beaconManager = BeaconManager.getInstanceForApplication(this);


        Intent intent = new Intent(this, backgroundScanner.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);


        ContextCompat.startForegroundService(this, intent);
        //startService(intent);


        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference().child("User");
        valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ds = dataSnapshot;
                //Donor donor = dataSnapshot.child(firebaseEmail).getValue(Donor.class);
                //firebasePassword = donor.password;
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        };
        databaseReference.addValueEventListener(valueEventListener);




        setContentView(R.layout.activity_signup);
        okB = (Button)findViewById(R.id.okB);
        emET = (EditText)findViewById(R.id.usernameET);
        pwET = (EditText)findViewById(R.id.passwordET);
        sgTV = (TextView)findViewById(R.id.signUp);

        sgTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(Login.this, SignUp.class);
                startActivity(intent2);
            }
        });


        okB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                login();
                }

        });


        SharedPreferences pref = getSharedPreferences(Preferences.SharedPreferencesTag, Preferences.SharedPreferences_ModeTag);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("isLogin", "false");
        editor.apply();

    }

    public void login(){

        if(!validate()){
            okB.setEnabled(true);
            return;
        }

        okB.setEnabled(false);

        final String username = emET.getText().toString();
        final String password = pwET.getText().toString();

        loginAction(username,password);

    }


    private void loginAction(String username, String password) {
        Preferences.showLoading(this, "Log In", "Authenticating...");
        final Activity act = this;
        if(ds.hasChild(username)){
            String firebasePassword = ds.child(username).getValue(Donor.class).password;
            if(password.equals(firebasePassword)){
                startNavigation();
                onLoginSuccess();
            }
            else{
                onLoginFailed();
            }
        }else{
            onLoginFailed();
        }
    }


    private void startNavigation() {
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
        SharedPreferences pref = getSharedPreferences(Preferences.SharedPreferencesTag, Preferences.SharedPreferences_ModeTag);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("isLogin", "true");
        editor.apply();
    }

    private void onLoginFailed() {
        okB.setEnabled(false);
        Preferences.dismissLoading();
        android.app.AlertDialog alertDialog = new android.app.AlertDialog.Builder(Login.this).create();
        alertDialog.setTitle("Login Failed");
        if (checkInternetOn()) {
            alertDialog.setMessage("Please check username and password again.");

        } else {
            alertDialog.setMessage("Please turn on internet connection.");

        }
        alertDialog.setButton(android.app.AlertDialog.BUTTON_POSITIVE, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
        okB.setEnabled(true);
    }

    public boolean checkInternetOn() {
        ConnectivityManager conMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = conMgr.getActiveNetworkInfo();

        if (netInfo == null) {
            return false;
        } else {
            return true;
        }

    }

    private void onLoginSuccess() {
        okB.setEnabled(true);
        finish();
    }

    public boolean validate(){
        boolean valid = true;
        String username = emET.getText().toString();
        String password = pwET.getText().toString();

        if(username.isEmpty()){    //|| username.length()<4 || username.length()>255
            emET.setError("Enter valid Email address");
            valid = false;
        }else{
            emET.setError(null);
        }

        if(password.isEmpty() || password.length()<6 || password.length()>255){
            pwET.setError("Password is required at least 6 characters");
            valid = false;
        }else{
            pwET.setError(null);
        }
        return valid;
    }

    @Override
    public void didEnterRegion(Region region) {

    }

    @Override
    public void didExitRegion(Region region) {

    }

    @Override
    public void didDetermineStateForRegion(int i, Region region) {

    }
}
