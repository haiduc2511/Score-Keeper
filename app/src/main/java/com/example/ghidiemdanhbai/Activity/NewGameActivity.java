package com.example.ghidiemdanhbai.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ghidiemdanhbai.Data.DataSource;
import com.example.ghidiemdanhbai.Model.Game;
import com.example.ghidiemdanhbai.Adapter.NewPlayerAdapter;
import com.example.ghidiemdanhbai.Model.Player;
import com.example.ghidiemdanhbai.PlayerItemTouchHelper;
import com.example.ghidiemdanhbai.Utils.TimeUtils;
import com.example.ghidiemdanhbai.ViewModel.GameViewModel;
import com.example.ghidiemdanhbai.ViewModel.PlayerViewModel;
import com.example.ghidiemdanhbai.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

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

        PlayerItemTouchHelper playerItemTouchHelper = new PlayerItemTouchHelper(adapter, playerViewModel);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(playerItemTouchHelper);
        itemTouchHelper.attachToRecyclerView(rvListPlayers);

        fabAddNewPlayer = findViewById(R.id.fab_add_new_player);
        fabAddNewPlayer.setOnClickListener(v -> {
            Intent intent = new Intent(NewGameActivity.this, AddPlayerActivity.class);
            startActivity(intent);
        });

        tvNewGame = findViewById(R.id.tv_new_game);
        tvNewGame.setOnClickListener(v -> {
            //reminder just use getPlayersForNewGame once
            ArrayList<String> playersNamesForNewGame = playerViewModel.getPlayersForNewGame();
            Game game = new Game(playersNamesForNewGame.toString(),
                    playersNamesForNewGame.size(),
                    TimeUtils.getNow());
            gameViewModel.addNewGame(game);
            Intent intent = new Intent(NewGameActivity.this, GameActivity.class);
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("Players' Names", playersNamesForNewGame);
            intent.putExtras(bundle);
            startActivity(intent);
        });

    }
}