import java.io.FileNotFoundException;
import java.util.*;

public class Games {


    protected Scanner scanner = new Scanner(System.in);

    protected final String[] games = {"rps", "hangman"};

    public String[] getGames() {
        return games;
    }

    public void displayGames(){
        System.out.println(Arrays.toString(games));
    }

    public void play() throws InterruptedException, FileNotFoundException {
        System.out.println("Pick your game:");
        displayGames();
        System.out.print("Game: ");
        String game = scanner.nextLine();
        if (!(game.equals(games[0]) || game.equals(games[1]))){
            System.out.println("Invalid selection");
            displayGames();
        }
        switch (game) {
            case "rps" -> rps.rps();
            case "hangman" -> Hangman.hangman();
        }
    }
}
