package com.atlas.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class WorkoutExercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // tells hibernate to use dbs identity mechanism to generate id
    private Integer workoutExerciseId;

    @ManyToOne
    @JoinColumn(name = "workout_id")
    private Workout workout;

    @ManyToOne
    @JoinColumn(name = "exercise_type_id")
    private ExerciseType exerciseType;

    private Integer exerciseOrderNum;

    private Integer minutesToComplete;

    private LocalDateTime createdAt;

    public Integer getWorkoutExerciseId() {
        return workoutExerciseId;
    }

    public void setWorkoutExerciseId(Integer workoutExerciseId) {
        this.workoutExerciseId = workoutExerciseId;
    }

    public Workout getWorkout() {
        return workout;
    }

    public void setWorkout(Workout workout) {
        this.workout = workout;
    }

    public ExerciseType getExerciseType() {
        return exerciseType;
    }

    public void setExerciseType(ExerciseType exerciseType) {
        this.exerciseType = exerciseType;
    }

    public Integer getExerciseOrderNum() {
        return exerciseOrderNum;
    }

    public void setExerciseOrderNum(Integer exerciseOrderNum) {
        this.exerciseOrderNum = exerciseOrderNum;
    }

    public Integer getMinutesToComplete() {
        return minutesToComplete;
    }

    public void setMinutesToComplete(Integer minutesToComplete) {
        this.minutesToComplete = minutesToComplete;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
