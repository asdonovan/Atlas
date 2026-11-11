package com.atlas.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // tells hibernate to use dbs identity mechanism to generate id
    private Integer workoutId;

    @Column
    private LocalDate workoutDate;

    @Column
    private Integer workoutDurationMin;

    @Column
    private LocalDateTime createdAt;

    public Integer getWorkoutId() {
        return workoutId;
    }

    public void setWorkoutId(Integer workoutId) {
        this.workoutId = workoutId;
    }

    public LocalDate getWorkoutDate() {
        return workoutDate;
    }

    public void setWorkoutDate(LocalDate workoutDate) {
        this.workoutDate = workoutDate;
    }

    public Integer getWorkoutDurationMin() {
        return workoutDurationMin;
    }

    public void setWorkoutDurationMin(Integer workoutDurationMin) {
        this.workoutDurationMin = workoutDurationMin;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
