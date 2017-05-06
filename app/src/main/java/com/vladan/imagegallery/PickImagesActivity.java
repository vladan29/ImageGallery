package com.vladan.imagegallery;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class PickImagesActivity extends AppCompatActivity {

    Button pickImageButton;

    public static ArrayList<Integer> pickImageId = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_images);

        final int[] imageId = new int[10];
        imageId[0] = R.drawable.image_1;
        imageId[1] = R.drawable.image_2;
        imageId[2] = R.drawable.image_3;
        imageId[3] = R.drawable.image_4;
        imageId[4] = R.drawable.image_5;
        imageId[5] = R.drawable.image_6;
        imageId[6] = R.drawable.image_7;
        imageId[7] = R.drawable.image_8;
        imageId[8] = R.drawable.image_9;
        imageId[9] = R.drawable.image_10;


        pickImageButton = (Button) findViewById(R.id.pick_image_button);
        pickImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = PickImagesActivity.this.getSupportFragmentManager();
                FragmentTransaction transaction = fm.beginTransaction();
                PickImageFragment pickImage = new PickImageFragment();
                Bundle bundle = new Bundle();
                bundle.putIntArray("offerId", imageId);

                pickImage.setArguments(bundle);
                transaction.replace(R.id.frame_container, pickImage);
                transaction.addToBackStack(null);

                transaction.commit();

            }
        });
        Button setButton = (Button) findViewById(R.id.set_image_button);
        setButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm1 = PickImagesActivity.this.getSupportFragmentManager();
                FragmentTransaction tr = fm1.beginTransaction();
                PagerFragment pagerFragment = new PagerFragment();
                Bundle bundle = new Bundle();
                bundle.putIntegerArrayList("pickImageId", pickImageId);

                pagerFragment.setArguments(bundle);
                tr.replace(R.id.frame_container, pagerFragment);
                tr.addToBackStack(null);
                tr.commit();

                Toast.makeText(getApplicationContext(), pickImageId.toString(), Toast.LENGTH_LONG).show();
            }
        });

    }
}
