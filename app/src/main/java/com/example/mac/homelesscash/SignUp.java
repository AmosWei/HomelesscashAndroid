package com.example.mac.homelesscash;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/*
 * Created by Hubert, modified on 16/09/19
 */
public class SignUp extends AppCompatActivity {
    Button okB;
    EditText emET,pwET;
    String email,password;

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
