import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain;
        GuessGame game = null;

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

        game = new GuessGame(selectedDifficulty);

        do {
            game.playGame();
            game.showStatistics();

            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");

            if (playAgain) {
                game.generateAppNumber(); // Reset the app's number for a new round
            }

        } while (playAgain);

        System.out.println("Thank you for playing! Goodbye!");
        scanner.close();
    }
}
