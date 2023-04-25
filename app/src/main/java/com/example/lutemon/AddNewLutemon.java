package com.example.lutemon;

import static java.security.AccessController.getContext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class AddNewLutemon extends AppCompatActivity {

    private EditText name;
    private Storage storage;
    private int picture;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_lutemon);
        storage = Storage.getInstance();
        name = findViewById(R.id.txtLutemonName);
        Spinner spinner = (Spinner) findViewById(R.id.sLutemonPicture);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.picturenames, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    public void addLutemon(View view){
        Home home = Storage.getInstance().getHome();
        RadioGroup rgColor = findViewById(R.id.rgLutemonColor);
        picture  = getPictureId(view);
        switch (rgColor.getCheckedRadioButtonId()){
            case R.id.rbBlack:
                home.createLutemon(new Black(name.getText().toString(), picture));
                break;
            case R.id.rbOrange:
                home.createLutemon(new Orange(name.getText().toString(), picture));
                break;
            case R.id.rbWhite:
                home.createLutemon(new White(name.getText().toString(), picture));
                break;
            case R.id.rbPink:
                home.createLutemon(new Pink(name.getText().toString(), picture));
                break;
            case R.id.rbGreen:
                home.createLutemon(new Green(name.getText().toString(), picture));
                break;

        }
    }
    private int getPictureId(View view){
        Spinner spinner = findViewById(R.id.sLutemonPicture);
        picture = 0;
        switch (spinner.getSelectedItemPosition()) {
            case 0:
                picture = R.drawable.a;
                break;
            case 1:
                picture = R.drawable.b;
                break;
            case 2:
                picture = R.drawable.c;
                break;
            case 3:
                picture = R.drawable.d;
                break;
            case 4:
                picture = R.drawable.e;
                break;
            case 5:
                picture = R.drawable.f;
                break;
            case 6:
                picture = R.drawable.g;
                break;
            case 7:
                picture = R.drawable.h;
                break;
            case 8:
                picture = R.drawable.i;
                break;
            case 9:
                picture = R.drawable.j;
                break;
            case 10:
                picture = R.drawable.k;
                break;
            case 11:
                picture = R.drawable.l;
                break;
            case 12:
                picture = R.drawable.m;
                break;
        }
        return picture;
    }

}