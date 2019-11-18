package com.example.codechallanges2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import java.util.ArrayList;
import java.util.List;

public class SpinnerLayout extends AppCompatActivity {

    private static final String TAG = SpinnerLayout.class.getSimpleName();
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_layout);

        //Initialize Views
        initViews();

        //Set spinner content
        spinner.setAdapter(getSpinnerAdapter());

        //Initialise Listeners
        initListeners();
    }

    private void initListeners() {
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d(TAG, "onItemSelected(), i= " + i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Log.d(TAG, "onNothingSelected()");
            }
        });
    }

    public void changeActivity(View view) {
        Intent intent = new Intent(SpinnerLayout.this, MainActivity.class);
        startActivity(intent);
    }

    private ArrayAdapter<String> getSpinnerAdapter() {
        return new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item,
                getSpinnerElements());
    }

    private List<String> getSpinnerElements() {
        List<String> spinnerElements = new ArrayList<>();
        spinnerElements.add("Cupcake");
        spinnerElements.add("Donut");
        spinnerElements.add("Eclair");
        spinnerElements.add("KitKat");
        spinnerElements.add("Pie");
        return spinnerElements;
    }

    private void initViews() {
        spinner = findViewById(R.id.spinner);
    }

}
