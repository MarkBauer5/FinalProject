package com.example.finalproject;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private int nrTiles;
    private GameActivity gameActivity;
    public ImageAdapter(Context c, int nrOfTiles, GameActivity setGameActivity) {
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
//            gameActivity.theBoard.setLayoutParams(new RelativeLayout.LayoutParams(gameActivity.gridviewHolder.getWidth(),
//                    gameActivity.gridviewHolder.getHeight()));
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
//            GridView.LayoutParams mImageViewLayoutParams = new GridView.LayoutParams(
//                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
//            imageView.setLayoutParams(mImageViewLayoutParams);
            System.out.println("URFKSHKUHWUIHUIF" + gameActivity.gridview.getHeight());
            //gameActivity.gridview.setVerticalSpacing(gameActivity.gridview.getHeight()/6);
            imageView.setLayoutParams(new GridView.LayoutParams(gameActivity.gridview.getWidth()/7,
                    gameActivity.gridview.getHeight()/6));

            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            int pad = 10;
            imageView.setPadding(pad, pad, pad, pad);
        } else {
            //imageView = (ImageView) convertView;
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(gameActivity.gridview.getWidth()/7,
                    gameActivity.gridview.getHeight()/6));
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            int pad = 10;
            imageView.setPadding(pad, pad, pad, pad);
        }
        imageView.setBackgroundColor(Color.TRANSPARENT);
        imageView.setImageResource(R.drawable.empty_t);
        return imageView;
    }
}
