package com.example.codechallanges3.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.codechallanges3.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecycleViewHolder> {
    private final List<String> firstNames;
    private final List<String> lastNames;

    public RecyclerViewAdapter(List<String> firstData,List<String> secondData) {
        this.firstNames = firstData;
        this.lastNames = secondData;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.RecycleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View recyclerRow = layoutInflater.inflate(R.layout.item_student_name, parent, false);
        return new RecycleViewHolder(recyclerRow);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.RecycleViewHolder holder, int position) {
        String firstName=firstNames.get(position);
        String lastName=lastNames.get(position);
        holder.studentFirstName.setText(firstName);
        holder.studentLastName.setText(lastName);
    }

    @Override
    public int getItemCount() {
        return firstNames.size();
    }

    static class RecycleViewHolder extends RecyclerView.ViewHolder {
        final TextView studentFirstName;
        final TextView studentLastName;

        RecycleViewHolder(@NonNull View itemView) {
            super(itemView);
            studentFirstName = itemView.findViewById(R.id.student_first_name);
            studentLastName = itemView.findViewById(R.id.student_last_name);
        }
    }
}
