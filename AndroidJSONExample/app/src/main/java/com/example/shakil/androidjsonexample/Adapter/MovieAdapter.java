package com.example.shakil.androidjsonexample.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shakil.androidjsonexample.Model.Movie;
import com.example.shakil.androidjsonexample.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {

    Context context;
    List<Movie> movieList;

    public MovieAdapter(Context context, List<Movie> movieList) {
        this.context = context;
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.layout_item, viewGroup, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        Picasso.get().load(movieList.get(i).getImageurl()).into(myViewHolder.image);
        myViewHolder.txt_name.setText(movieList.get(i).getName());
        myViewHolder.txt_team.setText(movieList.get(i).getTeam());
        myViewHolder.txt_createdby.setText(movieList.get(i).getCreatedby());
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView txt_name, txt_team, txt_createdby;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.image);
            txt_name = itemView.findViewById(R.id.txt_name);
            txt_team = itemView.findViewById(R.id.txt_team);
            txt_createdby = itemView.findViewById(R.id.txt_createdby);
        }
    }
}
