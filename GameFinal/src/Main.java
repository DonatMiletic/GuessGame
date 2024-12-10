import java.util.Random;
import java.util.Scanner;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {



        int userAbs;


        //Game counterTotalPlayedGames = (playedGames) -> playedGames + 1;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter game mode difficulty from listed bellow :");
        System.out.print("1 - Easy \n2 - Medium \n3 - Hard \n");
        System.out.print("Enter number : ");
        int mode = sc.nextInt();


        Game_Mode demo=new Game_Mode();
        demo.gameMode(mode);

        Game_Diff start=new Game_Diff(demo);
        Statistics stats=new Statistics();
        System.out.println("game mode: " + mode);









        //GAME LOOP
        while(true){

            //User is choosing number
            System.out.println("Please enter number between 1 and "+demo.numEnd+" : ");
            int numberPlayer=sc.nextInt();
            start.numberPlayer(numberPlayer);

            //System.out.println("player number :"+numberPlayer);
            //CPU is choosing number
           int numberApp= start.cpuNumber();
            //System.out.println("CPU number: " + numberApp);

            //calculates real/true abs
            int absDiff= Math.abs(numberApp-numberPlayer);

            //System.out.println("Difference : " + absDiff);

                stats.numOfTrysPerRound=0;
            //Player guessing abs diff
            while (true) {
                System.out.println("Please enter correct number difference between you (PLAYER) and  CPU: ");
                userAbs = sc.nextInt();
                if (userAbs < absDiff) {
                    System.out.println("Difference is larger than your INPUT");
                    //numberOfTrysPerRound += 1;
                    stats.numberOfTrysPerRound();
                } else if (userAbs > absDiff) {
                    System.out.println("Difference is lower than your INPUT");
                    //numberOfTrysPerRound += 1;
                    stats.numberOfTrysPerRound();
                } else {
                    System.out.println("Congrats!! YOU GUESSED CORRECTLY");
                    System.out.println("True difference was: " + absDiff);
                    //numberOfTrysPerRound += 1;
                    stats.numberOfTrysPerRound();
                    break;
                }
            }
            stats.gamesPlayed();
            //number of guesses per round
            System.out.println("You needed : "+stats.numOfTrysPerRound+" try/trys to guess correct number this round!");

            //avg number of trys
            stats.avgNumOfTrys();

            System.out.println("Number of rounds played: "+stats.gamesPlayed);

            System.out.println("Average number of trys: "+stats.avgNumOfTrys);





            //worst case
            stats.maxNumOfTrys();
            //best case
            stats.minNumOfTrys();






            System.out.println("Do you want to play again? (Y/N)");
            sc.nextLine(); // Consume newline
            String input =sc.nextLine().trim().toLowerCase();
            //EXIT GAME LOOP
            if(input.equals("n")){

                System.out.println("THANK YOU FOR PLAYING!! <3");
                break;


            }
        }






        sc.close();
    }
}