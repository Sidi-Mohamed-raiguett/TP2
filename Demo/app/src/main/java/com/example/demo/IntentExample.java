package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class IntentExample extends AppCompatActivity implements View.OnClickListener{

    EditText firstEdit, secondEdit;
    Button calculateBtn;
    TextView sumText;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_example);
        
        initView();
        getDataFromSecondActivityIntent();
    }

    private void getDataFromSecondActivityIntent() {
        if (getIntent().hasExtra("sum")){
            sumText.setText("Somme = " + getIntent().getStringExtra("sum"));
        }
    }

    private void initView() {
        firstEdit = findViewById(R.id.firstEdt);
        secondEdit = findViewById(R.id.secondEdt);
        calculateBtn = findViewById(R.id.calculateBtn);
        calculateBtn.setOnClickListener(this);
        sumText = findViewById(R.id.sumText);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.calculateBtn){
            if(isEditTextEmpty(firstEdit) || isEditTextEmpty(secondEdit))
                return;
            Intent intent = new Intent(getBaseContext(), SecondActivity.class);

//            Bundle bundle = new Bundle();
//            bundle.putString("first_number", firstEdit.getText().toString());
//            bundle.putString("second_number", secondEdit.getText().toString());
//            intent.putExtra("data", bundle);

            intent.putExtra("first_number", firstEdit.getText().toString());
            intent.putExtra("second_number", secondEdit.getText().toString());
            startActivity(intent);

        }
    }

    private boolean isEditTextEmpty(EditText editText) {
        if (editText.getText().toString().isEmpty()){
            editText.requestFocus();
            editText.setError("champ obligatoire!");
            return true;
        }
        return false;
    }
}