import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Hangman {

    protected static Scanner scanner = new Scanner(System.in);

    private static final Random randomizer = new Random();

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public Random getRandomizer() {
        return randomizer;
    }

    private static boolean getStateWord(String word, List<Character> playerGuesses) {
        int count = 0;
        System.out.print("Word: ");
        for (int i = 0; i < word.length(); i++) {
            if (playerGuesses.contains(word.charAt(i))) {
                System.out.println(word.charAt(i));
                count++;
            }
            System.out.print("-");
        }
        System.out.println("");
        return (count == word.length());
    }

    private static boolean getPlayerGuess(Scanner scanner, String word, List<Character> playerGuesses){
        System.out.print("Enter a letter: ");
        String letterGuess = scanner.nextLine();
        playerGuesses.add(letterGuess.charAt(0));
        return word.contains(letterGuess);
    }

    private static void wrongAnswers(int wrongCount){
        System.out.println("-------");
        System.out.println("|      |");
        if (wrongCount >= 1){
            System.out.println(" O");
        }
        if (wrongCount >= 2){
            System.out.println("\\ ");
            if (wrongCount >= 3){
                System.out.println("/");
            } else {
                System.out.println("");
            }
        }
        if (wrongCount >= 4){
            System.out.println(" |");
        }
        if (wrongCount >= 5){
            System.out.println("/ ");
            if (wrongCount >= 6){
                System.out.println("\\");
            } else {
                System.out.println("");
            }
        }


    }

    public static void hangman() throws FileNotFoundException {
        System.out.print("Choose the difficulty you want to play at: ");
        String difficulty = scanner.nextLine();
        Scanner easy = new Scanner(new File("C:\\Users\\andre\\Desktop\\studying\\chatbot\\src\\wordlists\\Easy.txt"));
        Scanner hard = new Scanner(new File("C:\\Users\\andre\\Desktop\\studying\\chatbot\\src\\wordlists\\Hard.txt"));
        ArrayList<String> words = new ArrayList<>();
        switch (difficulty){
            case "easy":
                while (easy.hasNext()){
                    words.add(easy.next());
                }
                break;
            case "hard":
                while (hard.hasNext()){
                    words.add(easy.next());
                }
                break;
        }
        String word = words.get(randomizer.nextInt(words.size()));
        List<Character> playerGuesses = new ArrayList<>();
        int wrongCount = 0;
        while (true) {
            wrongAnswers(wrongCount);
            if (!getStateWord(word, playerGuesses)){
                wrongCount++;
            }
            getPlayerGuess(scanner, word, playerGuesses);
            if (getStateWord(word, playerGuesses)){
                System.out.println("You win!");
                break;
            }
            if (wrongCount >= 6){
                System.out.println("You lose!");
                System.out.println(word);
                break;
            }
        }
    }
}
