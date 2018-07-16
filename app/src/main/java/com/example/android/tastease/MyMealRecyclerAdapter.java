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
import com.example.android.tastease.mealplan.Meal;
import com.example.android.tastease.mealplan.MealBody;
import com.example.android.tastease.video.Video;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MyMealRecyclerAdapter extends RecyclerView.Adapter<MyMealRecyclerAdapter.MyViewHolder> {
    private MealBody body;
    private List<Meal> results;
    private Context context;

    public MyMealRecyclerAdapter(MealBody mealBody, Context context) {
        this.body = mealBody;
        this.results = mealBody.getMeals();
        this.context = context;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.title.setText(results.get(position).getTitle());
        holder.yview.setText(results.get(position).getReadyInMinutes() + " Min");
        Picasso.get()
                .load(results.get(position).getImage())
                // .resize(300, 300)
                .into(holder.image);


    }

    @Override
    public int getItemCount() {
        return results.size();
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
