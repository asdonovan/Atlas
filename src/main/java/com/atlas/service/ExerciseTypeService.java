package com.atlas.service;

import com.atlas.entity.ExerciseType;
import com.atlas.repository.ExerciseTypeRepository;
import org.jspecify.annotations.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExerciseTypeService {

    private static final Logger logger = LoggerFactory.getLogger(ExerciseTypeService.class);

    private final ExerciseTypeRepository exerciseTypeRepository;

    public ExerciseTypeService(ExerciseTypeRepository exerciseTypeRepository) {
        this.exerciseTypeRepository = exerciseTypeRepository;
    }

    public List<ExerciseType> getAllExerciseTypes() {
        logger.info("Fetching All Exercise Types...");
        return exerciseTypeRepository.findAll();
    }

    public ExerciseType getExerciseTypeById(@NonNull Integer id) {
        logger.info("Getting Exercise Type: {}", id);
        Optional<ExerciseType> exerciseTypeOptional = exerciseTypeRepository.findById(id);
        return exerciseTypeOptional.orElse(null);
    }

    public ExerciseType createExerciseType(@NonNull ExerciseType newExerciseType) {
        // TODO: Below search only looks for case, should also include spaces/special characters
        logger.info("Searching for existing exercise type: {}", newExerciseType.getExerciseName());
        Optional<ExerciseType> exerciseType = exerciseTypeRepository.findByExerciseNameIgnoreCase(newExerciseType.getExerciseName());
        if (exerciseType.isPresent()) {
            logger.info("{} exercise type already exists", newExerciseType.getExerciseName());
            // Update existing record with new information
            newExerciseType.setExerciseTypeId(exerciseType.get().getExerciseTypeId());
        }
        exerciseTypeRepository.save(newExerciseType);
        logger.info("Exercise Created: {}", newExerciseType.getExerciseName());
        return newExerciseType;
    }

    public void deleteExerciseTypeById(@NonNull Integer id) {
        try {
            exerciseTypeRepository.deleteById(id);
        } catch (Exception e) {
            logger.error("Error deleting id {} with issue: {}", id, e.getMessage());
        }
    }
}
