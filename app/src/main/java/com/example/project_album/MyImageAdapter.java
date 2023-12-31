package com.example.project_album;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

// This custom adapter populates the GridView with a visual representation of each thumbnail in the input data set. It also implements a method -getView()- to access individual cells in the GridView.
public class MyImageAdapter extends BaseAdapter {
    private Context context; // main activity’s context
    Integer[] smallImages; // thumbnail data set
    public MyImageAdapter(Context mainActivityContext, Integer[] thumbnails) { context = mainActivityContext; smallImages = thumbnails; }
    // how many entries are there in the data set?
    public int getCount() { return smallImages.length; }
    // what is in a given 'position' in the data set?
    public Object getItem(int position) { return smallImages[position]; }
    // what is the ID of data item in given 'position‘?
    public long getItemId(int position) { return position; }
    // create a view for each thumbnail in the data set, add it to gridview
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
// if possible, reuse (convertView) image already held in cache
        if (convertView == null) {
// no previous version of thumbnail held in the scrapview holder define entry in res/values/dimens.xml for grid height,width in dips <dimen name="gridview_size">100dp</dimen>
// setLayoutParams will do conversion to physical pixels
            imageView = new ImageView(context);
            int gridSize = context.getResources().getDimensionPixelOffset(R.dimen.gridview_size);
            imageView.setLayoutParams(new GridView.LayoutParams(gridSize, gridSize)); imageView.setScaleType(ImageView.ScaleType.FIT_XY); imageView.setPadding(5, 5, 5, 5);
        }
        else { imageView = (ImageView) convertView; }
        imageView.setImageResource(smallImages[position]); imageView.setId(position);
        return imageView;
    }//getView
}//MyImageAdapter