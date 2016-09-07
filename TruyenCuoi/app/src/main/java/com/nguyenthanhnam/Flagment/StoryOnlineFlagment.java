package com.nguyenthanhnam.Flagment;

import ConfigApp.ConfigApp;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.nguyenthanhnam.Adapter.RecycleViewAdapter;
import com.nguyenthanhnam.HtmlPaser.HTMLParse;
import com.nguyenthanhnam.truyencuoi.R;

/**
 * Created by namnguyenthanhnam on 8/31/2016.
 */
public class StoryOnlineFlagment extends Fragment implements View.OnClickListener {

    private Button mBtn1, mBtn2;
    private RecyclerView recyclerView;
    private HTMLParse htmlParse;
    private RecycleViewAdapter recycleViewAdapter;
    private View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        rootView=inflater.inflate(R.layout.flagment_storyonline,container,false);
        findViewBys();
        init();
        htmlParse = new HTMLParse(recycleViewAdapter, recyclerView, getActivity());
        htmlParse.execute(ConfigApp.URL1);
        setEvent();
        return rootView;
    }

    private void findViewBys() {
        mBtn1 = (Button) rootView.findViewById(R.id.btn1);
        mBtn2 = (Button) rootView.findViewById(R.id.btn2);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.myrecyclerview);
    }
    private void init() {

        recyclerView.setAdapter(recycleViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
        itemAnimator.setAddDuration(1000);
        itemAnimator.setRemoveDuration(1000);
        recyclerView.setItemAnimator(itemAnimator);
    }

    private void setEvent() {
        mBtn1.setOnClickListener(this);
        mBtn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                htmlParse = new HTMLParse(recycleViewAdapter, recyclerView, getActivity());
                htmlParse.execute(ConfigApp.URL1);
                break;
            case R.id.btn2:
                htmlParse = new HTMLParse(recycleViewAdapter, recyclerView, getActivity());
                htmlParse.execute(ConfigApp.URL2);
                break;
            default:
                break;
        }
    }
}
