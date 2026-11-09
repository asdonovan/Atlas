package com.atlas.entity;

import com.atlas.service.ExerciseTypeService;
import jakarta.persistence.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "exercise_type") // Dont need annotation at all if class name is camelCase of db table
public class ExerciseType {

    private static final Logger logger = LoggerFactory.getLogger(ExerciseType.class);

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

    public Boolean validateNonNullFields() {
        logger.info("Validating Non Null Fields for ExerciseType");
        List nonNullList = Arrays.asList(
                exerciseName, exerciseDescription,
                muscleGroups, machineUsed
        );

        for (Object o : nonNullList) {
            //TODO: Possibly check for empty strings as well
            if (o == null) {
                logger.info("Null item found");
                return false;
            }
        }

        return true;
    }
}
