package com.example.ghidiemdanhbai.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.ghidiemdanhbai.Data.DataSource;
import com.example.ghidiemdanhbai.Model.Game;
import com.example.ghidiemdanhbai.Adapter.NewPlayerAdapter;
import com.example.ghidiemdanhbai.Utils.TimeUtils;
import com.example.ghidiemdanhbai.ViewModel.GameViewModel;
import com.example.ghidiemdanhbai.ViewModel.PlayerViewModel;
import com.example.ghidiemdanhbai.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class NewGameActivity extends AppCompatActivity {
    private PlayerViewModel playerViewModel;
    private GameViewModel gameViewModel;
    private RecyclerView rvListPlayers;
    private NewPlayerAdapter adapter;
    private FloatingActionButton fabAddNewPlayer;
    private TextView tvNewGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game);

        DataSource dataSource = new DataSource(this);
        playerViewModel = new PlayerViewModel(dataSource);
        gameViewModel = new GameViewModel(dataSource);

        rvListPlayers = findViewById(R.id.rv_list_players);
        rvListPlayers.setLayoutManager(new GridLayoutManager(this, 4));
        adapter = new NewPlayerAdapter(this, playerViewModel);
        rvListPlayers.setAdapter(adapter);

        fabAddNewPlayer = findViewById(R.id.fab_add_new_player);
        fabAddNewPlayer.setOnClickListener(v -> {
            Intent intent = new Intent(NewGameActivity.this, AddPlayerActivity.class);
            startActivity(intent);
        });

        tvNewGame = findViewById(R.id.tv_new_game);
        tvNewGame.setOnClickListener(v -> {

            Game game = new Game(playerViewModel.getPlayersForNewGame().toString(),
                    playerViewModel.getPlayersForNewGame().size(),
                    TimeUtils.getNow());
            gameViewModel.addNewGame(game);
            Intent intent = new Intent(NewGameActivity.this, GameActivity.class);
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("Players' Names", playerViewModel.getPlayersForNewGame());
            intent.putExtras(bundle);
            startActivity(intent);
        });

    }
}