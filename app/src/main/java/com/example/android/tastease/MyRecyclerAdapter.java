package com.example.android.tastease;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.tastease.video.Video;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder> {

    private List<Video> videos;
    private Context context;

    public MyRecyclerAdapter(List<Video> videos, Context context) {
        this.videos = videos;
        this.context = context;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.title.setText(videos.get(position).getTitle());
        holder.yview.setText(videos.get(position).getViews().toString() + " Views");
        Picasso.get()
                .load(videos.get(position).getThumbnail())
                // .resize(300, 300)
                .into(holder.image);

    }

    @Override
    public int getItemCount() {
        return videos.size();
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
