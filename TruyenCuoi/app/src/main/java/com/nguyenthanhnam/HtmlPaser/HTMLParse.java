package com.nguyenthanhnam.HtmlPaser;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import com.nguyenthanhnam.Adapter.RecycleViewAdapter;
import com.nguyenthanhnam.Object.StoryOnline;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by namnguyenthanhnam on 8/30/2016.
 */
public class HTMLParse extends AsyncTask<String, Void, Void> {
    private ArrayList<StoryOnline> listOnline = new ArrayList<>();
    private RecycleViewAdapter recycleViewAdapter;
    private ProgressDialog progressDialog;
    private RecyclerView recyclerView;
    private Context context;

    public HTMLParse(RecycleViewAdapter recycleViewAdapter, RecyclerView recyclerView, Context context) {
        this.recycleViewAdapter = recycleViewAdapter;
        this.recyclerView = recyclerView;
        this.context = context;
    }

    public void getAllData(String link) {

        try {
            Document document = Jsoup.connect(link).get();
            Elements listData = document.select("div.post-meta");
            if (listData == null) {

                return;
            }
            for (int i = 0; i < listData.size(); i++) {
                Element linkUrl = listData.get(i).select("a").get(0);
                String url = linkUrl.attr("href");
                Log.i("TAG",url +"");
                String nameStory = linkUrl.attr("title");
                Log.i("TAG",nameStory +"");
                Elements imageUrl = listData.get(i).select("a img");
                String image = imageUrl.attr("src");
                Log.i("TAG",image+"");
                if(image.equals("")==false){
                    StoryOnline storyOnline = new StoryOnline(image, nameStory, url);
                    listOnline.add(storyOnline);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog=new ProgressDialog(context);
        progressDialog.setTitle("Dang Load.....");
        progressDialog.setMessage("LOADING");
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
    }

    @Override
    protected Void doInBackground(String... params) {
        getAllData(params[0]);
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        recycleViewAdapter=new RecycleViewAdapter(context,listOnline);
        recyclerView.setAdapter(recycleViewAdapter);
        progressDialog.dismiss();
        super.onPostExecute(aVoid);
    }
}
