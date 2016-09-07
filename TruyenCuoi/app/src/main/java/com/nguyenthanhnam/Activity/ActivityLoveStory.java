package com.nguyenthanhnam.Activity;

import ConfigApp.ConfigApp;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.nguyenthanhnam.Adapter.ListStoryAdapter;
import com.nguyenthanhnam.DatabaseSqlite.DataBasemanager;
import com.nguyenthanhnam.Object.ItemStory;
import com.nguyenthanhnam.truyencuoi.R;

import java.util.ArrayList;

/**
 * Created by namnguyenthanhnam on 8/16/2016.
 */
public class ActivityLoveStory extends Activity implements AdapterView.OnItemClickListener {

    private ListStoryAdapter listStoryAdapter;
    private ListView mListView;
    private ArrayList<ItemStory> listStory;
    private DataBasemanager dataBasemanager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_love_story);
        dataBasemanager=new DataBasemanager(ActivityLoveStory.this);
        listStory=new ArrayList<>();
        mListView= (ListView)findViewById(R.id.lovestory);
        initData();
    }


    private void initData(){
        dataBasemanager.selectStoryLike(listStory);
        Log.i("NAM12","STAR:"+listStory.size());
        listStoryAdapter=new ListStoryAdapter(ActivityLoveStory.this,listStory);
        mListView.setAdapter(listStoryAdapter);

        mListView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent();
        intent.setClass(ActivityLoveStory.this, ReadActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable(ConfigApp.KEY_DATA_LISTSTORY, listStory);
        bundle.putInt(ConfigApp.KEY_POSITON, position);
        bundle.putString(ConfigApp.KEY_NAME_STORY, listStory.get(position).getNameStory());
        bundle.putInt(ConfigApp.KEY_ID, listStory.get(position).getId());
        intent.putExtra(ConfigApp.DATA_STORY, bundle);
        listStoryAdapter.setPositioncurrent(position);
        listStoryAdapter.notifyDataSetChanged();
        startActivityForResult(intent,ConfigApp.REQUEST_CODE);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            int position = data.getIntExtra(ConfigApp.RESUILT_DATA, -1);
            listStoryAdapter.setPositioncurrent(position);
            listStoryAdapter.notifyDataSetChanged();
        }
    }
}
