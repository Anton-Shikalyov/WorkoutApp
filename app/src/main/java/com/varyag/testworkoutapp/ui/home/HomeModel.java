package com.varyag.testworkoutapp.ui.home;

import androidx.lifecycle.ViewModel;
import com.varyag.testworkoutapp.R;
import com.varyag.testworkoutapp.entity.SubExercises;
import com.varyag.testworkoutapp.entity.WorkoutItem;
import java.util.ArrayList;
public class HomeModel extends ViewModel {

    public static ArrayList<WorkoutItem> getArr() {
        ArrayList<WorkoutItem> arr = new ArrayList<>();
        int image = R.drawable.workout_man;
        int bigImage = R.drawable.workout_man_big;

        int squats = R.drawable.squats;
        int lunges = R.drawable.lunges;
        int bulgarianLunges = R.drawable.bulgarian_lunges;
        ArrayList<SubExercises> subExercises = new ArrayList<>();
        subExercises.add(new SubExercises("Squats", "3 min", squats));
        subExercises.add(new SubExercises("Lunges", "3 min", lunges));
        subExercises.add(new SubExercises("BulgarianLunges", "3 min", bulgarianLunges));

        arr.add(new WorkoutItem(image, bigImage, "Legs", "exercise", "10min", "200 Kcal", subExercises));

        return arr;
    }
}
