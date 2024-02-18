package com.example.ghidiemdanhbai.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ghidiemdanhbai.R;
import com.example.ghidiemdanhbai.ViewModel.MatchViewModel;

import java.util.List;

public class MatchPlayerAdapter extends RecyclerView.Adapter<MatchPlayerAdapter.MatchViewHolder> {
    private Context context;
    private MatchViewModel matchViewModel;
    private List<String> resultList;

    public MatchPlayerAdapter(Context context, MatchViewModel matchViewModel) {
        this.context = context;
        this.matchViewModel = matchViewModel;
        resultList = matchViewModel.getListPlayer();
    }

    @Override
    public void onBindViewHolder(@NonNull MatchViewHolder holder, int position, @NonNull List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
    }


    @NonNull
    @Override
    public MatchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_match_player, parent, false);
        return new MatchViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MatchViewHolder holder, int position) {
        holder.tvMatchPlayerName.setText(resultList.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }

    class MatchViewHolder extends RecyclerView.ViewHolder {
        TextView tvMatchPlayerName;


        public MatchViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tvMatchPlayerName = itemView.findViewById(R.id.tv_match_player_name);
        }
    }


}