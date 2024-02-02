package com.example.ghidiemdanhbai.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.ghidiemdanhbai.Data.DataSource;
import com.example.ghidiemdanhbai.Adapter.HistoryAdapter;
import com.example.ghidiemdanhbai.Model.Game;
import com.example.ghidiemdanhbai.R;
import com.example.ghidiemdanhbai.ViewModel.GameViewModel;

import java.util.ArrayList;
import java.util.List;

public class HistoryActivity extends AppCompatActivity {
    private GameViewModel gameViewModel;
    private RecyclerView rvListGames;
    private HistoryAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        gameViewModel = new GameViewModel(new DataSource(this));

        rvListGames = findViewById(R.id.rv_list_games);
        rvListGames.setLayoutManager(new GridLayoutManager(this, 1));
        adapter = new HistoryAdapter(this, gameViewModel);
        rvListGames.setAdapter(adapter);


    }
}