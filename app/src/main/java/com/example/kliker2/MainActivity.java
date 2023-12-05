package com.example.kliker2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;


public class MainActivity extends AppCompatActivity {

    TextView numer;
    Button button;
    Button reset;
    Switch przelacz;
    Integer liczenie;
    Integer dodawanie;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        numer = findViewById(R.id.textView);
        button = findViewById(R.id.button);
        liczenie = 0;
        reset = findViewById(R.id.button2);
        przelacz = findViewById(R.id.switch1);
        dodawanie = 1;


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                liczenie = liczenie + dodawanie;
                numer.setText(String.valueOf(liczenie));
            }
        });



        reset.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick (View view){

                liczenie = 0;
                numer.setText(String.valueOf(liczenie));
            }
        });


        przelacz.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(przelacz.isChecked()) {
                    dodawanie = -1;
                }

                else {
                    dodawanie = 1;
                }

                int wartosc = Integer.parseInt(numer.getText().toString());

                if (wartosc < 0){
                    numer.setText("0");
                    liczenie = 0;
                }

            }

        });
    }
}