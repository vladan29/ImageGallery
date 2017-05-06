package com.vladan.imagegallery;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

/**
 * Created on 5/2/2017.
 */

public class CustomPagerAdapter extends PagerAdapter {

    Activity activity;
    LayoutInflater layoutInflater;
    ArrayList<Integer> pickImageId = new ArrayList<>();

    public CustomPagerAdapter(Activity activity, ArrayList<Integer> pickImageId) {
        this.activity = activity;
        this.pickImageId = pickImageId;
    }

    @Override
    public int getCount() {
        return pickImageId.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {

        if (layoutInflater == null)
            layoutInflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = layoutInflater.inflate(R.layout.pager_item, container, false);
        ImageView imageView = (ImageView) itemView.findViewById(R.id.pager_image);
        imageView.setImageResource(pickImageId.get(position));
        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}
