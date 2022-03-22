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

public class BackDialog extends Dialog {

    public Activity c;
    public static String EXTRA_DRILL_PATH = "com.example.application.gymapp.EXTRA_DRILL_PATH";
    public static String EXTRA_DRILL_NAME = "com.example.application.gymapp.EXTRA_DRILL_NAME";
    public static String EXTRA_DRILL_SETS = "com.example.application.gymapp.EXTRA_DRILL_SETS";
    public static String EXTRA_DRILL_REPS = "com.example.application.gymapp.EXTRA_DRILL_REPS";
    public static String EXTRA_DRILL_REST_TIME = "com.example.application.gymapp." +
            "EXTRA_DRILL_REST_TIME";

    public BackDialog(Activity a) {
        super(a);
        this.c = a;
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.dialog_back_exercises);

        Button pull_ups_btn = (Button) findViewById(R.id.pull_ups_btn);
        Button reverse_grip_pull_downs_btn = (Button) findViewById(R.id
                .reverse_grip_pull_downs_btn);
        Button straight_arm_push_downs_btn = (Button) findViewById(R.id
                .straight_arm_push_downs_btn);
        Button upper_back_row_btn = (Button) findViewById(R.id.upper_back_row_btn);
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
        pull_ups_btn.setOnTouchListener(touchListener);
        pull_ups_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(c, VideoActivity.class);
                String videoPath = "android.resource://" + "com.example.gymapp" + "/" +
                        R.raw.back1_pull_ups;
                intent.putExtra(EXTRA_DRILL_PATH, videoPath);
                String videoNAME = "pull ups";
                intent.putExtra(EXTRA_DRILL_NAME, videoNAME);
                intent.putExtra(EXTRA_DRILL_SETS,"4");
                intent.putExtra(EXTRA_DRILL_REPS, "8-10");
                intent.putExtra(EXTRA_DRILL_REST_TIME, "90 Sec");
                c.startActivity(intent);
            }
        });

        //---2---

        reverse_grip_pull_downs_btn.setOnTouchListener(touchListener);
        reverse_grip_pull_downs_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(c, VideoActivity.class);
                String videoPath = "android.resource://" + "com.example.gymapp" + "/" +
                        R.raw.back2_reverse_grip_pull_downs;
                intent.putExtra(EXTRA_DRILL_PATH, videoPath);
                String videoNAME = "reverse grip pull downs";
                intent.putExtra(EXTRA_DRILL_NAME, videoNAME);
                intent.putExtra(EXTRA_DRILL_SETS,"4");
                intent.putExtra(EXTRA_DRILL_REPS, "8-10");
                intent.putExtra(EXTRA_DRILL_REST_TIME, "90 Sec");
                c.startActivity(intent);
            }
        });

        //---3---
        straight_arm_push_downs_btn.setOnTouchListener(touchListener);
        straight_arm_push_downs_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(c, VideoActivity.class);
                String videoPath = "android.resource://" + "com.example.gymapp" + "/" +
                        R.raw.back3_straight_arm_pushdowns;
                intent.putExtra(EXTRA_DRILL_PATH, videoPath);
                String videoNAME = "straight arm pushdowns";
                intent.putExtra(EXTRA_DRILL_NAME, videoNAME);
                intent.putExtra(EXTRA_DRILL_SETS,"3");
                intent.putExtra(EXTRA_DRILL_REPS, "10-12");
                intent.putExtra(EXTRA_DRILL_REST_TIME, "90 Sec");
                c.startActivity(intent);
            }
        });

        //---4---
        upper_back_row_btn.setOnTouchListener(touchListener);
        upper_back_row_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(c, VideoActivity.class);
                String videoPath = "android.resource://" + "com.example.gymapp" + "/" +
                        R.raw.back4_upper_back_row;
                intent.putExtra(EXTRA_DRILL_PATH, videoPath);
                String videoNAME = "back4 upper back row";
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
