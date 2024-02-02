package com.example.ghidiemdanhbai.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.ghidiemdanhbai.R;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.bt_new_game).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, NewGameActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.bt_history).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, HistoryActivity.class);
            startActivity(intent);
        });
    }
}