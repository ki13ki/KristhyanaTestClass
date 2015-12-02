package com.kristhyana.kristhyanaclasstest;


import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentA extends Fragment {
    SeekBar red, blue, green;
    TextView tv;
    int r,b,g = 0;
    int color = 0;
    SharedPreferences preferences;
    PassData passData;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_, container, false);
        red = (SeekBar) v.findViewById(R.id.seekBarR);
        blue = (SeekBar) v.findViewById(R.id.seekBarB);
        green = (SeekBar) v.findViewById(R.id.seekBarG);
        tv = (TextView) v.findViewById(R.id.tv);


        if(savedInstanceState != null){

            color = savedInstanceState.getInt("count",0);
        }else {
        }
        preferences = getActivity().getSharedPreferences("ColorPrefs",Context.MODE_PRIVATE);
        if(preferences.getInt("Text_color",-1) != 0){
            tv.setTextColor(preferences.getInt("Text_color", -1));
            red.setProgress(preferences.getInt("red", -1));
            blue.setProgress(preferences.getInt("blue", -1));
            green.setProgress(preferences.getInt("green", -1));
        }

        red.setOnSeekBarChangeListener(seekBarChangeListener);
        green.setOnSeekBarChangeListener(seekBarChangeListener);
        blue.setOnSeekBarChangeListener(seekBarChangeListener);



        return v;
    }
    private SeekBar.OnSeekBarChangeListener seekBarChangeListener
            = new SeekBar.OnSeekBarChangeListener()
    {

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress,
                                      boolean fromUser) {
// TODO Auto-generated method stub
            updateTextColor();
        }
        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
// TODO Auto-generated method stub
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
// TODO Auto-generated method stub
        }
    };

    private void updateTextColor()
    {
        r = red.getProgress();
        g = green.getProgress();
        b = blue.getProgress();
        tv.setTextColor(
                0xff000000
                        + r * 0x10000
                        + g * 0x100
                        + b
        );


        color = tv.getCurrentTextColor();
        preferences = getActivity().getSharedPreferences("ColorPrefs",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("Text_color",color);
        editor.putInt("red", r);
        editor.putInt("green", g);
        editor.putInt("blue", b);
        editor.apply();

        passData = (PassData) getActivity();
        passData.takeThisData(color);

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("color", color);
    }

    public interface PassData {
        public void takeThisData(int cData);

    }
}

