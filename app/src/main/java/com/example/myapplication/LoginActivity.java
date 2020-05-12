package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText emailAddressEditText;
    private EditText phoneEditText;
    private CheckBox termsCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        emailAddressEditText = findViewById(R.id.emailAddressEditText);
        phoneEditText = findViewById(R.id.phoneEditText);
        emailAddressEditText.setText("android@gmail.com");
        termsCheckBox = findViewById(R.id.termsCheckBox);
    }

    public void loginOnClick(View view) { //view-ul pe care facem noi click, in cazul nostru, de buton
        String email = emailAddressEditText.getText().toString();
        String phone = phoneEditText.getText().toString();
        if (email.isEmpty()) {
            emailAddressEditText.setError("Please fill the email address");
        }
        if (phone.isEmpty()) {
            phoneEditText.setError("Please fill the phone number");
        }
        if (termsCheckBox.isChecked() == false) {
            Toast.makeText(this, "Please accept terms and conditions", Toast.LENGTH_LONG).show();
        }
        if (!email.isEmpty() && !phone.isEmpty() && termsCheckBox.isChecked()) {
            Toast.makeText(this, email + " " + phone, Toast.LENGTH_LONG).show();
        }
    }
}
