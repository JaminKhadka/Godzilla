package com.example.registerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity {
    EditText username, password, dob, address, email, phone;
    RadioGroup gender;
    Button Register;

    SharedPreferences preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        dob = findViewById(R.id.dob);
        address = findViewById(R.id.address);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.num);
        gender = findViewById(R.id.gender);

        Register = findViewById(R.id.register);


        preferences = getSharedPreferences("Userinfo", 0);

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernameValue = username.getText().toString();
                String passwordValue = password.getText().toString();
                String dobValue = dob.getText().toString();
                String addressValue = address.getText().toString();
                String phonenumberValue = phone.getText().toString();
                String emailValue = email.getText().toString();
                RadioButton checkedbtn = findViewById(gender.getCheckedRadioButtonId());
                String genderValue = checkedbtn.getText().toString();

                SharedPreferences.Editor editor=preferences.edit();
                if(passwordValue.length()>5) {
                    editor.putString("username", usernameValue);
                    editor.putString("password", passwordValue);
                    editor.putString("dob", dobValue);
                    editor.putString("address", addressValue);
                    editor.putString("phonenumber", phonenumberValue);
                    editor.putString("email", emailValue);
                    editor.putString("gender", genderValue);
                    editor.apply();
                    Toast.makeText(MainActivity.this, "User Registered", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "Enter Value in the field", Toast.LENGTH_SHORT).show();
                }

            }
        });



    }
}
