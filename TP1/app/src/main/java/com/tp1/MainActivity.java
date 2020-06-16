package com.tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText nameEdit,ageEdit,tailleEdit;
    String mention = " ";
    Button mentionBtn;
    public static final String EXTRA_MESSAGE = "com.tp1.MESSAGE";
    private static final String TAG = "MyLog";
    private Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        nameEdit = findViewById(R.id.nameEdit);
        ageEdit = findViewById(R.id.ageEdit);
        tailleEdit = findViewById(R.id.tailleEdit);
        mentionBtn = findViewById(R.id.mentionBtn);
        mentionBtn.setOnClickListener(this);
        Log.v(TAG, getString(R.string.env_trai));
    }

    @Override
    public void onClick(View view) {
        if (isNumeric(tailleEdit.getText().toString()) == true){
            if(Double.parseDouble(tailleEdit.getText().toString()) == 1.7){
                mention = "moyenne";
            }
            else if (Double.parseDouble(tailleEdit.getText().toString()) > 1.7){
                mention = "élancée";
            }
            else if (Double.parseDouble(tailleEdit.getText().toString()) < 1.7){
                mention = "courte";
            }
            Intent intent = new Intent(getBaseContext(), MainActivity2.class);
            intent.putExtra("name_text", nameEdit.getText().toString());
            intent.putExtra("age_text", ageEdit.getText().toString());
            intent.putExtra("taille_text", tailleEdit.getText().toString());
            intent.putExtra(EXTRA_MESSAGE,mention);
            startActivity(intent);
            Log.i(TAG, getString(R.string.env_trai2));
        }
        else{
            Log.e(TAG, "Traitement échoué ! "+tailleEdit.getText().toString());
        }
    }

    public boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        return pattern.matcher(strNum).matches();
    }
}