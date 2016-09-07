package com.nguyenthanhnam.Adapter;

import ConfigApp.ConfigApp;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.nguyenthanhnam.Activity.ReadOnlineActivity;
import com.nguyenthanhnam.Object.ItemRowHolder;
import com.nguyenthanhnam.Object.StoryOnline;
import com.nguyenthanhnam.truyencuoi.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by namnguyenthanhnam on 8/30/2016.
 */

public class RecycleViewAdapter extends RecyclerView.Adapter<ItemRowHolder> {
    private Context mContext;
    private ArrayList<StoryOnline> listStoryOnline;

    public RecycleViewAdapter(Context mContext, ArrayList<StoryOnline> listStoryOnline) {
        this.mContext = mContext;
        this.listStoryOnline = listStoryOnline;
    }

    @Override
    public ItemRowHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, null);
        ItemRowHolder rowHolder = new ItemRowHolder(v);
        return rowHolder;
    }

    @Override
    public void onBindViewHolder(ItemRowHolder holder, final int position) {
        final StoryOnline storyOnline = listStoryOnline.get(position);
        Picasso.with(mContext).load(storyOnline.getImageUrl()).error(R.mipmap.ic_launcher).into(holder.imageView);
        holder.mTxtTitle.setText(storyOnline.getNameStory());
        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mContext, ReadOnlineActivity.class);
                intent.putExtra(ConfigApp.KEY_POSITION_LINK,listStoryOnline.get(position).getLink());
                mContext.startActivity(intent);
            }
        });

    }
    @Override
    public int getItemCount() {
        return listStoryOnline.size();
    }


}
