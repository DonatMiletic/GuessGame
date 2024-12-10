import java.util.Random;
import java.util.Scanner;

public class GuessGame {
    private int appNumber;
    private DifficultyLevel difficulty;
    private int playerNumber;
    private GameStatistics statistics;

    public GuessGame(GameStatistics statistics) {
        this.statistics = statistics;
    }

    public void displayWelcomeAndChooseDifficulty() {
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
        while (true) {
            int number = scanner.nextInt();
            if (number >= 1 && number <= difficulty.getMaxRange()) {
                this.playerNumber = number;
                break;
            } else {
                System.out.println("Please input a valid number between 1 and " + difficulty.getMaxRange() + ".");
            }
        }
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Try to guess the absolute difference between your number and mine!");

        int attempts = 0;
        boolean correctGuess = false;

        while (!correctGuess) {
            System.out.print("Enter your guess for the difference: ");
            int guessedDifference = scanner.nextInt();

            int actualDifference = Math.abs(appNumber - playerNumber);
            attempts++;

            if (guessedDifference == actualDifference) {
                System.out.println("Congratulations, you guessed correctly!");
                correctGuess = true;
            } else if (guessedDifference > actualDifference) {
                System.out.println("The actual difference is smaller.");
            } else {
                System.out.println("The actual difference is larger.");
            }
        }

        statistics.updateStatistics(attempts);
    }
}
