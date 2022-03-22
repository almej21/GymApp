package com.example.gymapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Height_insert_activity extends AppCompatActivity {

    private EditText height_editText;
    private Button next_button;
    public static String height_value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_height_insert);
        SharedPreferences sp = getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE);

        height_editText = (EditText) findViewById(R.id.height_edittext);
        next_button = (Button) findViewById(R.id.next_button);

        next_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(height_editText.getText().toString().equals(""))
                {
                    Toast.makeText(Height_insert_activity.this, "Please insert height", Toast.LENGTH_SHORT).show();
                }
                else {
                    height_value = height_editText.getText().toString();
                    SharedPreferences.Editor editor = getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE).edit();

                    editor.putString("height_key", height_value);
                    editor.apply();

                    Intent intent = new Intent(Height_insert_activity.this, Weight_insert_activity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}