    package com.varyag.testworkoutapp.ui.home;

    import androidx.lifecycle.LiveData;
    import androidx.lifecycle.MutableLiveData;
    import androidx.lifecycle.ViewModel;
    import com.varyag.testworkoutapp.entity.WorkoutItem;

    import java.util.ArrayList;

    public class HomeViewModel extends ViewModel {

        private final MutableLiveData<String> mText;
        private final MutableLiveData<ArrayList<WorkoutItem>> workoutItems;

        public HomeViewModel() {
            mText = new MutableLiveData<>();
            workoutItems = new MutableLiveData<>();
            loadWorkouts();
        }
        private void loadWorkouts() {
            workoutItems.setValue(HomeModel.getArr());
        }

        public LiveData<String> getText() {
            return mText;
        }
        public LiveData<ArrayList<WorkoutItem>> getWorkoutItems() {
            return workoutItems;
        }

    }