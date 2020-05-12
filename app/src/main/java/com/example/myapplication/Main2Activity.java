package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Lifecycle;

import android.util.Log;
import android.view.View;

public class Main2Activity extends AppCompatActivity {
    public static String MESSAGE = "message";
    public static String COUNT = "count";
    private static String TAG = "LifecycleTestActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Log.e(TAG, "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG, "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy");
    }

    public void openSecondActivityOnClick(View view) {
        Intent intent = new Intent(Main2Activity.this, SecondActivity.class);
        intent.putExtra(MESSAGE, "hello second activity");
        ///trimit mesaj de la main2activity la secondactivity
        intent.putExtra(COUNT, 13);
        startActivity(intent);
    }

    public void callOnClick(View view) {
        //implicit intent
        Intent callImplicitIntent = new Intent(Intent.ACTION_DIAL);
        callImplicitIntent.setData(Uri.parse("tel:0700000000"));

        //check if the implicit intent could be run n the current device
        if (callImplicitIntent.resolveActivity(getPackageManager()) != null)
            startActivity(callImplicitIntent);
        else {
            //display an alert...
        }
    }

    public void openLinkOnLink(View view) {
        //implicit intent to open an url inside a browser
        Intent openUrlImplicitIntent = new Intent(Intent.ACTION_VIEW);
        openUrlImplicitIntent.setData(Uri.parse("https://developer.android.com/"));
        startActivity(openUrlImplicitIntent);
    }


}

