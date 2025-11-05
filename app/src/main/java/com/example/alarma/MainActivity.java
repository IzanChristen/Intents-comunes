package com.example.alarma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnCrearAlarma, btnNomIntent2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCrearAlarma = findViewById(R.id.btnCrearAlarma);
        btnNomIntent2 = findViewById(R.id.btnNomIntent2);

        // Abre la Activity para crear alarma
        btnCrearAlarma.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AlarmaActivity.class);
            startActivity(intent);
        });

        // Segundo Intent: abrir otra Activity (por ejemplo navegador o llamada)
        btnNomIntent2.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, WebActivity.class);
            startActivity(intent);
        });
    }
}
