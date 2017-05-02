package com.vladan.imagegallery;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created on 5/2/2017.
 */

public class CustomPagerAdapter extends PagerAdapter {

    Activity activity;
    LayoutInflater layoutInflater;
   ArrayList<Bitmap> imageList;

    public CustomPagerAdapter(Activity activity, ArrayList<Bitmap> imageList){
        this.activity=activity;
        this.imageList=imageList;
    }

    @Override
    public int getCount() {
        return imageList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        if (layoutInflater==null)
            layoutInflater=(LayoutInflater)activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View itemView=layoutInflater.inflate(R.layout.pager_item,container,false);
        ImageView imageView=(ImageView)itemView.findViewById(R.id.pager_image);
        imageView.setImageBitmap(imageList.get(position));
        container.addView(itemView);

        return itemView;
    }
}
