package com.nguyenthanhnam.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.nguyenthanhnam.Object.ItemMenu;
import com.nguyenthanhnam.truyencuoi.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by namnguyenthanhnam on 8/5/2016.
 */
public class MenuApadapter extends BaseAdapter {

    private List<ItemMenu> listMenu = new ArrayList<>();
    private Context context;
    private LayoutInflater mLayoutInflater;

    public MenuApadapter(Context context, List<ItemMenu> listMenu) {
        this.context = context;
        this.listMenu = listMenu;
    }


    @Override
    public int getCount() {
        return listMenu.size();
    }



    @Override
    public Object getItem(int position) {
        return listMenu.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        mLayoutInflater = LayoutInflater.from(context);
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.item_menu, parent, false);
        }
        ImageView image_menu = (ImageView) convertView.findViewById(R.id.img_likemenu);
        TextView txtDescription = (TextView) convertView.findViewById(R.id.txtdescription);

        ItemMenu item = listMenu.get(position);

        image_menu.setImageResource(item.getImage());
        txtDescription.setText(item.getDescription());

        return convertView;
    }

}
