import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameStatistics statistics = new GameStatistics();
        GuessGame game = new GuessGame(statistics);

        game.playGame();

        scanner.close();
    }
}
