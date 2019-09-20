package com.example.mac.homelesscash;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * Created by Hubert, modified on 16/09/19
 */
public class Login extends AppCompatActivity {
    Button okB;
    EditText emET,pwET;
    ArrayList<String> uids = new ArrayList<>(Arrays.asList("ZoeDavid@gmail.com","test@gmail.com","testacc"));
    String Pw = "123456";

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
        if(uids.contains(username)  && password.equals(Pw)){
            startNavigation();
            onLoginSuccess();
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

        if(username.isEmpty() || username.length()<4 || username.length()>255){
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
}
