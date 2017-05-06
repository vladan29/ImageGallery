package com.vladan.imagegallery;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created  on 5/3/2017.
 */

public class CustomListAdapter extends BaseAdapter {

    Activity activity;
    LayoutInflater layoutInflater;
    int[] imageId;
    boolean[] isBoxChecked;


    public CustomListAdapter(Activity activity, int[] imageId, boolean[] isBoxChecked) {
        this.isBoxChecked = isBoxChecked;
        this.activity = activity;
        this.imageId = imageId;
    }

    @Override
    public int getCount() {
        return imageId.length;
    }

    @Override
    public Object getItem(int position) {
        return imageId[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            layoutInflater = (LayoutInflater) activity
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

            convertView = layoutInflater.inflate(R.layout.fragment_item, parent, false);
        }
        ImageView offerImage = (ImageView) convertView.findViewById(R.id.offer_image);
        TextView imagePosition = (TextView) convertView.findViewById(R.id.image_position);
        final CheckBox checkBox = (CheckBox) convertView.findViewById(R.id.check_box);
        checkBox.setChecked(isBoxChecked[position]);


        offerImage.setImageResource(imageId[position]);
        imagePosition.setText("Position is:" + " " + position + " " + "from a total of" +
                " " + imageId.length + " " + "images");
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (checkBox.isChecked()) {
                    isBoxChecked[position] = true;
                    checkBox.setChecked(isBoxChecked[position]);
                    PickImagesActivity.pickImageId.add(imageId[position]);
                } else {
                    isBoxChecked[position] = false;
                    checkBox.setChecked(isBoxChecked[position]);

                    for (int i = 0; i < PickImagesActivity.pickImageId.size(); i++) {
                        if (imageId[position] == PickImagesActivity.pickImageId.get(i)) {
                            PickImagesActivity.pickImageId.remove(i);
                        }
                    }
                }


            }


        });


        return convertView;
    }
}
