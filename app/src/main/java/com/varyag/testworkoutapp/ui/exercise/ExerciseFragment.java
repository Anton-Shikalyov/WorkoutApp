package com.varyag.testworkoutapp.ui.exercise;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.varyag.testworkoutapp.R;
import com.varyag.testworkoutapp.adapter.CustomAdapter;
import com.varyag.testworkoutapp.adapter.ExerciseAdapter;
import com.varyag.testworkoutapp.databinding.FragmentExerciseBinding;
import com.varyag.testworkoutapp.entity.LevelList;
import java.util.ArrayList;
import java.util.Objects;

public class ExerciseFragment extends Fragment {
    private FragmentExerciseBinding binding;
    private ExerciseAdapter exerciseAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ExerciseViewModel exerciseViewModel =
                new ViewModelProvider(this).get(ExerciseViewModel.class);
        binding = FragmentExerciseBinding.inflate(inflater, container, false);

        final RecyclerView recyclerView = binding.listExercise;
        final ImageButton back = binding.topLeftButton;
        final FrameLayout start = binding.startFrame;
        final TextView startText = binding.start;
        final TextView title = binding.title;
        final TextView exercieses = binding.exercieses;
        final TextView kcal = binding.kcal;
        final ImageView imageView = binding.imageBig;
        NavController navController = NavHostFragment.findNavController(this);
        start.setBackgroundResource(R.drawable.item_image_btn);

        View root = binding.getRoot();

        Spinner spinner = binding.spinner;
        @SuppressLint("UseRequireInsteadOfGet")
        CustomAdapter adapter = new  CustomAdapter(Objects.requireNonNull(this.getContext()), R.layout.spinner_text, R.layout.spinner_text_dropdown, LevelList.list);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        exerciseAdapter = new ExerciseAdapter(new ArrayList<>());
        recyclerView.setAdapter(exerciseAdapter);
        exerciseViewModel.getWorkoutItems().observe(getViewLifecycleOwner(), workoutItems -> {
            if (workoutItems != null) {
                exerciseAdapter.updateData(workoutItems.get(0).subExercises);
            }
            title.setText(Objects.requireNonNull(workoutItems).get(0).title);
            exercieses.setText(workoutItems.get(0).exercise);
            kcal.setText(workoutItems.get(0).kcal);
            imageView.setImageResource(workoutItems.get(0).bigImage);
        });

        back.setOnClickListener((View v) -> navController.navigate(R.id.action_nav_exercise_to_nav_home));
        start.setOnClickListener((View v) -> exerciseViewModel.timer());

        exerciseViewModel.textTimer().observe(getViewLifecycleOwner(), v -> {
            startText.setText(v);
            if (Objects.equals(v, "done!")) {
                navController.navigate(R.id.action_nav_exercise_to_nav_home);
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}