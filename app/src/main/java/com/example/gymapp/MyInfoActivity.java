package com.example.gymapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MyInfoActivity extends AppCompatActivity {
    private Button change_info_button, goBack_button;

    @SuppressLint({"ClickableViewAccessibility", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_info);

        TextView height_view = (TextView) findViewById(R.id.height_textview);
        TextView weight_view = (TextView) findViewById(R.id.weight_textview);
        TextView age_view = (TextView) findViewById(R.id.age_textview);
        change_info_button = (Button) findViewById(R.id.change_info_button);
        goBack_button = (Button) findViewById(R.id.goBack_btn);
        MyTouchListener touchListener = new MyTouchListener();

        SharedPreferences sp = this.getSharedPreferences("MyUserPrefs",
                Context.MODE_PRIVATE);
        String height_value = sp.getString("height_key", null);
        String weight_value = sp.getString("weight_key", null);
        String age_value = sp.getString("age_key", null);
        height_view.setText(height_value + " cm");//shows user's height input from prev' activity.
        weight_view.setText(weight_value + " KG");//shows user's weight input from prev' activity.
        age_view.setText(age_value + " years");//shows user's weight input from prev' activity.

        change_info_button.setOnTouchListener(touchListener);
        change_info_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyInfoActivity.this,
                        Height_insert_activity.class);
                startActivity(intent);
                finish();
            }
        });

        goBack_button.setOnTouchListener(touchListener);
        goBack_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}