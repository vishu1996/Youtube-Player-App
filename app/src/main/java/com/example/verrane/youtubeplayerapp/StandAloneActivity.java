package com.example.verrane.youtubeplayerapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeStandalonePlayer;

public class StandAloneActivity extends AppCompatActivity implements View.OnClickListener
{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standalone);

        Button btnPlayVideo = (Button) findViewById(R.id.btnPlayVideo);
        Button btnPlayList = (Button) findViewById(R.id.btnPlayList);

        btnPlayVideo.setOnClickListener(this);
        btnPlayList.setOnClickListener(this);

//        View.OnClickListener myListener = new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        };
//
//        btnPlayVideo.setOnClickListener(myListener);
//        btnPlayList.setOnClickListener(myListener);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;

        switch (v.getId()){
            case R.id.btnPlayVideo :
                intent = YouTubeStandalonePlayer.createVideoIntent(this, YouTubeActivity.GOOGLE_YOUTUBE_API_KEY, YouTubeActivity.YOUTUBE_VIDEO_ID, 0, true, false);
                break;
            case R.id.btnPlayList :
                intent = YouTubeStandalonePlayer.createPlaylistIntent(this, YouTubeActivity.GOOGLE_YOUTUBE_API_KEY, YouTubeActivity.YOUTUBE_PLAYLIST, 0, 0, true, true);
                break;
                default: //Do Nothing
        }
        if (intent != null){
            startActivity(intent);
        }
    }
}
