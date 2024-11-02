package com.varyag.testworkoutapp.ui.exercise;

import android.os.CountDownTimer;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.varyag.testworkoutapp.entity.SubExercises;
import com.varyag.testworkoutapp.entity.WorkoutItem;
import com.varyag.testworkoutapp.ui.home.HomeModel;

import java.util.ArrayList;

public class ExerciseViewModel extends ViewModel {
    private final MutableLiveData<ArrayList<WorkoutItem>> subEx;
    private final MutableLiveData<String> timer;
    private boolean isTimerRunning = false;

    public ExerciseViewModel() {
        subEx = new MutableLiveData<>();
        timer = new MutableLiveData<>();

        loadWorkouts();
    }
    private void loadWorkouts() {
        subEx.setValue(HomeModel.getArr());
    }
    public void timer() {
        if (isTimerRunning) {
            return;
        }
        isTimerRunning = true;
        new CountDownTimer(20000, 900) {
            public void onTick(long millisUntilFinished) {
                timer.setValue(String.valueOf(millisUntilFinished / 1000));
            }
            public void onFinish() {
                isTimerRunning = false;
                timer.setValue("done!");
            }
        }.start();
    }


    public LiveData<ArrayList<WorkoutItem>> getWorkoutItems() {
        return subEx;
    }

    public LiveData<String> textTimer() {
        return timer;
    }

}