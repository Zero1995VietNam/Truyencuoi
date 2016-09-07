package com.nguyenthanhnam.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.nguyenthanhnam.Object.ReadItem;
import com.nguyenthanhnam.truyencuoi.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by namnguyenthanhnam on 9/3/2016.
 */
public class ReadAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<ReadItem> listItem;

    public ReadAdapter(Context mContext, ArrayList<ReadItem> listItem) {
        this.mContext = mContext;
        this.listItem = listItem;
    }

    @Override
    public int getCount() {
        return listItem.size();
    }

    @Override
    public Object getItem(int position) {
        return listItem.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHoler viewHoler;
        LayoutInflater layoutInflater=LayoutInflater.from(mContext);
        if(convertView==null){
            convertView=layoutInflater.inflate(R.layout.itemread,parent,false);
            viewHoler=new ViewHoler();
            viewHoler.imageRead= (ImageView) convertView.findViewById(R.id.imageitem);
            convertView.setTag(viewHoler);
        }
        viewHoler= (ViewHoler) convertView.getTag();
        ReadItem readItem=listItem.get(position);
        Picasso.with(mContext).load(readItem.getImageRead()).into(viewHoler.imageRead);
        return convertView;
    }

    private class ViewHoler{
        ImageView imageRead;
    }
}
