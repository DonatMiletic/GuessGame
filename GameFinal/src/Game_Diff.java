import java.util.Random;
import java.util.Scanner;
import java.util.function.Supplier;

public class Game_Diff {


    private Game_Mode game_mode;



    //constructor
    public Game_Diff(Game_Mode game_mode) {
        this.game_mode = game_mode;
    }


    // Player input
    public void numberPlayer(int numPlayer) {
        //Checking correct user/player input
        Scanner sc = new Scanner(System.in);

        while (true) {

            if (numPlayer < 1 || numPlayer > game_mode.numEnd) {
                System.out.println("Number must be between 1 and " + game_mode.numEnd + "!");
                System.out.println("Please enter number between 1 and " + game_mode.numEnd + "!");
                numPlayer = sc.nextInt();
            } else {
                break;
            }
        }}

        //CPU input
        public int cpuNumber() {
            Supplier<Integer> randomNumberGenerator = () -> new Random().nextInt(game_mode.numEnd);
            return randomNumberGenerator.get();

        }













}





