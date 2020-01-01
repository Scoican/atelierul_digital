package com.example.codechallenges4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    private Button toFirstActivity;
    private Button toSecondActivity;
    private Button toThirdActivity;
    private Button toForthActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initButtons();
        initListeners();
    }

    private void initListeners() {
        toFirstActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, FirstChallengeActivity.class));
                Log.d(TAG, "Button clicked:" + toFirstActivity.getId());
            }
        });
        toSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SecondChallengeActivity.class));
                Log.d(TAG, "Button clicked:" + toSecondActivity.getId());
            }
        });
        toThirdActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ThirdChallengeActivity.class));
                Log.d(TAG, "Button clicked:" + toThirdActivity.getId());
            }
        });
        toForthActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ForthChallengeActivity.class));
                Log.d(TAG, "Button clicked:" + toForthActivity.getId());
            }
        });
    }

    private void initButtons() {
        toFirstActivity = findViewById(R.id.button_main_to_first_activity);
        toSecondActivity = findViewById(R.id.button_main_to_second_activity);
        toThirdActivity = findViewById(R.id.button_main_to_third_activity);
        toForthActivity = findViewById(R.id.button_main_to_forth_activity);
    }
}
