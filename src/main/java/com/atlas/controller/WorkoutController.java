package com.atlas.controller;

import com.atlas.entity.Workout;
import com.atlas.service.WorkoutService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/exercise/workout")
public class WorkoutController {

    public final WorkoutService workoutService;

    public WorkoutController(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<?> getAllWorkouts() {
        try {
            return ResponseEntity.ok(workoutService.getAllWorkouts());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error Fetching All Workouts");
        }
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> getWorkoutById(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(workoutService.getWorkoutById(id));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error Fetching Workout Id: " + id);
        }
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<?> createWorkout(@RequestBody Workout workout) {
        workout.setCreatedAt(LocalDateTime.now());
        if (workoutService.createWorkout(workout)) {
            return ResponseEntity.ok().body(workout);
        } else {
            // TODO: return error message?
            return ResponseEntity.internalServerError().body("Error Creating Workout");
        }
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> deleteWorkoutById(@PathVariable Integer id) {
        if (workoutService.deleteWorkoutById(id)) {
            return ResponseEntity.ok("Successfully Deleted Workout Id: " + id);
        } else {
            return ResponseEntity.internalServerError().body("Error Deleting Workout");
        }
    }
}
