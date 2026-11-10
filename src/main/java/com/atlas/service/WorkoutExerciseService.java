package com.atlas.service;

import com.atlas.entity.ExerciseSet;
import com.atlas.entity.WorkoutExercise;
import com.atlas.repository.ExerciseSetRepository;
import com.atlas.repository.WorkoutExerciseRepository;
import org.jspecify.annotations.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkoutExerciseService {

    private static final Logger logger = LoggerFactory.getLogger(WorkoutExerciseService.class);

    private final WorkoutExerciseRepository workoutExerciseRepository;

    public WorkoutExerciseService(WorkoutExerciseRepository workoutExerciseRepository) {
        this.workoutExerciseRepository = workoutExerciseRepository;
    }

    public List<WorkoutExercise> getAllWorkoutExercises() {
        logger.info("Fetching All Workout Exercises...");
        return workoutExerciseRepository.findAll();
    }

    public WorkoutExercise getWorkoutExerciseById(@NonNull Integer id) {
        logger.info("Getting Workout Exercise: {}", id);
        Optional<WorkoutExercise> workoutExercise = workoutExerciseRepository.findById(id);
        return workoutExercise.orElse(null);
    }

    public WorkoutExercise createWorkoutExercise(WorkoutExercise newWorkoutExercise) {
        workoutExerciseRepository.save(newWorkoutExercise);
        return newWorkoutExercise;
    }

    public void deleteWorkoutExerciseById(@NonNull Integer id) {
        workoutExerciseRepository.deleteById(id);
    }
}
