package com.nguyenthanhnam.ViewPager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.nguyenthanhnam.Object.ItemStory;
import com.nguyenthanhnam.truyencuoi.R;

import java.util.List;

/**
 * Created by namnguyenthanhnam on 8/4/2016.
 */
public class PagerStory extends PagerAdapter {
    private List<ItemStory> listPager;
    private LayoutInflater mInflater;

    public PagerStory(Context contex, List<ItemStory> listPager) {
        mInflater = LayoutInflater.from(contex);
        this.listPager = listPager;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return listPager.get(position).getNameStory();
    }

    @Override
    public int getCount() {
        return listPager.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = mInflater.inflate(R.layout.itempager, container, false);
        TextView txtContent= (TextView) view.findViewById(R.id.content_story);

        ItemStory item=listPager.get(position);
        txtContent.setText(item.getContent());

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
       container.removeView((View) object);
    }
}
