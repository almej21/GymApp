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

public class BicepsDialog extends Dialog {

    public Activity c;
    public static String EXTRA_DRILL_PATH = "com.example.application.gymapp.EXTRA_DRILL_PATH";
    public static String EXTRA_DRILL_NAME = "com.example.application.gymapp.EXTRA_DRILL_NAME";
    public static String EXTRA_DRILL_SETS = "com.example.application.gymapp.EXTRA_DRILL_SETS";
    public static String EXTRA_DRILL_REPS = "com.example.application.gymapp.EXTRA_DRILL_REPS";
    public static String EXTRA_DRILL_REST_TIME = "com.example.application.gymapp." +
            "EXTRA_DRILL_REST_TIME";

    public BicepsDialog(Activity a) {
        super(a);
        this.c = a;
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_biceps_exercises);

        Button cable_preacher_curls_btn = (Button) findViewById(R.id.cable_preacher_curls_btn);
        Button db_spider_curls_btn = (Button) findViewById(R.id.db_spider_curls_btn);
        Button ez_bar_curls_btn = (Button) findViewById(R.id.ez_bar_curls_btn);
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
        cable_preacher_curls_btn.setOnTouchListener(touchListener);
        cable_preacher_curls_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(c, VideoActivity.class);
                String videoPath = "android.resource://" + "com.example.gymapp" + "/" +
                        R.raw.biceps1_cable_preacher_curls;
                intent.putExtra(EXTRA_DRILL_PATH, videoPath);
                String videoNAME = "cable preacher curls";
                intent.putExtra(EXTRA_DRILL_NAME, videoNAME);
                intent.putExtra(EXTRA_DRILL_SETS,"3");
                intent.putExtra(EXTRA_DRILL_REPS, "10-12");
                intent.putExtra(EXTRA_DRILL_REST_TIME, "90 Sec");
                c.startActivity(intent);
            }
        });

        //---2---

        db_spider_curls_btn.setOnTouchListener(touchListener);
        db_spider_curls_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(c, VideoActivity.class);
                String videoPath = "android.resource://" + "com.example.gymapp" + "/" +
                        R.raw.biceps2_db_spider_curls;
                intent.putExtra(EXTRA_DRILL_PATH, videoPath);
                String videoNAME = "db spider curls";
                intent.putExtra(EXTRA_DRILL_NAME, videoNAME);
                intent.putExtra(EXTRA_DRILL_SETS,"3");
                intent.putExtra(EXTRA_DRILL_REPS, "10-12");
                intent.putExtra(EXTRA_DRILL_REST_TIME, "90 Sec");
                c.startActivity(intent);
            }
        });

        //---3---
        ez_bar_curls_btn.setOnTouchListener(touchListener);
        ez_bar_curls_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(c, VideoActivity.class);
                String videoPath = "android.resource://" + "com.example.gymapp" + "/" +
                        R.raw.biceps3_ez_bar_curls;
                intent.putExtra(EXTRA_DRILL_PATH, videoPath);
                String videoNAME = "ez bar curls";
                intent.putExtra(EXTRA_DRILL_NAME, videoNAME);
                intent.putExtra(EXTRA_DRILL_SETS,"3");
                intent.putExtra(EXTRA_DRILL_REPS, "10-12");
                intent.putExtra(EXTRA_DRILL_REST_TIME, "90 Sec");
                c.startActivity(intent);
            }
        });

    }

    public interface DialogListener{
        void applyDrill(String drill);
    }
}
