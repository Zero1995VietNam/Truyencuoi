package com.nguyenthanhnam.Object;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.nguyenthanhnam.truyencuoi.R;

/**
 * Created by namnguyenthanhnam on 8/30/2016.
 */
public class ItemRowHolder extends RecyclerView.ViewHolder {

    public ImageView imageView;
    public TextView mTxtTitle;
    public CardView mCardView;
    public ItemRowHolder(View itemView) {
        super(itemView);
        imageView = (ImageView) itemView.findViewById(R.id.imageView);
        mTxtTitle = (TextView) itemView.findViewById(R.id.txtView);
        mCardView= (CardView) itemView.findViewById(R.id.cardView);
    }

}
