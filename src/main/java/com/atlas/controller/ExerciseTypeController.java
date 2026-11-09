package com.atlas.controller;

import com.atlas.entity.ExerciseType;
import com.atlas.service.ExerciseTypeService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/exercise/type")
public class ExerciseTypeController {

    private final ExerciseTypeService exerciseTypeService;

    public ExerciseTypeController(ExerciseTypeService exerciseTypeService) {
        this.exerciseTypeService = exerciseTypeService;
    }

    @GetMapping
    @ResponseBody
    public List<ExerciseType> getAllExerciseTypes() {
        return exerciseTypeService.getAllExerciseTypes();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ExerciseType getExerciseTypeById(@PathVariable Integer id) {
        return exerciseTypeService.getExerciseTypeById(id);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<?> createExerciseType(@RequestBody ExerciseType exerciseType) {
        if (exerciseType.validateNonNullFields()) {
            exerciseType.setCreatedAt(LocalDateTime.now());
            return ResponseEntity.ok(exerciseTypeService.createExerciseType(exerciseType));
        }
        return ResponseEntity.badRequest().body("Unable to create ExerciseType. Invalid Payload");
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> deleteExerciseTypeById(@PathVariable Integer id) {
        Boolean success = exerciseTypeService.deleteExerciseTypeById(id);
        if (success) {
            return ResponseEntity.ok().body("Exercise Type Id " + id + " successfully deleted");
        } else {
            return ResponseEntity.internalServerError().body("Something went wrong when deleting Exercise Type Id: " + id);
        }
    }

    @DeleteMapping("/{name}")
    @ResponseBody
    public ResponseEntity<?> deleteExerciseTypeByName(@PathVariable String name) {
        // TODO: make this accept a payload, not path variable (spaces/long names)
        Boolean success = exerciseTypeService.deleteExerciseTypeByName(name);
        if (success) {
            return ResponseEntity.ok().body("Exercise Type Name " + name + " successfully deleted");
        } else {
            return ResponseEntity.internalServerError().body("Something went wrong when deleting Exercise Type Name: " + name);
        }
    }
}
