package com.example.ghidiemdanhbai.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.ghidiemdanhbai.R;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        ArrayList<String> playersNames = getIntent().getExtras().getStringArrayList("Players' Names");
        String string = playersNames.toString();
        TextView tv = findViewById(R.id.tv_test);
        tv.setText(string);
    }
}