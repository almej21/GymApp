package com.example.gymapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {
    SwitchCompat switchCompat;
    TextView A_drills, B_drills;
    //B = false, A = true

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        switchCompat = v.findViewById(R.id.icon_switch);
        A_drills = v.findViewById(R.id.a_drills);
        B_drills = v.findViewById(R.id.b_drills);
        Button my_info_button = (Button) v.findViewById(R.id.my_info_button);

        SharedPreferences sp = getActivity().getSharedPreferences("prefs", Context.MODE_PRIVATE);

        if(sp.getBoolean("last_AB", true)) //initialize fragment with last state
        {
            A_drills.setTextColor(Color.WHITE);
            B_drills.setTextColor(Color.parseColor("#505050"));

        }else {
            B_drills.setTextColor(Color.WHITE);
            A_drills.setTextColor(Color.parseColor("#505050"));
        }

        switchCompat.setChecked(sp.getBoolean("value", true));

        switchCompat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switchCompat.isChecked()) { //toggle switch to A
                    A_drills.setTextColor(Color.WHITE);
                    B_drills.setTextColor(Color.parseColor("#505050"));

                    SharedPreferences.Editor editor = getActivity().getSharedPreferences("prefs"
                            , Context.MODE_PRIVATE).edit();
                    editor.putBoolean("value", true);
                    editor.putBoolean("last_AB", true);
                    editor.apply();
                    switchCompat.setChecked(true);
                } else { //toggle switch to B
                    B_drills.setTextColor(Color.WHITE);
                    A_drills.setTextColor(Color.parseColor("#505050"));

                    SharedPreferences.Editor editor = getActivity().getSharedPreferences("prefs"
                            , Context.MODE_PRIVATE).edit();
                    editor.putBoolean("value", false);

                    editor.putBoolean("last_AB", false);
                    editor.apply();
                    switchCompat.setChecked(false);
                }
            }
        });

        MyTouchListener touchListener = new MyTouchListener();
        my_info_button.setOnTouchListener(touchListener);
        my_info_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MyInfoActivity.class);
                startActivity(intent);
            }
        });

        return v;
    }

}
