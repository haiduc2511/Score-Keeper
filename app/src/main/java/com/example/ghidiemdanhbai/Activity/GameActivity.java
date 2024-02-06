package com.example.ghidiemdanhbai.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.ghidiemdanhbai.Adapter.MatchAdapter;
import com.example.ghidiemdanhbai.Fragment.AddUpdateMatchFragment;
import com.example.ghidiemdanhbai.Data.DataSource;
import com.example.ghidiemdanhbai.R;
import com.example.ghidiemdanhbai.ViewModel.GameViewModel;
import com.example.ghidiemdanhbai.ViewModel.MatchViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class GameActivity extends AppCompatActivity {
    private MatchViewModel matchViewModel;
    private GameViewModel gameViewModel;
    private RecyclerView rvListMatches;
    private MatchAdapter adapter;
    private FloatingActionButton fabAddMatch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        String playersNames = getIntent().getExtras().getString("Players' Names");
        int gameId = getIntent().getExtras().getInt("Game's id", -2);
        TextView tv = findViewById(R.id.tv_test);
        tv.setText(playersNames +  " " + gameId);

        DataSource dataSource = new DataSource(this);
        gameViewModel = new GameViewModel(dataSource);

        if (gameId == -1) {
            matchViewModel = new MatchViewModel(dataSource, gameViewModel.getLatestGame());
        } else {
            //-1 vì chỉ số index đầu của sql là 1 còn Array java là 0
            matchViewModel = new MatchViewModel(dataSource, gameViewModel.getGames().get(gameId - 1));
        }

        TextView tv2 = findViewById(R.id.textView);
        tv2.setText(Integer.toString(matchViewModel.getGame().getGameId()));
//
        rvListMatches = findViewById(R.id.rv_list_matches);
        rvListMatches.setLayoutManager(new GridLayoutManager(this, 1));
        adapter = new MatchAdapter(this, matchViewModel, gameViewModel);
        rvListMatches.setAdapter(adapter);

        fabAddMatch = findViewById(R.id.fab_add_match);
        fabAddMatch.setOnClickListener(v -> {
            FragmentManager fragmentManager = getSupportFragmentManager();
            AddUpdateMatchFragment addUpdateMatchFragment = new AddUpdateMatchFragment(this, matchViewModel, gameViewModel);
            fragmentManager.beginTransaction()
                    .add(R.id.fragment_container, addUpdateMatchFragment)
                    .addToBackStack(null)
                    .commit();

        });
    }
}