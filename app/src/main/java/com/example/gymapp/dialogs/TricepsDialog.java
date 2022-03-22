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

public class TricepsDialog extends Dialog {

    public Activity c;
    public static String EXTRA_DRILL_PATH = "com.example.application.gymapp.EXTRA_DRILL_PATH";
    public static String EXTRA_DRILL_NAME = "com.example.application.gymapp.EXTRA_DRILL_NAME";
    public static String EXTRA_DRILL_SETS = "com.example.application.gymapp.EXTRA_DRILL_SETS";
    public static String EXTRA_DRILL_REPS = "com.example.application.gymapp.EXTRA_DRILL_REPS";
    public static String EXTRA_DRILL_REST_TIME = "com.example.application.gymapp." +
            "EXTRA_DRILL_REST_TIME";

    public TricepsDialog(Activity a) {
        super(a);
        this.c = a;
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_triceps_exercises);

        Button close_grip_pushdowns_btn = (Button) findViewById(R.id.close_grip_pushdowns_btn);
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
        close_grip_pushdowns_btn.setOnTouchListener(touchListener);
        close_grip_pushdowns_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(c, VideoActivity.class);
                String videoPath = "android.resource://" + "com.example.gymapp" + "/" +
                        R.raw.triceps1_close_grip_pushdowns;
                intent.putExtra(EXTRA_DRILL_PATH, videoPath);
                String videoNAME = "close grip pushdowns";
                intent.putExtra(EXTRA_DRILL_NAME, videoNAME);
                intent.putExtra(EXTRA_DRILL_SETS,"3");
                intent.putExtra(EXTRA_DRILL_REPS, "10-12");
                intent.putExtra(EXTRA_DRILL_REST_TIME, "90 Sec");
                c.startActivity(intent);
            }
        });

    }
    public interface DialogListener {
        void applyDrill(String drill);
    }
}
