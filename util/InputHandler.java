package util;

import java.util.Scanner;

public class InputHandler {

    public static int getValidNumber(Scanner scanner, int min, int max) {
        while (true) {
            try {
                int number = Integer.parseInt(scanner.nextLine());
                if (number >= min && number <= max) {
                    return number;
                } else {
                    System.out.println("Please enter a number between " + min + " and " + max + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }
    public static boolean shouldPlayAgain(Scanner scanner) {
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("Would you like to play again? (yes/no)");
            String response = scanner.nextLine().trim().toLowerCase();
            if (response.equals("yes")) {
                isRunning = false;
            } else if (response.equals("no")) {
                isRunning = false;
            } else {
                System.out.println("Invalid input. Please enter 'yes' or 'no'.");
            }
        }
        return isRunning;
    }

    public static int guessDifference(Scanner scanner, int actualDifference, int attempts) {
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
}
