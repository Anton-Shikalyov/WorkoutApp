package com.varyag.testworkoutapp.entity;

import java.util.ArrayList;

public class WorkoutItem {
    public int image;
    public int bigImage;
    public String title;
    public String exercise;
    public String time;
    public String kcal;
    public ArrayList<SubExercises> subExercises;

    public WorkoutItem(int image, int bigImage, String title, String exercise, String time, String kcal, ArrayList<SubExercises> subExercises) {
        this.bigImage = bigImage;
        this.image = image;
        this.title = title;
        this.exercise = exercise;
        this.time = time;
        this.kcal = kcal;
        this.subExercises = subExercises;
    }
}


