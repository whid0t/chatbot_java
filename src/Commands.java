import java.io.FileNotFoundException;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Commands {

    private static final String[] commands = {"greet", "help", "math", "game", "credits"};

    static Math math = new Math();

    static Games games = new Games();

    public String[] getCommands() {
        return commands;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected static String name;

    public static void greet(){
        System.out.println("Hello, " + name);
    }

    public static void help(){
        System.out.println("You can choose one of the commands: " + Arrays.toString(commands));
    }

    public static void credits(){
        System.out.println("Created by whid0t 2022");
    }

    public static void math(){
        math.run();
    }

    public static void game() throws FileNotFoundException, InterruptedException {
        games.play();
    }

    public static void exit() throws Exception {
        throw new Exception();
    }

}
