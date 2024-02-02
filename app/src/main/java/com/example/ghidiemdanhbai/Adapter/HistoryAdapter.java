package com.example.ghidiemdanhbai.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ghidiemdanhbai.Model.Game;
import com.example.ghidiemdanhbai.R;
import com.example.ghidiemdanhbai.ViewModel.GameViewModel;

import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder> {
    private Context context;

    private GameViewModel gameViewModel; //remember to sort by Date before

    public HistoryAdapter(Context context, GameViewModel gameViewModel) {
        this.context = context;
        this.gameViewModel = gameViewModel;
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryViewHolder holder, int position, @NonNull List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
    }


    @NonNull
    @Override
    public HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_game, parent, false);
        return new HistoryViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryViewHolder holder, int position) {
        Game game = gameViewModel.getGames().get(position);
        holder.tvGameId.setText(Integer.toString(game.getGameId()));
        holder.tvGamePlayersNames.setText(game.getGamePlayersNames());
        holder.tvGameNumberOfPlayers.setText(Integer.toString(game.getGameNumberOfPlayers()));
        holder.tvGameDate.setText(game.getGameDate());
    }

    @Override
    public int getItemCount() {
        return gameViewModel.getGames().size();
    }

    class HistoryViewHolder extends RecyclerView.ViewHolder {
        TextView tvGameId;
        TextView tvGamePlayersNames;
        TextView tvGameNumberOfPlayers;
        TextView tvGameDate;


        public HistoryViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tvGameId = itemView.findViewById(R.id.tv_game_id);
            this.tvGamePlayersNames = itemView.findViewById(R.id.tv_game_players_names);
            this.tvGameNumberOfPlayers = itemView.findViewById(R.id.tv_game_number_of_players);
            this.tvGameDate = itemView.findViewById(R.id.tv_game_date);
        }
    }


}

