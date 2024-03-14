package byteceps.exercises;

import java.util.ArrayList;
import java.util.List;

public class ExerciseManager {
    private static ExerciseManager instance;
    private final List<Exercise> exercises;

    public ExerciseManager() {
        this.exercises = new ArrayList<>();
    }

    public static ExerciseManager getInstance() {
        if (instance == null) {
            instance = new ExerciseManager();
        }
        return instance;
    }

    public void addExercise(String exerciseName) {
        Exercise exercise = new Exercise(exerciseName);
        exercises.add(exercise);
    }

    public void deleteExercise(String exerciseName) {
        for (Exercise exercise : exercises) {
            if (exercise.exerciseName.equals(exerciseName)) {
                exercises.remove(exercise);
                return;
            }
        }
    }

    public List<Exercise> getAllExercises() {
        return new ArrayList<>(exercises);
    }
}
