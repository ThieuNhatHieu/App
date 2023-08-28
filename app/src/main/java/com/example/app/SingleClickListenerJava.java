package com.example.app;

import android.os.SystemClock;
import android.view.View;

public class SingleClickListenerJava implements View.OnClickListener {
    private long mLastClickTime = 0;
    @Override
    public void onClick(View v) {
        if (SystemClock.elapsedRealtime() - mLastClickTime < 1000)
        mLastClickTime = SystemClock.elapsedRealtime();
    }
}
