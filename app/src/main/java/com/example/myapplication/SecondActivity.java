package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    public static final String ECHO = "echo";
    public static final int ECHO_CHANNEL = 713;
    public static final String RESPONSE_ECHO = "response";

    private EditText editTextMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        editTextMessage = findViewById(R.id.editTextMessage);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String message = bundle.getString(Main2Activity.MESSAGE);
            Toast.makeText(SecondActivity.this, message, Toast.LENGTH_LONG).show();
        }
    }

    public void sendMessegeToActivityOnClick(View view) {
        Intent intent = new Intent(SecondActivity.this, Main3Activity.class);
        intent.putExtra(ECHO, "are you there?" );
        startActivityForResult(intent, ECHO_CHANNEL);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==ECHO_CHANNEL && resultCode==RESULT_OK) {
            String resultFromThirdActivity = data.getStringExtra(RESPONSE_ECHO);
            editTextMessage.setText(resultFromThirdActivity);
        }
    }
}
