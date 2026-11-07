package com.atlas.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "exercise_type") // Dont need annotation at all if class name is camelCase of db table
public class ExerciseType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // tells hibernate to use dbs identity mechanism to generate id
    @Column // Dont need if attribute name is camel case version of database name
    private Integer exerciseTypeId;

    @Column(name = "exercise_name")
    private String exerciseName;

    @Column(name = "exercise_description")
    private String exerciseDescription;

    @Column(name = "muscle_groups")
    private String muscleGroups;

    @Column(name = "machine_used")
    private String machineUsed;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public ExerciseType() {}

    public Integer getExerciseTypeId() {
        return exerciseTypeId;
    }

    public void setExerciseTypeId(Integer exerciseTypeId) {
        this.exerciseTypeId = exerciseTypeId;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public String getExerciseDescription() {
        return exerciseDescription;
    }

    public void setExerciseDescription(String exerciseDescription) {
        this.exerciseDescription = exerciseDescription;
    }

    public String getMuscleGroups() {
        return muscleGroups;
    }

    public void setMuscleGroups(String muscleGroups) {
        this.muscleGroups = muscleGroups;
    }

    public String getMachineUsed() {
        return machineUsed;
    }

    public void setMachineUsed(String machineUsed) {
        this.machineUsed = machineUsed;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
