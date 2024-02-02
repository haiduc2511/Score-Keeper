package com.example.ghidiemdanhbai.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.ghidiemdanhbai.Data.DataSource;
import com.example.ghidiemdanhbai.Model.Player;
import com.example.ghidiemdanhbai.ViewModel.PlayerViewModel;
import com.example.ghidiemdanhbai.R;

public class AddPlayerActivity extends AppCompatActivity {
    private PlayerViewModel playerViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_player);

        playerViewModel = new PlayerViewModel(new DataSource(getApplicationContext()));

        EditText etPlayerName = findViewById(R.id.et_player_name);
        Button btAddPlayer = findViewById(R.id.bt_add_player);

        btAddPlayer.setOnClickListener(v -> {
            Player player = new Player(etPlayerName.getText().toString(), 0,
                    R.drawable.baseline_person_24);
            playerViewModel.addNewPlayer(player);
            etPlayerName.setText("");
        });
    }
}