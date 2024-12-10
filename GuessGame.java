import java.util.Random;
import java.util.Scanner;

public class GuessGame {
    private int appNumber;
    private DifficultyLevel difficulty;
    private int playerNumber;
    private GameStatistics statistics;

    public GuessGame(GameStatistics statistics) {
        chooseDifficulty();
        this.statistics = statistics;
    }

    public void chooseDifficulty() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Guess the Difference game!");
        System.out.println("Choose difficulty level:");
        System.out.println("1. Easy (1-50)");
        System.out.println("2. Medium (1-100)");
        System.out.println("3. Hard (1-200)");

        DifficultyLevel selectedDifficulty = null;
        while (selectedDifficulty == null) {
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    selectedDifficulty = DifficultyLevel.EASY;
                    break;
                case 2:
                    selectedDifficulty = DifficultyLevel.MEDIUM;
                    break;
                case 3:
                    selectedDifficulty = DifficultyLevel.HARD;
                    break;
                default:
                    System.out.println("Invalid choice. Please select 1, 2, or 3.");
            }
        }
        this.difficulty = selectedDifficulty;
        generateAppNumber();
    }

    public void generateAppNumber() {
        Random random = new Random();
        this.appNumber = random.nextInt(difficulty.getMaxRange()) + 1;
    }

    public void askPlayerNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Think of a number between 1 and " + difficulty.getMaxRange() + " and enter it:");
        boolean isValid = false;

        while (!isValid) {
            try {
                int number = Integer.parseInt(scanner.nextLine());

                if (number >= 1 && number <= difficulty.getMaxRange()) {
                    this.playerNumber = number;
                    isValid = true; // Exit the loop once a valid number is entered
                } else {
                    System.out.println("Please input a valid number between 1 and " + difficulty.getMaxRange() + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    private int guessDifference(Scanner scanner, int actualDifference, int attempts) {
        System.out.print("Enter your guess for the difference: ");

        int guessedDifference;
        try {
            guessedDifference = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.");
            return guessDifference(scanner, actualDifference, attempts); // Retry after invalid input
        }

        attempts++;

        if (guessedDifference == actualDifference) {
            System.out.println("Congratulations, you guessed correctly!");
        } else if (guessedDifference > actualDifference) {
            System.out.println("The actual difference is smaller.");
            return guessDifference(scanner, actualDifference, attempts); // Continue guessing
        } else {
            System.out.println("The actual difference is larger.");
            return guessDifference(scanner, actualDifference, attempts); // Continue guessing
        }

        return attempts; // Return attempts when correct guess is made
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        int actualDifference = Math.abs(appNumber - playerNumber);
        int attempts = 0;

        askPlayerNumber();

        System.out.println("Try to guess the absolute difference between your number and mine!");

        attempts = guessDifference(scanner, actualDifference, attempts);

        System.out.println("Would you like to play again? (yes/no)");
        if (scanner.nextLine().equalsIgnoreCase("yes")) {
            statistics.updateStatistics(attempts);
            statistics.showStatistics();
            generateAppNumber();
            playGame();
        } else {
            statistics.updateStatistics(attempts);
            statistics.showStatistics();
            System.out.println("Thank you for playing! Goodbye!");
        }
    }
}
