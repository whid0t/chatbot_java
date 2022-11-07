import java.io.FileNotFoundException;
import java.util.Scanner;

public class Chatbot {

    protected static Scanner scanner = new Scanner(System.in);

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public static void main(String[] arr) throws Exception {
        System.out.println("Hello, I'm Richard the chatbot. Let's begin with your name... What's your name?");
        System.out.print("Enter your name: ");
        Commands.name = (scanner.nextLine());
        Commands.help();
        while(true){
            System.out.print("Command: ");
            String command = scanner.nextLine();
            switch (command) {
                case "greet" -> Commands.greet();
                case "help" -> Commands.help();
                case "credits" -> Commands.credits();
                case "math" -> Commands.math();
                case "game" -> Commands.game();
                case "exit" -> Commands.exit();
            }
        }
    }
}
