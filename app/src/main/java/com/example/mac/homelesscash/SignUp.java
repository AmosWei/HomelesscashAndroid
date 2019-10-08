package com.example.mac.homelesscash;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SignUp extends AppCompatActivity {
    String email;
    String password;
    private FirebaseDatabase firebaseDatabase;      // database object
    private DatabaseReference databaseReference;    // reference object
    private ValueEventListener valueEventListener;  // listener for database reading*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference().child("User");//Firebase writing reference


        final EditText emailET = findViewById(R.id.emET);
        final EditText passwordET = findViewById(R.id.pwET);

        final Button button = findViewById(R.id.okB);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                email = emailET.getText().toString();
                password = passwordET.getText().toString();
                Donor donor = new Donor(email, password);
                //databaseReference.child(email).setValue(donor);
                databaseReference.push().setValue(donor);
                emailET.setText(password);
            }
        });
    }
}
