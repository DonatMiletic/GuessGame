public class Statistics {


   private int gamesPlayed = 0;
    private int sumTrys;
    private int numOfTrysPerRound = 0;
    private double avgNumOfTrys = 0;
    private int minNumOfTrys = 1000;
    private int maxNumOfTrys = 1;


    public void gamesPlayed() {
        gamesPlayed++;
    }

    public void numberOfTrysPerRound() {


        numOfTrysPerRound += 1;
    }

    public void avgNumOfTrys() {
        sumTrys += numOfTrysPerRound;
        avgNumOfTrys = (double) sumTrys / gamesPlayed;

    }

    public void maxNumOfTrys() {

        if (maxNumOfTrys < numOfTrysPerRound) {
            maxNumOfTrys = numOfTrysPerRound;

        }
        System.out.println("MOST NUMBER OF GUESSES : " + maxNumOfTrys);


    }

    public void minNumOfTrys() {

        if (minNumOfTrys > numOfTrysPerRound) {
            minNumOfTrys = numOfTrysPerRound;
        }
        System.out.println("LEAST NUMBER OF GUESSES : " + minNumOfTrys);
    }


}
