package com.varyag.testworkoutapp.ui.home;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.varyag.testworkoutapp.MainActivity;
import com.varyag.testworkoutapp.R;
import com.varyag.testworkoutapp.adapter.WorkoutAdapter;
import com.varyag.testworkoutapp.databinding.FragmentHomeBinding;

import java.util.ArrayList;


public class HomeFragment extends Fragment {
    private FragmentHomeBinding binding;
    private WorkoutAdapter workoutAdapter;

    @SuppressLint("RtlHardcoded")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.workoutExe;
        final ImageButton settingsBtn = binding.actionSettings;
        final RecyclerView recyclerView = binding.workoutList;

        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        NavController navController = NavHostFragment.findNavController(this);
        workoutAdapter = new WorkoutAdapter(new ArrayList<>(), navController, binding);
        recyclerView.setAdapter(workoutAdapter);
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        homeViewModel.getWorkoutItems().observe(getViewLifecycleOwner(), workoutItems -> {
            workoutAdapter.updateData(workoutItems);
        });

        settingsBtn.setOnClickListener(v -> {
            ((MainActivity) requireActivity()).openDrawer();
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}