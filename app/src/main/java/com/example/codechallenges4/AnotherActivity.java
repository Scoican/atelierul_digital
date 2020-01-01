package com.example.codechallenges4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class AnotherActivity extends AppCompatActivity {

    public static final String LOG_TAG = AnotherActivity.class.getSimpleName();
    private Button toFirstChallengeActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);
        Log.d(LOG_TAG, "onCreate()");
        initButtons();
        initListeners();
    }

    private void initListeners() {
        toFirstChallengeActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AnotherActivity.this, FirstChallengeActivity.class));
                Log.d(LOG_TAG, "startActivity()");
            }
        });
    }

    private void initButtons() {
        toFirstChallengeActivity = findViewById(R.id.button_another_activity_to_first_challenge);
    }

}
