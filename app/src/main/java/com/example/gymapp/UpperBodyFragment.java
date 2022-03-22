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

import com.example.gymapp.dialogs.AbsDialog;
import com.example.gymapp.dialogs.BackDialog;
import com.example.gymapp.dialogs.BicepsDialog;
import com.example.gymapp.dialogs.ChestDialog;
import com.example.gymapp.dialogs.ShouldersDialog;
import com.example.gymapp.dialogs.TricepsDialog;

public class UpperBodyFragment extends Fragment {

    Button chest_button, back_button, biceps_button, triceps_button, shoulders_button, abs_button;

    @SuppressLint("ClickableViewAccessibility")
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_upper_body, container, false);
        chest_button = (Button) v.findViewById(R.id.chest_button);
        back_button = (Button) v.findViewById(R.id.back_btn);
        biceps_button = (Button) v.findViewById(R.id.biceps_btn);
        triceps_button = (Button) v.findViewById(R.id.triceps_btn);
        shoulders_button = (Button) v.findViewById(R.id.shoulders_btn);
        abs_button = (Button) v.findViewById(R.id.abs_btn);

        MyTouchListener touchListener = new MyTouchListener();
        chest_button.setOnTouchListener(touchListener);
        chest_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChestDialog chest_exercises_dialog = new ChestDialog(getActivity());
                chest_exercises_dialog.setContentView(R.layout.dialog_chest_exercises);
                chest_exercises_dialog.getWindow().setBackgroundDrawable(new ColorDrawable
                        (Color.TRANSPARENT));
                chest_exercises_dialog.show();
            }
        });

        back_button.setOnTouchListener(touchListener);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BackDialog back_exercises_dialog = new BackDialog(getActivity());
                back_exercises_dialog.setContentView(R.layout.dialog_back_exercises);
                back_exercises_dialog.getWindow().setBackgroundDrawable(new ColorDrawable
                        (Color.TRANSPARENT));
                back_exercises_dialog.show();
            }
        });

        biceps_button.setOnTouchListener(touchListener);
        biceps_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BicepsDialog biceps_exercises_dialog = new BicepsDialog(getActivity());
                biceps_exercises_dialog.setContentView(R.layout.dialog_biceps_exercises);
                biceps_exercises_dialog.getWindow().setBackgroundDrawable(new ColorDrawable
                        (Color.TRANSPARENT));
                biceps_exercises_dialog.show();
            }
        });

        triceps_button.setOnTouchListener(touchListener);
        triceps_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TricepsDialog triceps_exercises_dialog = new TricepsDialog(getActivity());
                triceps_exercises_dialog.setContentView(R.layout.dialog_triceps_exercises);
                triceps_exercises_dialog.getWindow().setBackgroundDrawable(new ColorDrawable
                        (Color.TRANSPARENT));
                triceps_exercises_dialog.show();
            }
        });

        shoulders_button.setOnTouchListener(touchListener);
        shoulders_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShouldersDialog shoulders_exercises_dialog = new ShouldersDialog(getActivity());
                shoulders_exercises_dialog.setContentView(R.layout.dialog_shoulders_exercises);
                shoulders_exercises_dialog.getWindow().setBackgroundDrawable(new ColorDrawable
                        (Color.TRANSPARENT));
                shoulders_exercises_dialog.show();
            }
        });

        abs_button.setOnTouchListener(touchListener);
        abs_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AbsDialog abs_exercises_dialog = new AbsDialog(getActivity());
                abs_exercises_dialog.setContentView(R.layout.dialog_abs_exercises);
                abs_exercises_dialog.getWindow().setBackgroundDrawable(new ColorDrawable
                        (Color.TRANSPARENT));
                abs_exercises_dialog.show();
            }
        });
        return v;
    }
}