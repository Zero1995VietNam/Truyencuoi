package com.nguyenthanhnam.HtmlPaser;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.nguyenthanhnam.Adapter.ReadAdapter;
import com.nguyenthanhnam.Object.ReadItem;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by namnguyenthanhnam on 9/3/2016.
 */
public class ParseHtmlForRead extends AsyncTask<String, Void, Void> {
    private ArrayList<ReadItem>
            listRead = new ArrayList<>();
    private ListView mListView;
    private ReadAdapter readAdapter;
    private ProgressDialog progressDialog;
    private Context mContext;


    public ParseHtmlForRead(ListView mListView, ReadAdapter readAdapter, Context mContext) {
        this.mListView = mListView;
        this.readAdapter = readAdapter;
        this.mContext = mContext;
    }

    private void getDataread(String link) {
        try {
            Document document = Jsoup.connect(link).get();
            Elements listData = document.select("div.wp-caption");
            if (listData == null) {
                return;
            }
            for (int i = 0; i < listData.size(); i++) {
                Elements linkImage = listData.get(i).select("img");
                String image = linkImage.attr("src");
                ReadItem readItem = new ReadItem(image);
                listRead.add(readItem);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog=new ProgressDialog(mContext);
        progressDialog.setTitle("Dang Load...");
        progressDialog.setMessage("LOADDING");
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
    }


    @Override
    protected Void doInBackground(String... params) {
        getDataread(params[0]);
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        readAdapter=new ReadAdapter(mContext,listRead);
        mListView.setAdapter(readAdapter);
        progressDialog.dismiss();
    }
}
