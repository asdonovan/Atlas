package com.atlas.service;

import com.atlas.entity.Workout;
import com.atlas.entity.WorkoutExercise;
import com.atlas.repository.WorkoutExerciseRepository;
import com.atlas.repository.WorkoutRepository;
import org.jspecify.annotations.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkoutService {


    private static final Logger logger = LoggerFactory.getLogger(WorkoutService.class);

    private final WorkoutRepository workoutRepository;

    public WorkoutService(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    public List<Workout> getAllWorkouts() {
        logger.info("Fetching All Workouts...");
        return workoutRepository.findAll();
    }

    public Workout getWorkoutById(@NonNull Integer id) {
        logger.info("Getting Workout: {}", id);
        Optional<Workout> workout = workoutRepository.findById(id);
        return workout.orElse(null);
    }

    public Workout createWorkout(Workout newWorkout) {
        workoutRepository.save(newWorkout);
        return newWorkout;
    }

    public void deleteWorkoutById(@NonNull Integer id) {
        workoutRepository.deleteById(id);
    }
}
