package com.atlas.service;

import com.atlas.entity.Workout;
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

    public Boolean createWorkout(Workout newWorkout) {
        logger.info("Creating New Workout");
        try {
            workoutRepository.save(newWorkout);
            logger.info("Successfully Created New Workout");
            return true;
        } catch (Exception e) {
            logger.error("Error Creating New Workout: {}", e.getMessage());
            return false;
        }
    }

    public Boolean deleteWorkoutById(@NonNull Integer id) {
        logger.info("Attempting To Delete Workout Id: {}", id);
        try {
            workoutRepository.deleteById(id);
            logger.info("Successfully Deleted Workout Id: {}", id);
            return true;
        } catch (Exception e) {
            logger.error("Error Occurred Deleting Workout Id: {}", id);
            return false;
        }
    }
}
