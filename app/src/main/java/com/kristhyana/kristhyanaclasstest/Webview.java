package com.kristhyana.kristhyanaclasstest;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Webview extends AppCompatActivity {
    EditText url;
    Button previous, go, back;
    WebView web;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        url = (EditText) findViewById(R.id.url);
        previous = (Button) findViewById(R.id.previousBtn);
        go = (Button) findViewById(R.id.goBtn);
        back = (Button) findViewById(R.id.backBtn);
       web = (WebView) findViewById(R.id.webView);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_webview, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
         Intent i;

        //noinspection SimplifiableIfStatement
        switch (id){
            case R.id.gallery:
                i= new Intent(this, Gallery.class);
                startActivity(i);

                break;
            case R.id.seek:
               i= new Intent(this,Seek.class);
               startActivity(i);
                break;
            case R.id.implicit:
                i = new Intent(this, Implicit.class);
                startActivity(i);

                break;
            case R.id.media:
                i= new Intent(this,Media.class);
                startActivity(i);
                break;
            case R.id.context:
                i= new Intent(this,KContent.class);
                startActivity(i);
                break;
            case R.id.toast:
                toastDialog();
                break;


        }

        return super.onOptionsItemSelected(item);
    }

    private void toastDialog() {

        final Dialog dialog = new Dialog(Webview.this);
        dialog.setContentView(R.layout.toastdialog);

        dialog.setTitle("Where you want your");

        Button topL = (Button) dialog.findViewById(R.id.topLeft);
        Button topR = (Button) dialog.findViewById(R.id.topRight);
        Button botL = (Button) dialog.findViewById(R.id.botLeft);
        Button botR = (Button) dialog.findViewById(R.id.botRight);

        topL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast= Toast.makeText(getApplicationContext(),
                        "Top Left", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP | Gravity.LEFT, 0, 0);
                toast.show();
                dialog.dismiss();
            }
        });
        topR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast= Toast.makeText(getApplicationContext(),
                        "Top Right", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP | Gravity.RIGHT, 0, 0);
                toast.show();
                dialog.dismiss();
            }
        });
        botL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast= Toast.makeText(getApplicationContext(),
                        "Bottom Left", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.BOTTOM | Gravity.LEFT, 0, 0);
                toast.show();
                dialog.dismiss();
            }
        });
        botR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Bottom Right", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.BOTTOM | Gravity.RIGHT, 0, 0);
                toast.show();
                dialog.dismiss();
            }
        });

        dialog.show();
    }


    public void goback(View view) {
        if(web.canGoBack()) {
            web.goBack();
            back.setEnabled(true);
        }
    }

    public void goPrevious(View view) {
        if(web.canGoForward()) {
            web.goForward();
            previous.setEnabled(true);
        }
    }

    public void gotoUrl(View view) {
        String weburl = url.getText().toString();

        web.getSettings().setJavaScriptEnabled(true);
        web.getSettings().setBuiltInZoomControls(true);
        web.setWebViewClient(new WebViewClient());
        web.loadUrl(weburl);
    }

}
