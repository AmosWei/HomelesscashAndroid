package com.example.mac.homelesscash;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {
    String username;
    String email;
    String password;
    private FirebaseDatabase firebaseDatabase;      // database object
    private DatabaseReference databaseReference;    // reference object

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference().child("User");//Firebase writing reference


        final EditText usernameET = findViewById(R.id.usernameET);
        final EditText emailET = findViewById(R.id.passwordET);
        final EditText passwordET = findViewById(R.id.passwordET);

        final Button button = findViewById(R.id.okB);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                username = usernameET.getText().toString();
                email = emailET.getText().toString();
                password = passwordET.getText().toString();
                Donor donor = new Donor(username, email, password, 0);
                databaseReference.child(username).setValue(donor);
            }
        });
    }
}
