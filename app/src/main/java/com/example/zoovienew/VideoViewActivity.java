package com.example.zoovienew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.VideoView;

public class VideoViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_view);

        VideoView videoView = findViewById(R.id.video_player_view);

        videoView.setVideoPath("android.resource://" +getPackageName()+"/" + R.raw.intro_video);
        videoView.start();
        //
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                Intent intent = new Intent(VideoViewActivity.this, SplashActivity.class);
                startActivity(intent);
            }
        });



        ImageView cancelBtn=findViewById(R.id.iv_cancel);
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VideoViewActivity.this, SplashActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }
}