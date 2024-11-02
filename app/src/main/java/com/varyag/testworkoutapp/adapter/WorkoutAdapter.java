package com.varyag.testworkoutapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.RecyclerView;
import com.varyag.testworkoutapp.R;
import com.varyag.testworkoutapp.animation.DumbbelAnimation;
import com.varyag.testworkoutapp.databinding.FragmentHomeBinding;
import com.varyag.testworkoutapp.entity.WorkoutItem;

import java.util.ArrayList;

public class WorkoutAdapter extends RecyclerView.Adapter<WorkoutAdapter.WorkoutViewHolder> {
    private ArrayList<WorkoutItem> workoutItems;
    private final NavController navController;
    private final FragmentHomeBinding binding;


    public WorkoutAdapter(ArrayList<WorkoutItem> workoutItems, NavController navController, FragmentHomeBinding binding) {
        this.workoutItems = workoutItems != null ? workoutItems : new ArrayList<>();
        this.navController = navController;
        this.binding = binding;
    }

    public void updateData(ArrayList<WorkoutItem> newWorkoutItems) {
        this.workoutItems = newWorkoutItems != null ? newWorkoutItems : new ArrayList<>();
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public WorkoutViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_workout_list, parent, false);
        return new WorkoutViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WorkoutViewHolder holder, int position) {
        WorkoutItem item = workoutItems.get(position);
        holder.title.setText(item.title);
        holder.imageView.setImageResource(item.image);
        holder.exercise.setText(item.exercise);
        holder.time.setText(item.time);


        holder.imageButton.setOnClickListener(view -> {
            if (navController != null) {
                final FrameLayout frameLayout = (FrameLayout) binding.ellipse101;
                final ImageView imageView =  binding.dumbbell;
                frameLayout.setVisibility(View.VISIBLE);
                DumbbelAnimation.startDumbbellAnimation(imageView,frameLayout, navController);
            }
        });
    }

    @Override
    public int getItemCount() {
        return workoutItems.size();
    }

    static class WorkoutViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView exercise;
        TextView time;
        ImageView imageView;
        ImageButton imageButton;

        WorkoutViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            exercise = itemView.findViewById(R.id.exercieses);
            time = itemView.findViewById(R.id.time);
            imageView = itemView.findViewById(R.id.image);
            imageButton = itemView.findViewById(R.id.itemBtn);

        }
    }
}
