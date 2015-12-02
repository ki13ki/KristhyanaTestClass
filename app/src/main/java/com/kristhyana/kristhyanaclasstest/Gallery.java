package com.kristhyana.kristhyanaclasstest;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class Gallery extends AppCompatActivity {
    private static final String IMAGE_RESOURCE = "image-resource";
    ImageView im;
    int[] img = {R.drawable.frozen, R.drawable.green, R.drawable.pulp, R.drawable.skyfall};
    int count =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        im = (ImageView) findViewById(R.id.imageView);

        if(savedInstanceState != null) {
            Bitmap bitmap = savedInstanceState.getParcelable("image");
            im.setImageBitmap(bitmap);
        }
    }


    public void frozenImage(View view) {
        im.setImageResource(R.drawable.frozen);


    }

    public void greenImage(View view) {
        im.setImageResource(R.drawable.green);
    }

    public void pulpImage(View view) {
        im.setImageResource(R.drawable.pulp);
    }

    public void skyImage(View view) {
        im.setImageResource(R.drawable.skyfall);
    }

    public void nextImage(View view) {
        count++;

        if(count <0){
            count = 3;
        }
        if (count >3){
            count = 0;
        }
        im.setImageResource(img[count]);
    }

    public void prevImage(View view) {
        count--;

        if(count <0){
            count = 3;
        }
        if (count >3){
            count = 0;
        }
        im.setImageResource(img[count]);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        BitmapDrawable drawable = (BitmapDrawable) im.getDrawable();
        Bitmap bitmap = drawable.getBitmap();
        outState.putParcelable("image", bitmap);
        super.onSaveInstanceState(outState);
    }

}
