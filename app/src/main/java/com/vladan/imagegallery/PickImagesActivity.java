package com.vladan.imagegallery;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class PickImagesActivity extends AppCompatActivity {

    Button pickImageButton;
    EditText writeImagesLabel;
    ArrayList<Bitmap> imageList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_images);


    }
}
