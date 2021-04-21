package com.example.mathrushpro;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.media.MediaPlayer;
import android.widget.Toast;
import android.view.inputmethod.InputMethodManager;


public class MainActivity extends AppCompatActivity {

    private EditText et_nombre;
    private ImageView iv_personaje;
    private TextView tv_bestScore;
    private MediaPlayer mp;

    int num_aleatorio = (int) (Math.random()*10);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        et_nombre = (EditText)findViewById(R.id.txt_nombre);
        iv_personaje = (ImageView)findViewById(R.id.imageView_Personaje);
        tv_bestScore = (TextView)findViewById(R.id.textView_BestScore);

        int id;
        if(num_aleatorio == 0 || num_aleatorio == 10){
            id = getResources().getIdentifier("kraken", "drawable", getPackageName());
            iv_personaje.setImageResource(id);
        } else if(num_aleatorio == 1 || num_aleatorio == 9){
            id = getResources().getIdentifier("centaur", "drawable", getPackageName());
            iv_personaje.setImageResource(id);
        } else if(num_aleatorio == 2 || num_aleatorio == 8){
            id = getResources().getIdentifier("dinosaur", "drawable", getPackageName());
            iv_personaje.setImageResource(id);
        } else if(num_aleatorio == 3 || num_aleatorio == 7){
            id = getResources().getIdentifier("dragon", "drawable", getPackageName());
            iv_personaje.setImageResource(id);
        } else if(num_aleatorio == 4 || num_aleatorio == 5 || num_aleatorio == 6){
            id = getResources().getIdentifier("robot", "drawable", getPackageName());
            iv_personaje.setImageResource(id);
        }

        mp = MediaPlayer.create(this, R.raw.instrumental);
        mp.start();
        mp.setLooping(true);
    }

    public void Jugar(View view){
        String nombre = et_nombre.getText().toString();

        if(!nombre.equals("")){
            mp.stop();
            mp.release();

            Intent intent = new Intent(this, MainActivity2_Nivel1.class);

            intent.putExtra("jugador", nombre);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, "Primero debes escribir tu nombre", Toast.LENGTH_SHORT).show();

            et_nombre.requestFocus();
            InputMethodManager imm = (InputMethodManager)getSystemService(this.INPUT_METHOD_SERVICE);
            imm.showSoftInput(et_nombre, InputMethodManager.SHOW_IMPLICIT);
        }
    }

    @Override
    public void onBackPressed(){

    }
}