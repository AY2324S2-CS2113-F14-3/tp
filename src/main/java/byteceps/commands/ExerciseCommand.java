package byteceps.commands;

import java.util.ArrayList;
import java.util.List;
import byteceps.exercises.Exercise;
import byteceps.exercises.ExerciseManager;

public class ExerciseCommand extends Command {
    public static final String COMMAND_WORD = "exercise";
    private final ExerciseManager exerciseManager;

    public ExerciseCommand(InputArguments commandAction, ArrayList<InputArguments> additionalArguments) {
        super(commandAction, additionalArguments);
        this.exerciseManager = ExerciseManager.getInstance();
    }


    @Override
    public CommandResult execute() {
        switch (getAction()) {
        case "add":
            addExercise();
            break;
        case "delete":
            deleteExercise();
            break;
        case "list":
            listExercises();
            break;
        default:
            throw new UnsupportedOperationException();
        }

        return new CommandResult("TO IMPLEMENT");
    }

    public void addExercise() {
        String exerciseName = getActionParameters();
        if (!exerciseName.isEmpty()) {
            exerciseManager.addExercise(exerciseName);
            System.out.printf("Exercise '%s' added successfully.\n", exerciseName);
        } else {
            System.out.println("Exercise name cannot be empty.");
        }
    }

    public void deleteExercise() {
        String exerciseName = getActionParameters();
        if (!exerciseName.isEmpty()) {
            exerciseManager.deleteExercise(exerciseName);
            System.out.printf("Exercise '%s' deleted successfully.\n", exerciseName);
        } else {
            System.out.println("Exercise name cannot be empty.");
        }
    }

    public void listExercises() {
        List<Exercise> exercises = exerciseManager.getAllExercises();
        if (exercises.isEmpty()) {
            System.out.println("No exercises found.");
        } else {
            System.out.println("List of exercises:");
            for (Exercise exercise : exercises) {
                System.out.println(exercise.getExerciseName());
            }
        }
    }
}
