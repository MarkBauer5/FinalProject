package com.example.finalproject;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by UDU on 02.11.2016.
 */

public class FrameAdapter extends BaseAdapter {
    private Context mContext;
    private int nrTiles;
    private GameActivity gameActivity;
    public FrameAdapter(Context c, int nrOfTiles, GameActivity setGameActivity) {
        mContext = c;
        this.nrTiles = nrOfTiles;
        gameActivity = setGameActivity;
    }

    public int getCount() {
        return nrTiles;
    }
    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
//            GridView.LayoutParams mImageViewLayoutParams = new GridView.LayoutParams(
//                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
//            imageView.setLayoutParams(mImageViewLayoutParams);
            //gameActivity.gridview.setVerticalSpacing(gameActivity.gridview.getHeight()/6);
            imageView.setLayoutParams(new GridView.LayoutParams(gameActivity.gridframe.getWidth()/7,
                    gameActivity.gridframe.getHeight()/6));

            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            int pad = 10;
            imageView.setPadding(pad, pad, pad, pad);
        } else {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(gameActivity.gridframe.getWidth()/7,
                    gameActivity.gridframe.getHeight()/6));
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            int pad = 10;
            imageView.setPadding(pad, pad, pad, pad);
        }
        imageView.setImageResource(R.drawable.frame);
        return imageView;
    }





}
