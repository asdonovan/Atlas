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

    public Boolean deleteExerciseTypeById(@NonNull Integer id) {
        // TODO: This may need to cascade since this is a foreign key for other tables
        try {
            logger.info("Searching for Exercise Type ID: {}", id);
            if (!exerciseTypeRepository.existsById(id)) {
                logger.info("Exercise Type ID: {} does not exist", id);
                return false;
            }
            logger.info("Deleting Exercise Type ID: {}", id);
            exerciseTypeRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            logger.error("Error deleting Exercise Type {} with issue: {}", id, e.getMessage());
            return false;
        }
    }

    public Boolean deleteExerciseTypeByName(@NonNull String name) {
        // TODO: This may need to cascade since this is a foreign key for other tables
        try {
            logger.info("Deleting Exercise Type Name: {}", name);
            Integer recordsDeleted = exerciseTypeRepository.deleteByExerciseNameIgnoreCase(name);
            return recordsDeleted != 0;
        } catch (Exception e) {
            logger.error("Error deleting Exercise Type {} with issue: {}", name, e.getMessage());
            return false;
        }
    }
}
