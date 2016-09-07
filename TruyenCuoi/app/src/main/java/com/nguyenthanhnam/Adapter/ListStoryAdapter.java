package com.nguyenthanhnam.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.nguyenthanhnam.Object.ItemStory;
import com.nguyenthanhnam.truyencuoi.R;

import java.util.ArrayList;

/**
 * Created by Nam on 6/25/2016.
 */
public class ListStoryAdapter extends BaseAdapter {

    private ArrayList<ItemStory> listStory;
    private ArrayList<ItemStory> arrStory;
    private LayoutInflater mLayoutInflater;
    private Context mContext;
    private int positioncurrent = -1;

    public ListStoryAdapter(Context context, ArrayList<ItemStory> object) {
        mContext = context;
        listStory = new ArrayList<>();
        listStory = object;

    }

    @Override
    public int getCount() {
        return listStory.size();
    }

    @Override
    public Object getItem(int position) {
        return listStory.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder;
        mLayoutInflater = LayoutInflater.from(mContext);
        if (view == null) {
            view = mLayoutInflater.inflate(R.layout.itemstory, parent, false);
            holder = new ViewHolder();
            holder.mTxtStory = (TextView) view.findViewById(R.id.txt_item);
            holder.mTxtchude = (TextView) view.findViewById(R.id.txt_chude);
            view.setTag(holder);

        }
        holder = (ViewHolder) view.getTag();

        if (position == positioncurrent) {
            view.setBackgroundColor(Color.parseColor("#81D4FA"));
        } else {
            view.setBackgroundColor(Color.WHITE);
        }
        ItemStory itemStory = listStory.get(position);
        holder.mTxtStory.setText(itemStory.getNameStory());
        holder.mTxtchude.setText(itemStory.getType());
        return view;
    }

    public void setPositioncurrent(int positioncurrent) {
        this.positioncurrent = positioncurrent;
    }

    private class ViewHolder {
        TextView mTxtStory, mTxtchude;
    }

}
