package com.example.aula8app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void exercicio1(View view) {Intent intent = new Intent(this, Exercicio1.class); startActivity(intent);}

    public void exercicio2(View view) {Intent intent = new Intent(this, Exercicio2.class); startActivity(intent);}

    public void exercicio3(View view) {Intent intent = new Intent(this, Exercicio3.class); startActivity(intent);}

}