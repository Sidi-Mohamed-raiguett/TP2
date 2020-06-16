package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView counteurView;
    private Button incrementBtn, decrementBtn,resetBtn, intentExampleBtn;
    private int valeur = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

//        compteurText.setText("Sidi Mohamed");



        setListener();


    }

    private void setListener() {
        incrementBtn.setOnClickListener(this);
        decrementBtn.setOnClickListener(this);
        resetBtn.setOnClickListener(this);
        intentExampleBtn.setOnClickListener(this);
    }

    private void initView() {
        counteurView = findViewById(R.id.compteur);
        counteurView.setText(Integer.toString(valeur));
        incrementBtn = findViewById(R.id.increment);
        decrementBtn = findViewById(R.id.decrement);
        resetBtn = findViewById(R.id.reset);
        intentExampleBtn = findViewById(R.id.intentExampne);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.increment:
                counteurView.setText(Integer.toString(++valeur));
                break;
            case R.id.decrement:
                counteurView.setText(Integer.toString(--valeur));
                break;
            case R.id.reset:
                valeur = 0;
                counteurView.setText(Integer.toString(valeur));
                break;
            case R.id.intentExampne:
                setContentView(R.layout.activity_intent_example);
            default:{

            }
        }
    }
}