package com.kristhyana.kristhyanaclasstest;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class KContent extends AppCompatActivity {
ImageView frozen, green, pulp, skyfall;
    View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kcontent);
        frozen = (ImageView) findViewById(R.id.frozenIm);
        green = (ImageView) findViewById(R.id.greenIm);
        pulp = (ImageView) findViewById(R.id.pulpIm);
        skyfall= (ImageView) findViewById(R.id.skyFallIm);




        registerForContextMenu(frozen);
        registerForContextMenu(green);
        registerForContextMenu(pulp);
        registerForContextMenu(skyfall);

    }
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.im_menu, menu);
            view = v;

    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.hide) {
            if (view.getId() == R.id.frozenIm){
                frozen.setVisibility(View.INVISIBLE);
            }
            if (view.getId() == R.id.greenIm){
                green.setVisibility(View.INVISIBLE);
            }
            if (view.getId() == R.id.pulpIm){
                pulp.setVisibility(View.INVISIBLE);
            }
            if (view.getId() == R.id.skyFallIm){
                skyfall.setVisibility(View.INVISIBLE);
            }

        }
        if (item.getItemId() == R.id.share) {
            Intent intent = new Intent(Intent.ACTION_SEND);
            Uri imageURI = null;
            if(view.getId() == R.id.frozenIm) {
                imageURI = Uri.parse("android.resource://com.kristhyana.kristhyanaclasstest/drawable/" + R.drawable.frozen);
            }
            if(view.getId() == R.id.greenIm) {
                imageURI = Uri.parse("android.resource://com.kristhyana.kristhyanaclasstest/drawable/" + R.drawable.green);
            }
            if(view.getId() == R.id.pulpIm) {
                imageURI = Uri.parse("android.resource://com.kristhyana.kristhyanaclasstest/drawable/" + R.drawable.pulp);
            }
            if(view.getId() == R.id.skyFallIm) {
                imageURI = Uri.parse("android.resource://com.kristhyana.kristhyanaclasstest/drawable/" + R.drawable.skyfall);
            }
            intent.setType("image/*");
            intent.putExtra(Intent.EXTRA_STREAM,imageURI);

            //        Intent chooser = Intent.createChooser(intent, "Send Image");
            startActivity(intent);

        }
        return super.onContextItemSelected(item);
    }




}

