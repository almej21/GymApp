package com.example.gymapp.dialogs;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.gymapp.VideoActivity;
import com.example.gymapp.MyTouchListener;
import com.example.gymapp.R;

public class ChestDialog extends Dialog {

    public Activity c;
    public static String EXTRA_DRILL_PATH = "com.example.application.gymapp.EXTRA_DRILL_PATH";
    public static String EXTRA_DRILL_NAME = "com.example.application.gymapp.EXTRA_DRILL_NAME";
    public static String EXTRA_DRILL_SETS = "com.example.application.gymapp.EXTRA_DRILL_SETS";
    public static String EXTRA_DRILL_REPS = "com.example.application.gymapp.EXTRA_DRILL_REPS";
    public static String EXTRA_DRILL_REST_TIME = "com.example.application.gymapp.EXTRA_DRILL_REST_TIME";

    public ChestDialog(Activity a) {
        super(a);
        this.c = a;
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_chest_exercises);

        Button incline_db_chest_press_btn = (Button) findViewById(R.id.incline_db_chest_press_btn);
        Button incline_chest_machine_btn = (Button) findViewById(R.id.incline_chest_machine_btn);
        Button decline_bench_press_btn = (Button) findViewById(R.id.decline_bench_press_btn);
        Button cable_Fly_btn = (Button) findViewById(R.id.Cable_Fly_btn);
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
        incline_db_chest_press_btn.setOnTouchListener(touchListener);
        incline_db_chest_press_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(c, VideoActivity.class);
                String videoPath = "android.resource://" + "com.example.gymapp" + "/" +
                        R.raw.chest1_incline_db_chest_press;
                intent.putExtra(EXTRA_DRILL_PATH, videoPath);
                String videoNAME = "incline db chest press";
                intent.putExtra(EXTRA_DRILL_NAME, videoNAME);
                intent.putExtra(EXTRA_DRILL_SETS,"5");
                intent.putExtra(EXTRA_DRILL_REPS, "6-8");
                intent.putExtra(EXTRA_DRILL_REST_TIME, "90 Sec");
                c.startActivity(intent);
            }
        });

        //---2---
        incline_chest_machine_btn.setOnTouchListener(touchListener);
        incline_chest_machine_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(c, VideoActivity.class);
                String videoPath = "android.resource://" + "com.example.gymapp" + "/" +
                        R.raw.chest2_incline_chest_machine;
                intent.putExtra(EXTRA_DRILL_PATH, videoPath);
                String videoNAME = "incline chest machine";
                intent.putExtra(EXTRA_DRILL_NAME, videoNAME);
                intent.putExtra(EXTRA_DRILL_SETS,"4");
                intent.putExtra(EXTRA_DRILL_REPS, "6-8");
                intent.putExtra(EXTRA_DRILL_REST_TIME, "90 Sec");
                c.startActivity(intent);
            }
        });

        //---3---
        decline_bench_press_btn.setOnTouchListener(touchListener);
        decline_bench_press_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(c, VideoActivity.class);
                String videoPath = "android.resource://" + "com.example.gymapp" + "/" +
                        R.raw.chest3_decline_bench_press;
                intent.putExtra(EXTRA_DRILL_PATH, videoPath);
                String videoNAME = "decline bench press";
                intent.putExtra(EXTRA_DRILL_NAME, videoNAME);
                intent.putExtra(EXTRA_DRILL_SETS,"4");
                intent.putExtra(EXTRA_DRILL_REPS, "8-10");
                intent.putExtra(EXTRA_DRILL_REST_TIME, "90 Sec");
                c.startActivity(intent);
            }
        });

        //---4---
        cable_Fly_btn.setOnTouchListener(touchListener);
        cable_Fly_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(c, VideoActivity.class);
                String videoPath = "android.resource://" + "com.example.gymapp" + "/" +
                        R.raw.chest4_cable_fly;
                intent.putExtra(EXTRA_DRILL_PATH, videoPath);
                String videoNAME = "cable fly";
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
