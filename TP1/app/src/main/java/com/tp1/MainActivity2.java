package com.tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener{

    TextView nameText,ageText,tailleText,mention;
    Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        initView();
        getDataFromFirstActivityIntent();
    }

    private void initView() {
        nameText = findViewById(R.id.nameText);
        ageText = findViewById(R.id.ageText);
        tailleText = findViewById(R.id.tailleText);
        backBtn = findViewById(R.id.backBtn);
        backBtn.setOnClickListener(this);
        mention = findViewById(R.id.mention);
    }

    private void getDataFromFirstActivityIntent() {
        nameText.setText(getIntent().getStringExtra("name_text"));
        ageText.setText(getIntent().getStringExtra("age_text"));
        tailleText.setText(getIntent().getStringExtra("taille_text"));
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        mention.setText(message);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getBaseContext(), MainActivity.class);
        startActivity(intent);
    }
}