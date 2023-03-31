package com.example.lutemon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

public class AddNewLutemon extends AppCompatActivity {

    private EditText name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_lutemon);
        Storage storage = Storage.getInstance();

        name = findViewById(R.id.txtLutemonName);
    }

    public void addLutemon(View view){
        RadioGroup rgColor = findViewById(R.id.rgLutemonColor);
        switch (rgColor.getCheckedRadioButtonId()){
            case R.id.rbBlack:

                break;
            case R.id.rbOrange:
                break;
            case R.id.rbWhite:
                break;
            case R.id.rbPink:
                break;
            case R.id.rbGreen:
                break;

        }
    }

}