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

public class Weight_insert_activity extends AppCompatActivity {

    public EditText weight_editText;
    public Button next_button;
    public static String weight_value;
    public int defValue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_insert);

        TextView height_view = (TextView) findViewById(R.id.height_textview);

        SharedPreferences sp = this.getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE);
        String height_value = sp.getString("height_key", null);
        height_view.setText(height_value);//shows user's height input from prev' activity.

        weight_editText = (EditText) findViewById(R.id.weight_edittext);
        next_button = (Button) findViewById(R.id.next_button);

        next_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(weight_editText.getText().toString().equals(""))
                {
                    Toast.makeText(Weight_insert_activity.this, "Please insert weight", Toast.LENGTH_SHORT).show();
                }
                else {
                    weight_value = weight_editText.getText().toString();
                    SharedPreferences.Editor editor = getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE).edit();

                    editor.putString("weight_key", weight_value);
                    editor.apply();

                    Intent intent = new Intent(Weight_insert_activity.this, Age_insert_activity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}