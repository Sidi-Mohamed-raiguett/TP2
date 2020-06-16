package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener{

    TextView firstText, secondeText, resultText;
    Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        initView();
        getDataFromFirstActivityIntent();
    }

    private void getDataFromFirstActivityIntent() {
        firstText.setText(getIntent().getStringExtra("first_number"));
        secondeText.setText(getIntent().getStringExtra("second_number"));

        /*
        Bundle bundle = getIntent().getBundleExtra("data");
        firstText.setText(bundle.getString("first_number"));
        secondeText.setText(bundle.getString("seconde_number"));
         */

        int result = Integer.parseInt(firstText.getText().toString())+Integer.parseInt(secondeText.getText().toString());
        resultText.setText(String.valueOf(result));

    }

    private void initView() {
        firstText = findViewById(R.id.firstText);
        secondeText = findViewById(R.id.secondText);
        resultText = findViewById(R.id.resultatText);
        backBtn = findViewById(R.id.backBtn);
        backBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.backBtn){
            Intent intent = new Intent(getBaseContext(), IntentExample.class);
            intent.putExtra("sum", resultText.getText().toString());
            startActivity(intent);
        }
    }
}