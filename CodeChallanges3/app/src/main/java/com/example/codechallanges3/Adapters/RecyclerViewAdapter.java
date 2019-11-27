package com.example.codechallanges3.Adapters;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
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
        if(position%2==1){
            holder.layout.setBackgroundColor(Color.parseColor("#D3D3D3"));
        }else{
            holder.layout.setBackgroundColor(Color.parseColor("#819ca9"));
        }
    }

    @Override
    public int getItemCount() {
        return firstNames.size();
    }

    static class RecycleViewHolder extends RecyclerView.ViewHolder {
        final TextView studentFirstName;
        final TextView studentLastName;
        final LinearLayout layout;

        RecycleViewHolder(@NonNull View itemView) {
            super(itemView);
            studentFirstName = itemView.findViewById(R.id.student_first_name);
            studentLastName = itemView.findViewById(R.id.student_last_name);
            layout = itemView.findViewById(R.id.list_item);
        }
    }
}
