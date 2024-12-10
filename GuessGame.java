import java.util.Random;
import java.util.Scanner;

public class GuessGame {
    private int appNumber;
    private DifficultyLevel difficulty;
    private int totalGames;
    private int totalAttempts;
    private int minAttempts;
    private int maxAttempts;

    public GuessGame(DifficultyLevel difficulty) {
        this.difficulty = difficulty;
        this.totalGames = 0;
        this.totalAttempts = 0;
        this.minAttempts = Integer.MAX_VALUE;
        this.maxAttempts = Integer.MIN_VALUE;
        generateAppNumber();
    }

    public void generateAppNumber() {
        Random random = new Random();
        this.appNumber = random.nextInt(difficulty.getMaxRange()) + 1;
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Think of a number between 1 and " + difficulty.getMaxRange() + " (don't tell me!).");
        System.out.println("Try to guess the absolute difference between your number and mine!");

        int attempts = 0;
        boolean correctGuess = false;

        while (!correctGuess) {
            System.out.print("Enter your guess for the difference: ");
            int guessedDifference = scanner.nextInt();

            System.out.print("What number did you think of? ");
            int userNumber = scanner.nextInt();

            int actualDifference = Math.abs(appNumber - userNumber);
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

        updateStatistics(attempts);
    }

    private void updateStatistics(int attempts) {
        totalGames++;
        totalAttempts += attempts;
        minAttempts = Math.min(minAttempts, attempts);
        maxAttempts = Math.max(maxAttempts, attempts);
    }

    public void showStatistics() {
        System.out.println("Game statistics:");
        System.out.println("Total games played: " + totalGames);
        System.out.println("Average attempts per game: " + (totalAttempts / (double) totalGames));
        System.out.println("Fewest attempts in a game: " + minAttempts);
        System.out.println("Most attempts in a game: " + maxAttempts);
    }
}
