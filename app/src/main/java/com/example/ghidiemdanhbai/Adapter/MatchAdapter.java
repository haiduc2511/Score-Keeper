package com.example.ghidiemdanhbai.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ghidiemdanhbai.Model.Match;
import com.example.ghidiemdanhbai.R;
import com.example.ghidiemdanhbai.ViewModel.GameViewModel;
import com.example.ghidiemdanhbai.ViewModel.MatchViewModel;

import java.util.List;

public class MatchAdapter extends RecyclerView.Adapter<MatchAdapter.MatchViewHolder> {
    private Context context;
    private MatchViewModel matchViewModel;
    private GameViewModel gameViewModel;

    public MatchAdapter(Context context, MatchViewModel matchViewModel, GameViewModel gameViewModel) {
        this.context = context;
        this.matchViewModel = matchViewModel;
        this.gameViewModel = gameViewModel;
    }

    @Override
    public void onBindViewHolder(@NonNull MatchViewHolder holder, int position, @NonNull List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
    }


    @NonNull
    @Override
    public MatchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_match, parent, false);
        return new MatchViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MatchViewHolder holder, int position) {
        Match match = matchViewModel.getMatches().get(position);
        holder.tvMatchId.setText(Integer.toString(match.getMatchId()));
        holder.tvMatchGameId.setText(Integer.toString(match.getMatchGameId()));
        holder.tvMatchPlayersNames.setText(match.getMatchPlayersNames());
        holder.tvMatchPlayersResults.setText(match.getMatchPlayersResults());
    }

    @Override
    public int getItemCount() {
        return matchViewModel.getMatches().size();
    }

    class MatchViewHolder extends RecyclerView.ViewHolder {
        TextView tvMatchId;
        TextView tvMatchGameId;
        TextView tvMatchPlayersNames;
        TextView tvMatchPlayersResults;


        public MatchViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tvMatchId = itemView.findViewById(R.id.tv_match_id);
            this.tvMatchGameId = itemView.findViewById(R.id.tv_match_game_id);
            this.tvMatchPlayersNames = itemView.findViewById(R.id.tv_match_players_names);
            this.tvMatchPlayersResults = itemView.findViewById(R.id.tv_match_players_results);
        }
    }


}