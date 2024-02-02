package com.example.ghidiemdanhbai.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ghidiemdanhbai.Model.Player;
import com.example.ghidiemdanhbai.R;
import com.example.ghidiemdanhbai.ViewModel.PlayerViewModel;

import java.util.List;

public class NewPlayerAdapter extends RecyclerView.Adapter<NewPlayerAdapter.NewPlayerViewHolder> {
    private Context context;

    private PlayerViewModel playerViewModel; //remember to sort by times played before

    public NewPlayerAdapter(Context context, PlayerViewModel playerViewModel) {
        this.context = context;
        this.playerViewModel = playerViewModel;
    }

    @Override
    public void onBindViewHolder(@NonNull NewPlayerViewHolder holder, int position, @NonNull List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
    }


    @NonNull
    @Override
    public NewPlayerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_player, parent, false);
        return new NewPlayerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NewPlayerViewHolder holder, int position) {
        Player player = playerViewModel.getPlayers().get(position);
        holder.ivPlayerImage.setImageResource(player.getPlayerImage());
        holder.tvPlayerName.setText(player.getPlayerName() + " " + player.getTimesPlayed());
        holder.ivPlayerImage.setOnClickListener(v -> {
            if (!playerViewModel.getPlayersChecked().contains(position)) {
                holder.ivChecked.setVisibility(View.VISIBLE);
                playerViewModel.getPlayersChecked().add(position);
            } else {
                holder.ivChecked.setVisibility(View.INVISIBLE);
                playerViewModel.getPlayersChecked().remove(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return playerViewModel.getPlayers().size();
    }

    class NewPlayerViewHolder extends RecyclerView.ViewHolder {
        TextView tvPlayerName;
        ImageView ivPlayerImage;
        ImageView ivChecked;


        public NewPlayerViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tvPlayerName = itemView.findViewById(R.id.tv_player_name);
            this.ivPlayerImage = itemView.findViewById(R.id.iv_player_image);
            this.ivChecked = itemView.findViewById(R.id.iv_checked);
            ivChecked.setVisibility(View.INVISIBLE);
        }
    }


}
