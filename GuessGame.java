import util.InputHandler;
import util.NumberUtil;
import util.EnumUtil;

import java.util.Random;
import java.util.Scanner;

import static util.EnumUtil.getAllOrdinals;

public class GuessGame {
    private int appNumber;
    private DifficultyLevel difficulty;
    private int playerNumber;
    private final GameStatistics statistics;

    public GuessGame() {
        this.statistics = new GameStatistics();
    }

    public void chooseDifficulty(Scanner scanner) {
        System.out.println("Welcome to the Guess the Difference game!");
        System.out.println("Choose difficulty level:");
        for (DifficultyLevel level : DifficultyLevel.values()) {
            System.out.println((level.ordinal() + 1) + " " + level +
                    " (" + level.getMinRange() + "-" + level.getMaxRange() + ")");
        }


        while (this.difficulty == null) {
            int choice = InputHandler.getValidNumber(scanner, getAllOrdinals(DifficultyLevel.class).getFirst(), getAllOrdinals(DifficultyLevel.class).getLast());
            switch (choice) {
                case 1:
                    this.difficulty = DifficultyLevel.EASY;
                    break;
                case 2:
                    this.difficulty = DifficultyLevel.MEDIUM;
                    break;
                case 3:
                    this.difficulty = DifficultyLevel.HARD;
                    break;
                default:
                    System.out.println("Invalid choice. Please select " + getAllOrdinals(DifficultyLevel.class));
            }
        }
    }

    public void generateAppNumber() {
        this.appNumber = NumberUtil.genRandNum(difficulty.getMinRange(), difficulty.getMaxRange());
    }

    public void askPlayerNumber(Scanner scanner, DifficultyLevel difficulty) {
        System.out.println("Think of a number between " + difficulty.getMinRange() + " and " + difficulty.getMaxRange() + " and enter it:");
        boolean isInvalid = true;

        while (isInvalid) {
            int number = InputHandler.getValidNumber(scanner, difficulty.getMinRange(), difficulty.getMaxRange());

            if (number >= difficulty.getMinRange() && number <= difficulty.getMaxRange()) {
                this.playerNumber = number;
                isInvalid = false; // Exit the loop once a valid number is entered
            } else {
                System.out.println("Please input a valid number between " + difficulty.getMinRange() + " and " + difficulty.getMaxRange() + ".");
            }
        }
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        int attempts = 0;
        boolean isRunning = true;

        chooseDifficulty(scanner);

        while (isRunning) {

            generateAppNumber();
            askPlayerNumber(scanner, this.difficulty);

            int actualDifference = Math.abs(appNumber - playerNumber);

            System.out.println("Try to guess the absolute difference between your number and mine!");

            attempts = InputHandler.guessDifference(scanner, actualDifference, attempts);
            statistics.updateStatistics(attempts);
            statistics.showStatistics();

            isRunning = InputHandler.shouldPlayAgain(scanner);

            scanner.close();
        }
    }
}
