package com.atlas.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class ExerciseSet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // tells hibernate to use dbs identity mechanism to generate id
    private Integer exerciseSetId;

    @ManyToOne // Many exercise sets can belong to one workout exercise
    @JoinColumn(name = "workout_exercise_id") // Foreign key
    private WorkoutExercise workoutExercise;

    @Column
    private Integer setOrderNum;

    @Column
    private BigDecimal weightLbs;

    @Column
    private Integer repetitions;

    @Column
    private BigDecimal cardioIncline;

    @Column
    private BigDecimal cardioDistanceMi;

    @Column
    private BigDecimal cardioSpeedMph;

    @Column
    private String durationMin;

    @Column
    private LocalDateTime createdAt;

    public Integer getExerciseSetId() {
        return exerciseSetId;
    }

    public void setExerciseSetId(Integer exerciseSetId) {
        this.exerciseSetId = exerciseSetId;
    }

    public WorkoutExercise getWorkoutExercise() {
        return workoutExercise;
    }

    public void setWorkoutExercise(WorkoutExercise workoutExercise) {
        this.workoutExercise = workoutExercise;
    }

    public Integer getSetOrderNum() {
        return setOrderNum;
    }

    public void setSetOrderNum(Integer setOrderNum) {
        this.setOrderNum = setOrderNum;
    }

    public BigDecimal getWeightLbs() {
        return weightLbs;
    }

    public void setWeightLbs(BigDecimal weightLbs) {
        this.weightLbs = weightLbs;
    }

    public Integer getRepetitions() {
        return repetitions;
    }

    public void setRepetitions(Integer repetitions) {
        this.repetitions = repetitions;
    }

    public BigDecimal getCardioIncline() {
        return cardioIncline;
    }

    public void setCardioIncline(BigDecimal cardioIncline) {
        this.cardioIncline = cardioIncline;
    }

    public BigDecimal getCardioDistanceMi() {
        return cardioDistanceMi;
    }

    public void setCardioDistanceMi(BigDecimal cardioDistanceMi) {
        this.cardioDistanceMi = cardioDistanceMi;
    }

    public BigDecimal getCardioSpeedMph() {
        return cardioSpeedMph;
    }

    public void setCardioSpeedMph(BigDecimal cardioSpeedMph) {
        this.cardioSpeedMph = cardioSpeedMph;
    }

    public String getDurationMin() {
        return durationMin;
    }

    public void setDurationMin(String durationMin) {
        this.durationMin = durationMin;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
