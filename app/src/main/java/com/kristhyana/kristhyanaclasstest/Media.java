package com.kristhyana.kristhyanaclasstest;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class Media extends AppCompatActivity {
    Button play, stop, pause;
    MediaPlayer mp;
    int length;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);

        play = (Button) findViewById(R.id.play);
        stop = (Button) findViewById(R.id.stop);
        pause = (Button) findViewById(R.id.pause);
    }

    public void playVideo(View view) {
        VideoView v = (VideoView) findViewById(R.id.videoView);
        String uriPath = "android.resource://" + getPackageName() + "/" + R.raw.video;
        Uri uri = Uri.parse(uriPath);
        v.setVideoURI(uri);
        v.setMediaController(new MediaController(this));
        v.start();
        v.requestFocus();
    }

    public void playMusic(View view) {
        mp = MediaPlayer.create(Media.this, R.raw.audio);
        if(length == 0) {
            mp.start();
            play.setVisibility(View.GONE);
            pause.setVisibility(View.VISIBLE);
            stop.setVisibility(View.VISIBLE);

        }else {
            mp.seekTo(length);
            mp.start();
            play.setVisibility(View.GONE);
            pause.setVisibility(View.VISIBLE);
            stop.setVisibility(View.VISIBLE);
        }

        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                play.setVisibility(View.VISIBLE);
                pause.setVisibility(View.GONE);
                stop.setVisibility(View.GONE);

            }
        });

    }


    public void pauseMusic(View view) {
        mp.pause();
        length=mp.getCurrentPosition();
        play.setVisibility(View.VISIBLE);
        pause.setVisibility(View.GONE);
        stop.setVisibility(View.VISIBLE);


    }

    public void stopMusic(View view) {
        if(mp!= null) {
            mp.stop();
            length = 0;
            play.setVisibility(View.VISIBLE);
            pause.setVisibility(View.GONE);
            stop.setVisibility(View.GONE);
            mp.release();
        }
    }
}


