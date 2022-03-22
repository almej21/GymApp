package com.example.gymapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Age_insert_activity extends AppCompatActivity {
    private TextView height, weight;
    private EditText age_editText;
    private Button next_button;
    public static String age_value;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age_insert);

        TextView height_view = (TextView) findViewById(R.id.height_textview);
        TextView weight_view = (TextView) findViewById(R.id.weight_textview);

        SharedPreferences sp = this.getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE);
        String height_value = sp.getString("height_key", null);
        String weight_value = sp.getString("weight_key", null);
        height_view.setText(height_value);//shows user's height input from prev' activity.
        weight_view.setText(weight_value);//shows user's weight input from prev' activity.

        age_editText = (EditText) findViewById(R.id.age_edittext);
        next_button = (Button) findViewById(R.id.next_button);

        next_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(age_editText.getText().toString().equals(""))
                {
                    Toast.makeText(Age_insert_activity.this, "Please insert age", Toast.LENGTH_SHORT).show();
                }
                else {
                    age_value = age_editText.getText().toString();
                    SharedPreferences.Editor editor = getSharedPreferences("MyUserPrefs", MODE_PRIVATE).edit();

                    editor.putString("age_key", age_value);
                    editor.apply();
                    finish();

                }
            }
        });
    }
}