package com.example.gymapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.gymapp.dialogs.ChestDialog;


public class VideoActivity extends AppCompatActivity {

    Button goBack_button;
    TextView title, drillSets, drillReps, drillRestTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        Intent intent = getIntent();

        String drillPath = intent.getStringExtra(ChestDialog.EXTRA_DRILL_PATH);
        String drillName = intent.getStringExtra(ChestDialog.EXTRA_DRILL_NAME);
        String sets = intent.getStringExtra(ChestDialog.EXTRA_DRILL_SETS);
        String reps = intent.getStringExtra(ChestDialog.EXTRA_DRILL_REPS);
        String restTime = intent.getStringExtra(ChestDialog.EXTRA_DRILL_REST_TIME);

        goBack_button = findViewById(R.id.goBack_btn);
        drillSets = findViewById(R.id.tv_sets_num);
        drillReps = findViewById(R.id.tv_reps_num);
        drillRestTime = findViewById(R.id.tv_rest_time);
        title = findViewById(R.id.title);

        title.setText(drillName);
        drillSets.setText(sets);
        drillReps.setText(reps);
        drillRestTime.setText(restTime);

        VideoView videoView = findViewById(R.id.video_view);

        Uri uri = Uri.parse(drillPath);

        videoView.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setVolume(0f,0f);
                mp.setLooping(true);
            }
        });
        videoView.start();
        videoView.setAudioFocusRequest(AudioManager.AUDIOFOCUS_NONE);
        mediaController.setAnchorView(videoView);

        goBack_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}