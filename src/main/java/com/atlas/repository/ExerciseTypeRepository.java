package com.atlas.repository;

import com.atlas.entity.ExerciseType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// JpaRepository <T, ID>
public interface ExerciseTypeRepository extends JpaRepository<ExerciseType, Integer> {

    // Hibernate automatically creates the implementation for this since it understands method signature
    Optional<ExerciseType> findByExerciseNameIgnoreCase(String exerciseName);

    // Returns how many records were deleted
    Long deleteByExerciseNameIgnoreCase(String exerciseName);
}
