package edu.utsa.cs3443.leaderboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import edu.utsa.cs3443.leaderboard.model.Player;

public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.PlayerViewHolder>{
    private ArrayList<Player> playerList;
    private Context context;

    public PlayerAdapter(Context context, ArrayList<Player> playerList) {
        this.context = context;
        this.playerList = playerList;
    }

    @NonNull
    @Override
    public PlayerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.player_card, parent, false);
        return new PlayerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlayerAdapter.PlayerViewHolder holder, int position) {
        Player player = playerList.get(position);
        holder.txtName.setText(player.getName());
        holder.txtScore.setText("Score: " + player.getScore());

        // Load image with Glide
        Glide.with(context)
                .load(player.getImgUrl())
                .into(holder.imgPlayer);
    }

    @Override
    public int getItemCount() {
        return playerList.size();
    }

    static class PlayerViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPlayer;
        TextView txtName, txtScore;

        public PlayerViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPlayer = itemView.findViewById(R.id.img_player);
            txtName = itemView.findViewById(R.id.txt_name);
            txtScore = itemView.findViewById(R.id.txt_score);
        }
    }
}
