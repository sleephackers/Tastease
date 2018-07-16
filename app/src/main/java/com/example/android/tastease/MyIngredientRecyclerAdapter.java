package com.example.android.tastease;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.tastease.food.BodyFood;
import com.example.android.tastease.food.Result;
import com.example.android.tastease.recipeinfo.Ingredient;
import com.example.android.tastease.video.Video;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MyIngredientRecyclerAdapter extends RecyclerView.Adapter<MyIngredientRecyclerAdapter.MyViewHolder> {
    private List<IngredientBody> body;
    private Context context;

    public MyIngredientRecyclerAdapter(List<IngredientBody> body, Context context) {
        this.body = body;
        this.context = context;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.title.setText(body.get(position).getTitle());
        holder.yview.setText(body.get(position).getLikes() + " Likes");
        Picasso.get()
                .load(body.get(position).getImage())
                // .resize(300, 300)
                .into(holder.image);


    }

    @Override
    public int getItemCount() {
        return body.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title, yview;
        ImageView image;

        public MyViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.title);
            yview = view.findViewById(R.id.views);
            image = view.findViewById(R.id.image);
        }
    }
}
