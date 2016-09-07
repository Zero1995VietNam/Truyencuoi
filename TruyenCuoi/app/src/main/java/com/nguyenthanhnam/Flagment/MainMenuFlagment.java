package com.nguyenthanhnam.Flagment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.nguyenthanhnam.truyencuoi.R;

/**
 * Created by namnguyenthanhnam on 9/3/2016.
 */
public class MainMenuFlagment extends Fragment implements View.OnClickListener{

    private StoryOfflineFlagment storyOfflineFlagment;
    private StoryOnlineFlagment storyOnlineFlagment;
    private Button btnOnline;
    private Button btnOfline;
    private View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        rootView=inflater.inflate(R.layout.flagment_mainmenu,container,false);
        findViewBys();
        init();
        setEvent();
        initFlagment();
        return rootView;
    }
    private void findViewBys() {
        btnOfline = (Button) rootView.findViewById(R.id.btn_offline);
        btnOnline = (Button)  rootView.findViewById(R.id.btn_online);
    }

    private void init() {

    }

    private void setEvent() {
        btnOfline.setOnClickListener(this);
        btnOnline.setOnClickListener(this);
    }

    private void initFlagment() {
        storyOfflineFlagment = new StoryOfflineFlagment();
        storyOnlineFlagment = new StoryOnlineFlagment();
    }

    private void showFlagmentOnline() {
       //  getFragmentManager().beginTransaction().replace(R.id.mainmenu, storyOnlineFlagment).commit();
        getFragmentManager().beginTransaction().add(R.id.mainmenu,storyOnlineFlagment,"123").addToBackStack("nam").commit();
    }

    private void showFlagmentOffline() {
        //getFragmentManager().beginTransaction().replace(R.id.mainmenu, storyOfflineFlagment).commit();
        getFragmentManager().beginTransaction().add(R.id.mainmenu,storyOfflineFlagment,"1233").addToBackStack("nam123").commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_online:
                showFlagmentOnline();
                break;
            case R.id.btn_offline:
                showFlagmentOffline();
                break;
            default:
                break;
        }
    }
}
