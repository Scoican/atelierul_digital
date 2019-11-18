package com.example.codechallanges2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FrameLayoutActivity extends AppCompatActivity {

    private static final String TAG = FrameLayoutActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_layout);
    }

    public void changeActivity(View view) {
        Intent intent = new Intent(this, SpinnerLayout.class);
        startActivity(intent);
    }
}
