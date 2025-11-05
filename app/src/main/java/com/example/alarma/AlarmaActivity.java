package com.example.alarma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class AlarmaActivity extends AppCompatActivity {

    EditText etHora, etMinuto, etMensaje;
    Button btnCrearAlarma;
    ImageButton returnButton1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarma);

        etHora = findViewById(R.id.etHora);
        etMinuto = findViewById(R.id.etMinuto);
        etMensaje = findViewById(R.id.etMensaje);
        btnCrearAlarma = findViewById(R.id.btnDefinirAlarma);
        btnCrearAlarma.setOnClickListener(v -> crearAlarma());
        returnButton1 = findViewById(R.id.returnButton1);

        returnButton1.setOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });
    }

    private void crearAlarma() {
        String horaStr = etHora.getText().toString().trim();
        String minutoStr = etMinuto.getText().toString().trim();
        String mensaje = etMensaje.getText().toString().trim();

        if (horaStr.isEmpty() || minutoStr.isEmpty() || mensaje.isEmpty()) {
            Toast.makeText(this, "Rellena todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        int hora, minuto;
        try {
            hora = Integer.parseInt(horaStr);
            minuto = Integer.parseInt(minutoStr);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Introduce números válidos para hora y minutos", Toast.LENGTH_SHORT).show();
            return;
        }

        if (hora < 0 || hora > 23 || minuto < 0 || minuto > 59) {
            Toast.makeText(this, "La hora debe estar entre 0–23 y los minutos entre 0–59", Toast.LENGTH_LONG).show();
            return;
        }

        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_HOUR, hora)
                .putExtra(AlarmClock.EXTRA_MINUTES, minuto)
                .putExtra(AlarmClock.EXTRA_MESSAGE, mensaje)
                .putExtra(AlarmClock.EXTRA_VIBRATE, true)
                .putExtra(AlarmClock.EXTRA_SKIP_UI, false);
        startActivity(intent);
    }
}
