package com.atlas.controller;

import com.atlas.entity.ExerciseSet;
import com.atlas.service.ExerciseSetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/exercise/set")
public class ExerciseSetController {

    private static final Logger logger = LoggerFactory.getLogger(ExerciseSetController.class);

    private final ExerciseSetService exerciseSetService;

    public ExerciseSetController(ExerciseSetService exerciseSetService) {
        this.exerciseSetService = exerciseSetService;
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<?> getAllExerciseSets() {
        try {
            return ResponseEntity.ok(exerciseSetService.getAllExerciseSets());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error Fetching All Exercise Sets");
        }
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> getExerciseSetById(@PathVariable Integer id) {
        try {
            ExerciseSet exerciseSet = exerciseSetService.getExerciseSetById(id);
            return ResponseEntity.ok().body(exerciseSet);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error Fetching Exercise Set Id: " + id);
        }

    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<?> createExerciseSet(@RequestBody ExerciseSet exerciseSet) {
        exerciseSet.setCreatedAt(LocalDateTime.now());
        if (exerciseSetService.createExerciseSet(exerciseSet)) {
            return ResponseEntity.ok().body(exerciseSet);
        } else {
            // TODO: return error message?
            return ResponseEntity.internalServerError().body("Error Creating Exercise Set");
        }
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> deleteExerciseSetById(@PathVariable Integer id) {
        if (exerciseSetService.deleteExerciseSetById(id)) {
            return ResponseEntity.ok().body("Successfully Deleted Exercise Set: " + id);
        } else {
            return ResponseEntity.internalServerError().body("Error Occurred While Deleting Exercise Set: " + id);
        }
    }
}
