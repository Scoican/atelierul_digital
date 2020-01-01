package com.example.codechallenges4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class FirstChallengeActivity extends AppCompatActivity {
    public static final String LOG_TAG = FirstChallengeActivity.class.getSimpleName();
    private Button toAnotherActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_challenge);
        Log.d(LOG_TAG,"onCreate()");
        initButtons();
        initListeners();
    }

    private void initListeners() {
        toAnotherActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FirstChallengeActivity.this, AnotherActivity.class));
                Log.d(LOG_TAG, "startActivity()");
            }
        });
    }

    private void initButtons() {
        toAnotherActivity = findViewById(R.id.button_first_challenge_to_another_activity);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG,"onRestart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG,"onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG,"onPause()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG,"onStart()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG,"onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG,"onDestroy()");
    }


}
