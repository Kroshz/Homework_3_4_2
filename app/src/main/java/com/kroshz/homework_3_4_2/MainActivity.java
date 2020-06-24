package com.kroshz.homework_3_4_2;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Spinner mLanguageSpinner;

    private Spinner mMargeSpinner;
    private Button mOkButton;
    private TextView mTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        mLanguageSpinner = findViewById(R.id.languageSpinner);
        mMargeSpinner = findViewById(R.id.margeSpinner);
        mOkButton = findViewById(R.id.okButton);
        mTv = findViewById(R.id.tv);
        initLanguageSpinner();
        initMargeSpinner();
        mOkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                switch (mLanguageSpinner.getSelectedItem().toString()) {
                    case "Russian": case "Русский": {
                        switchLocale("ru");
                        break;
                    }
                    case "English": case "Английский":{
                        switchLocale("en");
                        break;
                    }
                }
                switch (mMargeSpinner.getSelectedItem().toString()) {
                    case "Large": case "Большая": {
                        Utils.changeToTheme( MainActivity.this, Utils.THEME_LARGE);
                        break;
                    }
                    case "Middle": case "Средняя": {
                        Utils.changeToTheme( MainActivity.this, Utils.THEME_MIDDLE);
                        break;
                    }
                    case "Small": case "Маленькая": {
                        Utils.changeToTheme( MainActivity.this, Utils.THEME_SMALL);
                        break;
                    }
                }
            }
        });
    }


    private void initLanguageSpinner() {
        ArrayAdapter<CharSequence> adapterCountries = ArrayAdapter.createFromResource(this, R.array.countries, android.R.layout.simple_spinner_item);
        adapterCountries.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mLanguageSpinner.setAdapter(adapterCountries);
    }

    private void initMargeSpinner() {
        ArrayAdapter<CharSequence> adapterMarge = ArrayAdapter.createFromResource(this, R.array.margins, android.R.layout.simple_spinner_item);
        adapterMarge.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mMargeSpinner.setAdapter(adapterMarge);
    }


    private void switchLocale(String language) {
        Locale locale = new Locale(language);
        Configuration config = new Configuration();
        config.setLocale(locale);
        getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        recreate();
    }

}
