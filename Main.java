import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain;
        GameStatistics statistics = new GameStatistics();
        GuessGame game = new GuessGame(statistics);

        game.displayWelcomeAndChooseDifficulty();
        do {
            game.askPlayerNumber(); // Traži broj od igrača za ovu rundu
            game.playGame();        // Pogađanje apsolutne razlike
            statistics.showStatistics();

            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");

            if (playAgain) {
                game.generateAppNumber(); // Generiše novi broj za aplikaciju za sledeću rundu
            }

        } while (playAgain);

        System.out.println("Thank you for playing! Goodbye!");
        scanner.close();
    }
}
