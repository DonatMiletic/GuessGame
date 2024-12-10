public class GameStatistics {
    private int totalGamesPlayed;
    private int totalAttempts;
    private int fewestAttempts;
    private int mostAttempts;

    public GameStatistics() {
        this.totalGamesPlayed = 0;
        this.totalAttempts = 0;
        this.fewestAttempts = Integer.MAX_VALUE; // Start with the maximum possible value
        this.mostAttempts = 0;
    }

    public void updateStatistics(int attempts) {
        totalGamesPlayed++;
        totalAttempts += attempts;
        if (attempts < fewestAttempts) {
            fewestAttempts = attempts;
        }
        if (attempts > mostAttempts) {
            mostAttempts = attempts;
        }
    }

    public void showStatistics() {
        System.out.println("Game statistics:");
        System.out.println("Total games played: " + totalGamesPlayed);
        System.out.println("Average attempts per game: " + (totalGamesPlayed == 0 ? 0 : (double) totalAttempts / totalGamesPlayed));
        System.out.println("Fewest attempts in a game: " + (fewestAttempts == Integer.MAX_VALUE ? 0 : fewestAttempts));
        System.out.println("Most attempts in a game: " + mostAttempts);
    }
}
