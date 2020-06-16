package com.example.myfirstgame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button buttonOK;
    private EditText editTextNumber;
    private TextView textViewIndication, textView3Score, textView5Tentative;
    private ProgressBar progressBar;
    private ListView listViewHistorique;
    private int secret, counter, score, maxTentatives = 6;
    private List<String> listHistorique = new ArrayList<String>();
    private ArrayAdapter<String> model;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.e(TAG, "onCreate: called ....");

        buttonOK = findViewById(R.id.buttonOK);
        editTextNumber = findViewById(R.id.editTextNumber);
        textViewIndication = findViewById(R.id.textViewIndication);
        progressBar = findViewById(R.id.progressBar);
        textView5Tentative = findViewById(R.id.textView5);
        textView3Score = findViewById(R.id.textView3);
        listViewHistorique = findViewById(R.id.listeViewHistorique);
        textView3Score = findViewById(R.id.textView3);

        model = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,listHistorique);
        listViewHistorique.setAdapter(model);

        initialisation();

        buttonOK.setOnClickListener((evt) -> {
            int number = Integer.parseInt(editTextNumber.getText().toString());
//            int res = number * 11;
//            textViewIndication.setText(String.valueOf(res));
            if(number > secret){
                textViewIndication.setText(R.string.valeur_sup);
            }
            else if(number < secret) {
                textViewIndication.setText(R.string.valeur_inf);
            }
            else {
                textViewIndication.setText(R.string.bravo);
                score+=5;
                textView3Score.setText(String.valueOf(score));
                rejouer();
            }
            listHistorique.add(counter+"=>"+number);
            model.notifyDataSetChanged();
            ++counter;
            textView5Tentative.setText(String.valueOf(counter));
            progressBar.setProgress(counter);
            if(counter > maxTentatives){
                rejouer();
            }
            });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG,"La methode onStart a ete appele ....");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG,"La methode onResume a ete appele ....");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG,"La methode onStop a ete appele ....");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG,"La methode onPause a ete appele ....");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG,"La methode onDestroy a ete appele ....");
    }

    private void rejouer() {
        Log.i("MyLog", "REJOUER....");
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle(getString(R.string.rejouer));
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, getString(R.string.oui), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                initialisation();
            }
        });
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, getString(R.string.quitter), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        alertDialog.show();
    }

    private void initialisation() {
        secret = (1 + (int)(Math.random()*100));
        Log.i("MyLog","Secret: "+secret);
        counter = 1;
        listHistorique.clear();
        model.notifyDataSetChanged();
        textView5Tentative.setText(String.valueOf(counter));
        progressBar.setProgress(counter);
        progressBar.setMax(maxTentatives);
        textView3Score.setText(String.valueOf(score));
    }
}