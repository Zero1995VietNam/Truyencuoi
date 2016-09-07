package com.nguyenthanhnam.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.nguyenthanhnam.truyencuoi.R;

/**
 * Created by namnguyenthanhnam on 8/30/2016.
 */
public class SingleHolder extends RecyclerView.ViewHolder {
    public ImageView mImageStory;
    public TextView mNameStory;
    public TextView mChapterStory;


    public SingleHolder(View itemView) {
        super(itemView);
        mImageStory= (ImageView) itemView.findViewById(R.id.image_item_story);
        mNameStory= (TextView) itemView.findViewById(R.id.text_item_name_sotry);
        mChapterStory= (TextView) itemView.findViewById(R.id.text_item_chapter_sotry);

    }
}
