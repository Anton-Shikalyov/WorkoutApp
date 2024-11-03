package com.varyag.testworkoutapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.varyag.testworkoutapp.R;
import com.varyag.testworkoutapp.entity.SubExercises;

import java.util.ArrayList;

public class ExerciseAdapter extends RecyclerView.Adapter<ExerciseAdapter.WorkoutViewHolder> {
    private ArrayList<SubExercises> workoutItems;

    public ExerciseAdapter(ArrayList<SubExercises> workoutItems) {
        this.workoutItems = workoutItems != null ? workoutItems : new ArrayList<>();
    }

    public void updateData(ArrayList<SubExercises> newWorkoutItems) {
        this.workoutItems = newWorkoutItems != null ? newWorkoutItems : new ArrayList<>();
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public WorkoutViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_exercise_list, parent, false);
        return new WorkoutViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WorkoutViewHolder holder, int position) {
        SubExercises item = workoutItems.get(position);
        holder.title.setText(item.title);
        holder.imageView.setImageResource(item.image);
        holder.time.setText(item.time);
    }

    @Override
    public int getItemCount() {
        return workoutItems.size();
    }

    static class WorkoutViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView time;
        ImageView imageView;

        WorkoutViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.titleEx);
            time = itemView.findViewById(R.id.timeEx);
            imageView = itemView.findViewById(R.id.imageEx);
        }
    }
}
