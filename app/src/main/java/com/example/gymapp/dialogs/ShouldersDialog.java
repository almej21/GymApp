package com.example.gymapp.dialogs;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.gymapp.VideoActivity;
import com.example.gymapp.MyTouchListener;
import com.example.gymapp.R;

public class ShouldersDialog extends Dialog {

    public Activity c;
    public static String EXTRA_DRILL_PATH = "com.example.application.gymapp.EXTRA_DRILL_PATH";
    public static String EXTRA_DRILL_NAME = "com.example.application.gymapp.EXTRA_DRILL_NAME";
    public static String EXTRA_DRILL_SETS = "com.example.application.gymapp.EXTRA_DRILL_SETS";
    public static String EXTRA_DRILL_REPS = "com.example.application.gymapp.EXTRA_DRILL_REPS";
    public static String EXTRA_DRILL_REST_TIME = "com.example.application.gymapp." +
            "EXTRA_DRILL_REST_TIME";

    public ShouldersDialog(Activity a) {
        super(a);
        this.c = a;
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_shoulders_exercises);

        Button lat_raises_btn = (Button) findViewById(R.id.lat_raises_btn);
        Button plate_upright_row_btn = (Button) findViewById(R.id.plate_upright_row_btn);
        Button db_front_raises_btn = (Button) findViewById(R.id.db_front_raises_btn);
        MyTouchListener touchListener = new MyTouchListener();

        Button goBack_button = (Button) findViewById(R.id.goBack_btn);;
        goBack_button.setOnTouchListener(touchListener);
        goBack_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        //---1---
        lat_raises_btn.setOnTouchListener(touchListener);
        lat_raises_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(c, VideoActivity.class);
                String videoPath = "android.resource://" + "com.example.gymapp" + "/" +
                        R.raw.shoulders1_lat_raises;
                intent.putExtra(EXTRA_DRILL_PATH, videoPath);
                String videoNAME = "lat raises";
                intent.putExtra(EXTRA_DRILL_NAME, videoNAME);
                intent.putExtra(EXTRA_DRILL_SETS,"4");
                intent.putExtra(EXTRA_DRILL_REPS, "8-10");
                intent.putExtra(EXTRA_DRILL_REST_TIME, "90 Sec");
                c.startActivity(intent);
            }
        });

        //---2---
        plate_upright_row_btn.setOnTouchListener(touchListener);
        plate_upright_row_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(c, VideoActivity.class);
                String videoPath = "android.resource://" + "com.example.gymapp" + "/" +
                        R.raw.shoulders2_plate_upright_row;
                intent.putExtra(EXTRA_DRILL_PATH, videoPath);
                String videoNAME = "plate upright row";
                intent.putExtra(EXTRA_DRILL_NAME, videoNAME);
                intent.putExtra(EXTRA_DRILL_SETS,"3");
                intent.putExtra(EXTRA_DRILL_REPS, "10-12");
                intent.putExtra(EXTRA_DRILL_REST_TIME, "90 Sec");
                c.startActivity(intent);
            }
        });

        //---3---
        db_front_raises_btn.setOnTouchListener(touchListener);
        db_front_raises_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(c, VideoActivity.class);
                String videoPath = "android.resource://" + "com.example.gymapp" + "/" +
                        R.raw.shoulders3_db_front_raises;
                intent.putExtra(EXTRA_DRILL_PATH, videoPath);
                String videoNAME = "db front raises";
                intent.putExtra(EXTRA_DRILL_NAME, videoNAME);
                intent.putExtra(EXTRA_DRILL_SETS,"4");
                intent.putExtra(EXTRA_DRILL_REPS, "8-10");
                intent.putExtra(EXTRA_DRILL_REST_TIME, "90 Sec");
                c.startActivity(intent);
            }
        });

    }

    public interface DialogListener{
        void applyDrill(String drill);
    }
}
