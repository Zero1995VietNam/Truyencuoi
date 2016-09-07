package com.nguyenthanhnam.Activity;

import ConfigApp.ConfigApp;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.nguyenthanhnam.Adapter.ReadAdapter;
import com.nguyenthanhnam.HtmlPaser.ParseHtmlForRead;
import com.nguyenthanhnam.truyencuoi.R;

/**
 * Created by namnguyenthanhnam on 9/3/2016.
 */
public class ReadOnlineActivity extends Activity {
    private ListView mListView;
    private ReadAdapter adapter;
    private String url;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flagment_readstoryonline);
        mListView= (ListView) findViewById(R.id.listviewread);
        Intent intent=getIntent();
        url=intent.getStringExtra(ConfigApp.KEY_POSITION_LINK);
        ParseHtmlForRead parseHtmlForRead=new ParseHtmlForRead(mListView,adapter,this);
        parseHtmlForRead.execute(url);
        findViewBys();

    }
    private void findViewBys(){


    }
    private void init(){
    }
    private void setEvent(){

    }
}
