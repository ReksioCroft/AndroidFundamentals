package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.strictmode.IntentReceiverLeakedViolation;

///magicianul - activitate cu palarie din slides
public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            String messageFromActivity = bundle.getString(SecondActivity.ECHO);
            if(messageFromActivity!=null && messageFromActivity.length()>3 ){
                String response = "yes, yes... I am here";
                Intent intent = new Intent();
                intent.putExtra(SecondActivity.RESPONSE_ECHO, response );
                setResult(RESULT_OK, intent);
                //RESULT_OK it means that we are ok
                finish();
            }
        }
    }
}
