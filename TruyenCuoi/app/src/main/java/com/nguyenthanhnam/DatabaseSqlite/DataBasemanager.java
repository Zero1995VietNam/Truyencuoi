package com.nguyenthanhnam.DatabaseSqlite;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.util.Log;
import com.nguyenthanhnam.Object.ItemStory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by namnguyenthanhnam on 8/3/2016.
 */
public class DataBasemanager {
    private static final String PATHDB = Environment.getDataDirectory().getPath() + "/data/com.nguyenthanhnam.truyencuoi/databases";
    private static final String DB_NAME = "TruyenCuoi.sqlite";
    private SQLiteDatabase mSqLiteDatabase;
    public static final String COLUMN_STT = "STT";
    public static final String TABLE_NAME = "DanhSachTruyen";
    public static final String COLUMN_THELOAI = "TheLoai";
    public static final String COLUMN_UATHICH = "UuThich";

    public DataBasemanager(Context context) {
        copyDB(context);
        openDB();
    }

    public void openDB() {
        if (mSqLiteDatabase == null || !mSqLiteDatabase.isOpen()) {
            mSqLiteDatabase = SQLiteDatabase.openDatabase(PATHDB + "/" + DB_NAME, null, SQLiteDatabase.OPEN_READWRITE);

        }
    }

    public void copyDB(Context context) {
        new File(PATHDB).mkdir();
        File db = new File(PATHDB + "/" + DB_NAME);
        if (db.exists()) {
            return;
        }
        AssetManager assetManager = context.getAssets();
        try {
            InputStream input = assetManager.open(DB_NAME);
            FileOutputStream output = new FileOutputStream(db);
            byte b[] = new byte[102];
            int lenght = input.read(b);
            while (lenght > 0) {
                output.write(b, 0, lenght);
                lenght = input.read(b);
            }
            input.close();
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeDB() {
        if (mSqLiteDatabase != null && mSqLiteDatabase.isOpen()) {
            mSqLiteDatabase.close();
        }
    }

    public void selectStory(String category, List<ItemStory> listStory) {
        String sqlite = "SELECT * FROM DanhSachTruyen WHERE TheLoai='"+category+"' ";
        Cursor cursor = mSqLiteDatabase.rawQuery(sqlite, null);
        if (cursor != null) {
            cursor.moveToFirst();
            int idIndex=cursor.getColumnIndex("STT");
            int nameStoryIndex = cursor.getColumnIndex("TenTruyen");
            int typeIndex = cursor.getColumnIndex("TheLoai");
            int countryIndex = cursor.getColumnIndex("QuocGia");
            int contentIndex = cursor.getColumnIndex("NoiDung");
            int likeIndex = cursor.getColumnIndex("UuThich");

            while (cursor.isAfterLast() == false) {
                String nameStory, type, country, content;
                int like,id;
                id=cursor.getInt(idIndex);
                nameStory = cursor.getString(nameStoryIndex);
                type = cursor.getString(typeIndex);
                country = cursor.getString(countryIndex);
                content = cursor.getString(contentIndex);
                like = cursor.getInt(likeIndex);
                Log.i("NAM",like+"");
                ItemStory item = new ItemStory(id,nameStory, type, country, content, like);
                listStory.add(item);
                cursor.moveToNext();
            }
        }
    }

    public boolean update(int id, int likeNew) {

        ContentValues values = new ContentValues();
        values.put(COLUMN_UATHICH,likeNew);
        int resuilt=mSqLiteDatabase.update(TABLE_NAME, values,COLUMN_STT+ "=" + id, null);
        if(resuilt!=0){
            return true;
        }else{
            return false;
        }
    }
    public void selectStoryLike(List<ItemStory> listStoryLike ){
        String sqlite = "SELECT * FROM DanhSachTruyen WHERE UuThich=1";
        Cursor cursor = mSqLiteDatabase.rawQuery(sqlite, null);
        if (cursor != null) {
            cursor.moveToFirst();
            int idIndex=cursor.getColumnIndex("STT");
            int nameStoryIndex = cursor.getColumnIndex("TenTruyen");
            int typeIndex = cursor.getColumnIndex("TheLoai");
            int countryIndex = cursor.getColumnIndex("QuocGia");
            int contentIndex = cursor.getColumnIndex("NoiDung");
            int likeIndex = cursor.getColumnIndex("UuThich");

            while (cursor.isAfterLast() == false) {
                String nameStory, type, country, content;
                int like,id;
                id=cursor.getInt(idIndex);
                nameStory = cursor.getString(nameStoryIndex);
                type = cursor.getString(typeIndex);
                country = cursor.getString(countryIndex);
                content = cursor.getString(contentIndex);
                like = cursor.getInt(likeIndex);
                Log.i("NAM",like+"");
                ItemStory item = new ItemStory(id,nameStory, type, country, content, like);
                listStoryLike.add(item);
                cursor.moveToNext();
            }
        }
    }
}
