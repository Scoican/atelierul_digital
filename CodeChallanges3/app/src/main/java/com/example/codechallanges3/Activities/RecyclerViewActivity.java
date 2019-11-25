package com.example.codechallanges3.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.codechallanges3.Adapters.RecyclerViewAdapter;
import com.example.codechallanges3.Data.StudentDataSource;
import com.example.codechallanges3.R;

public class RecyclerViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);


        // use a linear layout manager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        StudentDataSource dataSource=new StudentDataSource();

        // specify an adapter (see also next example)
        RecyclerView.Adapter mAdapter = new RecyclerViewAdapter(dataSource.getStudentFirstNames(), dataSource.getStudentLastNames());
        recyclerView.setAdapter(mAdapter);
    }
}
