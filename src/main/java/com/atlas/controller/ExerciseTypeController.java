package com.atlas.controller;

import com.atlas.entity.ExerciseType;
import com.atlas.service.ExerciseTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/exercises")
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
    public ExerciseType createExerciseType(ExerciseType exerciseType) {
        return exerciseTypeService.createExerciseType(exerciseType);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public void deleteExerciseTypeById(Integer id) {
        exerciseTypeService.deleteExerciseTypeById(id);
    }
}
