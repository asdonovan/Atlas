package com.atlas.service;

import com.atlas.entity.ExerciseSet;
import com.atlas.repository.ExerciseSetRepository;
import org.jspecify.annotations.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExerciseSetService {

    private static final Logger logger = LoggerFactory.getLogger(ExerciseSetService.class);

    private final ExerciseSetRepository exerciseSetRepository;

    public ExerciseSetService(ExerciseSetRepository exerciseSetRepository) {
        this.exerciseSetRepository = exerciseSetRepository;
    }

    public List<ExerciseSet> getAllExerciseSets() {
        logger.info("Fetching All Exercise Sets...");
        return exerciseSetRepository.findAll();
    }

    public ExerciseSet getExerciseSetById(@NonNull Integer id) {
        logger.info("Getting Exercise Set: {}", id);
        Optional<ExerciseSet> exerciseSet = exerciseSetRepository.findById(id);
        return exerciseSet.orElse(null);
    }

    public Boolean createExerciseSet(ExerciseSet newExerciseSet) {
        logger.info("Creating New Exercise Set");
        try {
            exerciseSetRepository.save(newExerciseSet);
            logger.info("Successfully Created New Exercise Set");
            return true;
        } catch (Exception e) {
            logger.error("Error Creating New Exercise Set: {}", e.getMessage());
            return false;
        }
    }

    public Boolean deleteExerciseSetById(@NonNull Integer id) {
        logger.info("Deleting Exercise Set ID: {}", id);
        try  {
            exerciseSetRepository.deleteById(id);
            logger.info("Successfully Deleted Exercise Set ID: {}", id);
            return true;
        } catch (Exception e) {
            logger.error("Error Deleting Exercise Set ID {} with issue: {}", id, e.getMessage());
            return false;
        }
    }
}
