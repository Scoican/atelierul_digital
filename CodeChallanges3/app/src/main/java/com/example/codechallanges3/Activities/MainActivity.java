package com.example.codechallanges3.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.codechallanges3.R;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    private Button toFirstActivity;
    private Button toSecondActivity;
    private Button toThirdActivity;

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
                startActivity(new Intent(MainActivity.this, ConstraintViewActivity.class));
                Log.d(TAG,"Button clicked:"+toFirstActivity.getId());
            }
        });
        toSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RecyclerViewActivity.class));
                Log.d(TAG,"Button clicked:"+toSecondActivity.getId());
            }
        });
        toThirdActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, HolidayCardActivity.class));
                Log.d(TAG,"Button clicked:"+toThirdActivity.getId());
            }
        });
    }

    private void initButtons() {
        toFirstActivity=findViewById(R.id.button_main_to_first_activity);
        toSecondActivity=findViewById(R.id.button_main_to_second_activity);
        toThirdActivity=findViewById(R.id.button_main_to_third_activity);
    }
}
