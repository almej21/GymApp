package com.example.gymapp;

import android.graphics.PorterDuff;
import android.view.MotionEvent;
import android.view.View;

public class MyTouchListener implements View.OnTouchListener {
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN: {
                //noinspection deprecation
                v.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                v.invalidate();
                break;
            }
            case MotionEvent.ACTION_UP: {
                v.getBackground().clearColorFilter();
                v.invalidate();
                break;
            }
        }
        return false;
    }
}
