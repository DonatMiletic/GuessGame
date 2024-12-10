import java.util.Scanner;

public class Game_Mode {

    int numStart = 1;
    //final int numEasy=50;
    // final int numMedium=100;
    //final int numHard=200;
    int numEnd;


    public void settingsMode(int numStart, int numEnd) {
        this.numStart = numStart;
        this.numEnd = numEnd;

    }


    public void gameMode(int mode) {

        switch (mode) {
            case 1:
                numEnd = 50;
                System.out.println("Easy mode selected");
                settingsMode(1, numEnd);
                break;
            case 2:
                numEnd = 100;
                System.out.println("Medium mode selected");
                settingsMode(1, 100);
                break;
            case 3:
                numEnd = 200;
                System.out.println("Hard mode selected");
                settingsMode(1, numEnd);
                break;
            default:
                numEnd = 100;
                break;

        }


    }


}


