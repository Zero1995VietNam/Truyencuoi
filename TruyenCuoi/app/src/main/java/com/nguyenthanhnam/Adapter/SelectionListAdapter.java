package com.nguyenthanhnam.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.nguyenthanhnam.Object.StoryOnline;
import com.nguyenthanhnam.ViewHolder.SingleHolder;
import com.nguyenthanhnam.truyencuoi.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by namnguyenthanhnam on 8/30/2016.
 */
public class SelectionListAdapter extends RecyclerView.Adapter<SingleHolder> {
    private Context mContext;
    private ArrayList<StoryOnline> listStoryOnline;

    public SelectionListAdapter(Context mContext, ArrayList<StoryOnline> listStoryOnline) {
        this.mContext = mContext;
        this.listStoryOnline = listStoryOnline;
    }

    @Override
    public SingleHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_single_card, null);
        SingleHolder holder = new SingleHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(SingleHolder holder, int position) {
        StoryOnline storyOnline = listStoryOnline.get(position);
        Picasso.with(mContext).load(storyOnline.getImageUrl()).error(R.mipmap.ic_launcher).into(holder.mImageStory);
        holder.mNameStory.setText(storyOnline.getNameStory());

    }

    @Override
    public int getItemCount() {
        return listStoryOnline.size();
    }
}
