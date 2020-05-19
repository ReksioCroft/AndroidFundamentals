package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;

public class onSaveInsatnceActivity extends AppCompatActivity {
    private static final String INPUT_VALUE = "input";
    private static final String CHECKBOX_VALUE = "check";
    private EditText editText;
    private CheckBox checkBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_save_insatnce);

        editText = findViewById(R.id.editText);
        checkBox = findViewById(R.id.checkBox);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(INPUT_VALUE, editText.getText().toString());
        outState.putBoolean(CHECKBOX_VALUE, checkBox.isChecked());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if(savedInstanceState!=null){
            String inputValue = savedInstanceState.getString(INPUT_VALUE);
            Boolean checkValue = savedInstanceState.getBoolean(CHECKBOX_VALUE);

            editText.setText(inputValue);
            checkBox.setSelected(checkValue);
        }
    }
}
