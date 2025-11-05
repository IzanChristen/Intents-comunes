package com.example.alarma;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class WebActivity extends AppCompatActivity {

    EditText etUrl;
    Button btnAbrirWeb;

    ImageButton returnButton1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        etUrl = findViewById(R.id.etUrl);
        btnAbrirWeb = findViewById(R.id.btnAbrirWeb);

        btnAbrirWeb.setOnClickListener(v -> abrirWeb());

        returnButton1 = findViewById(R.id.returnButton1);

        returnButton1.setOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });

    }
    private void abrirWeb() {
        String url = etUrl.getText().toString().trim();

        if (url.contains(".")) {
            if (!url.startsWith("http://") && !url.startsWith("https://")) {
                url = "https://" + url;
            }
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);}
        else {
            Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
            intent.putExtra(SearchManager.QUERY, url);
            startActivity(intent);
        }
    }
}
