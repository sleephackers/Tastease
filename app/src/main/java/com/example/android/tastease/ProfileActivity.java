package com.example.android.tastease;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {
    EditText allergies,username,emailid;
    Button save;
    String allergy="",nameuser="User",email="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        allergies=findViewById(R.id.allergies);
        username=findViewById(R.id.username);
        emailid=findViewById(R.id.emailid);
        save=findViewById(R.id.save);
        loadInfo();
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameuser=username.getText().toString();
                allergy=allergies.getText().toString();
                email=emailid.getText().toString();
                saveInfo();
                finish();
            }
        });

    }
    private void saveInfo() {
        SharedPreferences sharedpref = getSharedPreferences("userdetails", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpref.edit();
        editor.putString("Username",nameuser);
        editor.putString("Allergy",allergy);
        editor.putString("Email",email);
        editor.apply();
        Log.e(ProfileActivity.class.getSimpleName(),"Savingggg"+ nameuser);
    }
    private void loadInfo() {
        SharedPreferences sharedpref = getSharedPreferences("userdetails", MODE_PRIVATE);
        allergies.setText(sharedpref.getString("Allergy",""));
        username.setText(sharedpref.getString("Username","User"));
        emailid.setText(sharedpref.getString("Email",""));


    }
}
