package com.kristhyana.kristhyanaclasstest;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class Implicit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit);
    }
    

    public void launchMap(View view) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("geo:38.993179,-76.9243741"));
//        Intent chooser = Intent.createChooser(intent, "Launch Maps");
            startActivity(intent);

        }

    public void sendEmail(View view) {
        EditText email = (EditText) findViewById(R.id.editText);
        String e = email.getText().toString();
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setData(Uri.parse("mailto:"));
            String[] to = {e};
            intent.putExtra(Intent.EXTRA_EMAIL, to);
            intent.putExtra(Intent.EXTRA_SUBJECT, "This is a Test");
            intent.putExtra(Intent.EXTRA_TEXT, "This is a test");
            intent.setType("message/rfc822");
//        startActivity(intent);
            Intent chooser = Intent.createChooser(intent, "Select Your Email Client");
            startActivity(chooser);

    }

    public void shareText(View view) {
        EditText et = (EditText) findViewById(R.id.editText2);
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, et.getText().toString());
        //        Intent chooser = Intent.createChooser(intent, "Share Text");
        startActivity(intent);

    }
}
