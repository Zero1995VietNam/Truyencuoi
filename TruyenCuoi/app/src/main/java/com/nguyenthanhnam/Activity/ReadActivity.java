package com.nguyenthanhnam.Activity;

import ConfigApp.ConfigApp;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.nguyenthanhnam.DatabaseSqlite.DataBasemanager;
import com.nguyenthanhnam.Object.ItemStory;
import com.nguyenthanhnam.ViewPager.PagerStory;
import com.nguyenthanhnam.truyencuoi.R;

import java.util.ArrayList;

/**
 * Created by namnguyenthanhnam on 8/4/2016.
 */
public class ReadActivity extends Activity implements ViewPager.OnPageChangeListener, View.OnClickListener {

    private TextView mTxtNameStory;
    private ImageView mImageLike;
    private ViewPager mViewPaggerContent;
    private ArrayList<ItemStory> listStory;
    private int index;
    private int like,id;
    private boolean check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_readstory);

        findViewBys();
        initData();
        init();
        setEvent();
    }

    private void findViewBys() {
        mTxtNameStory = (TextView) findViewById(R.id.name_story);
        mImageLike = (ImageView) findViewById(R.id.img_like);
        mViewPaggerContent = (ViewPager) findViewById(R.id.view_story);

        mViewPaggerContent.addOnPageChangeListener(this);
    }

    private void initData() {
        Intent intent = getIntent();
        Bundle data = intent.getBundleExtra(ConfigApp.DATA_STORY);
        listStory = (ArrayList<ItemStory>) data.getSerializable(ConfigApp.KEY_DATA_LISTSTORY);
        PagerStory pagerAdapter = new PagerStory(this, listStory);
        mViewPaggerContent.setAdapter(pagerAdapter);
        int positon = data.getInt(ConfigApp.KEY_POSITON);
        String nameStory = data.getString(ConfigApp.KEY_NAME_STORY);
        id = data.getInt(ConfigApp.KEY_ID);
        like=data.getInt(ConfigApp.KEY_LIKE);
        if(like==0){
            check=false;
        }
        mTxtNameStory.setText(nameStory);
        mViewPaggerContent.setCurrentItem(positon);
    }

    private void init() {

    }

    private void setEvent() {
        mImageLike.setOnClickListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        mTxtNameStory.setText(listStory.get(position).getNameStory());
        index = position;
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onBackPressed() {
        Intent returnIntent = new Intent();
        returnIntent.putExtra(ConfigApp.RESUILT_DATA, index);
        setResult(RESULT_OK, returnIntent);
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_like:
                if (check == false) {
                    if (new DataBasemanager(this).update(id, 1) == true) {
                        Toast.makeText(this, "Them vao danh sach ua thich cua ban", Toast.LENGTH_SHORT).show();
                    }
                    ;
                    check = true;
                } else if (check == true) {
                    new DataBasemanager(this).update(id, 0);
                    Toast.makeText(this, "Xoa khoi danh sach ua thich cua ban", Toast.LENGTH_SHORT).show();
                    check = false;
                }
                break;
        }
    }
}
