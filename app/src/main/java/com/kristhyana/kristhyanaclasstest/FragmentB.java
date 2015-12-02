package com.kristhyana.kristhyanaclasstest;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class FragmentB extends Fragment{


    TextView textView;
    SharedPreferences preferences;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_fragment_b, container, false);
        textView = (TextView) view.findViewById(R.id.textView);

        preferences = getActivity().getSharedPreferences("ColorPrefs",Context.MODE_PRIVATE);
        if(preferences.getInt("Text_color",-1) != 0) {
            textView.setTextColor(preferences.getInt("Text_color", -1));
        }

        if(savedInstanceState != null){
            textView.getTextColors();
        }



        return view;
    }

    public void setTheText(int color){
        textView.setTextColor(color);
        preferences = getActivity().getSharedPreferences("ColorPrefs",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("Text_color", color);
        editor.apply();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("countVal", textView.getText().toString());
    }
}




