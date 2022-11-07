import java.util.*;
import java.util.concurrent.TimeUnit;

public class rps {
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

    public static void rps() throws InterruptedException {
        String[] rps1 = {"rock", "paper", "scissors"};
        List<String> choices = Arrays.asList(rps1);
        Map<String, Double> power = Map.of("rock", 8.0, "paper", 4.0, "scissors",1.0);
        System.out.println("You need to choose one of the 3 options - rock, paper, scissors");
        System.out.print("Choice: ");
        String choice = scanner.nextLine();
        if (!power.containsKey(choice)){
            System.out.println("Your choice is invalid. Please select from the options available!");
            rps();
        }
        TimeUnit.SECONDS.sleep(1);
        System.out.println("You chose " + choice);
        String choiceCPU = choices.get(randomizer.nextInt(choices.size()));
        Double[] win = {4.0, 2.0, 0.125};
        Double result = power.get(choice) / power.get(choiceCPU);
        TimeUnit.SECONDS.sleep(1);
        System.out.println("3");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("2");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("1");
        TimeUnit.SECONDS.sleep(1);
        if (result == 1){
            System.out.println("Computer chose " + choiceCPU + ". Draw");
        } else {
            for (Double element : win) {
                if (result.equals(element)) {
                    System.out.println("Computer chose " + choiceCPU + "You win");
                    break;
                }
                System.out.println("Computer chose " + choiceCPU + ". You lose...");
                break;
            }
        }
    }
}
