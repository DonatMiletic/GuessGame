import util.NumberUtil;

import java.util.Random;
import java.util.Scanner;

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
        System.out.println("1. Easy (" + DifficultyLevel.EASY.getMinRange() + "-" + DifficultyLevel.EASY.getMaxRange() + ")");
        System.out.println("2. Medium (" + DifficultyLevel.MEDIUM.getMinRange() + "-" + DifficultyLevel.MEDIUM.getMaxRange() + ")");
        System.out.println("3. Hard (" + DifficultyLevel.HARD.getMinRange() + "-" + DifficultyLevel.HARD.getMaxRange() + ")");


        while (this.difficulty == null) {
            try {
                int choice = Integer.parseInt(scanner.nextLine());
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
                        System.out.println("Invalid choice. Please select 1, 2, or 3.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    public void generateAppNumber() {
        this.appNumber = NumberUtil.genRandNum(difficulty.getMinRange(), difficulty.getMaxRange());
    }

    public void askPlayerNumber(Scanner scanner) {
        System.out.println("Think of a number between " + difficulty.getMinRange() + " and " + difficulty.getMaxRange() + " and enter it:");
        boolean isInvalid = true;

        while (isInvalid) {
            try {
                int number = Integer.parseInt(scanner.nextLine());

                if (number >= difficulty.getMinRange() && number <= difficulty.getMaxRange()) {
                    this.playerNumber = number;
                    isInvalid = false; // Exit the loop once a valid number is entered
                } else {
                    System.out.println("Please input a valid number between " + difficulty.getMinRange() + " and " + difficulty.getMaxRange() + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    public int guessDifference(Scanner scanner, int actualDifference, int attempts) {
        int guessedDifference;
        boolean isIncorrect = true;

        while (isIncorrect) { // Loop until a valid guess is made
            System.out.print("Enter your guess for the difference: ");

            try {
                guessedDifference = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                continue; // Prompt again for input
            }

            attempts++;

            if (guessedDifference == actualDifference) {
                System.out.println("Congratulations, you guessed correctly!");
                isIncorrect = false;
            } else if (guessedDifference > actualDifference) {
                System.out.println("The actual difference is smaller.");
            } else {
                System.out.println("The actual difference is larger.");
            }
        }

        return attempts; // Return the number of attempts after the correct guess
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        int attempts = 0;
        boolean isRunning = true;

        chooseDifficulty(scanner);

        while (isRunning) {

            generateAppNumber();
            askPlayerNumber(scanner);

            int actualDifference = Math.abs(appNumber - playerNumber);

            System.out.println("Try to guess the absolute difference between your number and mine!");

            attempts = guessDifference(scanner, actualDifference, attempts);
            statistics.updateStatistics(attempts);
            statistics.showStatistics();
            //System.out.println("Would you like to play again? (yes/no)");

            boolean isInvalid = true;

            while (isInvalid) {
                System.out.println("Would you like to play again? (yes/no)");
                String response = scanner.nextLine().trim().toLowerCase();

                if (response.equals("yes")) {
                    isInvalid = false; // Exit the input validation loop
                } else if (response.equals("no")) {
                    System.out.println("Thank you for playing! Goodbye!");
                    isRunning = false; // Stop the game loop
                    isInvalid = false; // Exit the input validation loop
                } else {
                    System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                }
            }

        }
        scanner.close();
    }
}
