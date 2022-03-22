package com.example.gymapp;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.gymapp.dialogs.ChestDialog;
import com.example.gymapp.dialogs.GlutesDialog;
import com.example.gymapp.dialogs.QuadricepsDialog;

public class LowerBodyFragment extends Fragment {

    Button quadriceps_button, glutes_button;

    @SuppressLint("ClickableViewAccessibility")
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_lower_body, container, false);
        quadriceps_button = (Button) v.findViewById(R.id.quadriceps_btn);
        glutes_button = (Button) v.findViewById(R.id.glutes_btn);


        MyTouchListener touchListener = new MyTouchListener();
        quadriceps_button.setOnTouchListener(touchListener);
        quadriceps_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QuadricepsDialog quadriceps_exercises_dialog = new QuadricepsDialog(getActivity());
                quadriceps_exercises_dialog.setContentView(R.layout.dialog_quadriceps_exercises);
                quadriceps_exercises_dialog.getWindow().setBackgroundDrawable(new ColorDrawable
                        (Color.TRANSPARENT));
                quadriceps_exercises_dialog.show();
            }
        });

        glutes_button.setOnTouchListener(touchListener);
        glutes_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GlutesDialog glutes_exercises_dialog = new GlutesDialog(getActivity());
                glutes_exercises_dialog.setContentView(R.layout.dialog_glutes_exercises);
                glutes_exercises_dialog.getWindow().setBackgroundDrawable(new ColorDrawable
                        (Color.TRANSPARENT));
                glutes_exercises_dialog.show();
            }
        });
        return v;
    }
}
