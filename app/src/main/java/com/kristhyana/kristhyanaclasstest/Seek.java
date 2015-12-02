package com.kristhyana.kristhyanaclasstest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class Seek extends AppCompatActivity implements FragmentA.PassData {

    FragmentA fragmentA;
    FragmentB fragmentb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek);

        fragmentA = (FragmentA) getFragmentManager().findFragmentById(R.id.fragmentFirst);
        fragmentb = (FragmentB) getFragmentManager().findFragmentById(R.id.fragmentSecond);
    }

//   public void showToast(int count){
//       fragmentb.setTheText(count);
////       Toast.makeText(this, "Button Was clicked "+ count + " times", Toast.LENGTH_LONG).show();
//   }

    @Override
    public void takeThisData(int cData) {
        fragmentb.setTheText(cData);

    }
}
