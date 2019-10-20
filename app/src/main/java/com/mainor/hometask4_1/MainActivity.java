package com.mainor.hometask4_1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText km, mi;
    TextView kmText, miText;
    final double milesToKm = 1.609344;
    private static DecimalFormat df = new DecimalFormat("0.00");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        km = findViewById(R.id.mainactivity_kilometers);
        mi = findViewById(R.id.mainactivity_miles);
        kmText = findViewById(R.id.mainactivity_textview_kilometers);
        miText = findViewById(R.id.mainactivity_textview_miles);




        kmText.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v){

                km.setVisibility(View.VISIBLE);
                mi.setVisibility(View.GONE);
                miText.setVisibility(View.VISIBLE);
                kmText.setVisibility(View.GONE);

            }});

        miText.setOnClickListener (new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                mi.setVisibility(View.VISIBLE);
                km.setVisibility(View.GONE);
                kmText.setVisibility(View.VISIBLE);
                miText.setVisibility(View.GONE);
            }});

        km.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                mi.setVisibility(View.GONE);
                miText.setVisibility(View.VISIBLE);
                miText.setText("");
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                if (km.getText().length()!= 0) {

                    double a = Double.parseDouble(String.valueOf(km.getText()));
                    double b = a/milesToKm;

                    String k = "";

                    if (b==1 ){
                        k = " Mile";

                    }else{
                        k = " Miles";
                    }

                    miText.setText(df.format(b) + k);

                }

            }
        });

        mi.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                km.setVisibility(View.GONE);
                kmText.setVisibility(View.VISIBLE);
                kmText.setText("");
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                if (mi.getText().length()!= 0) {

                    double a = Double.parseDouble(String.valueOf(mi.getText()));
                    double b = a*milesToKm;

                    String k = "";

                    if (b==1 ){
                        k = " Kilometer";

                    }else{
                        k = " Kilometers";
                    }



                    kmText.setText(df.format(b) + k);

                }

            }
        });


    }
}
