import java.util.Arrays;
import java.util.Scanner;

public class Math {

    protected Scanner action = new Scanner(System.in);

    protected int[] numbers;

    private final String[] mathCommands = {"sum", "divide", "multiply"};

    public String[] getMathCommands() {
        return mathCommands;
    }


    public int[] getNumbers() {
        return numbers;
    }

    public void setNumbers(int[] numbers) {
        this.numbers = numbers;
    }

    public Scanner getAction() {
        return action;
    }

    public void setAction(Scanner action) {
        this.action = action;
    }

    public void displayCommands(){
        System.out.println(Arrays.toString(mathCommands));
    }

    public void run(){
        numbersNeeded();
        System.out.print("Now tell me what do you want to do with them. Possible choices: ");
        displayCommands();
        System.out.print("Action: ");
        String actionMath = action.nextLine();
        System.out.println("Test");
        switch (actionMath) {
            case "sum" -> sum();
            case "multiply" -> multiply();
            case "divide" -> divide();
            case "division" -> division();
        }
    }


    public void numbersNeeded(){
        System.out.print("Tell me how many numbers do you need: ");
        int count = action.nextInt();
        int[] numbers = new int[count];
        for (int i = 0; i < count; i++){
            System.out.print("Enter the " + (i + 1) + " number: ");
            numbers[i] = action.nextInt();
        }
        setNumbers(numbers);
    }

    public void sum(){
        int result = 0;
        for (int number : numbers){
            result += number;
        }
        System.out.println("The sum of all the numbers is " + result);
    }

    public void multiply(){
        int result = 1;
        for (int number : numbers){
            result *= number;
        }
        System.out.println("The multiply is " + result);
    }

    public void divide(){
        System.out.println("By default the function will divide the first 2 numbers");
        int first = numbers[0];
        int second = numbers[1];
        int result = first / second;
        System.out.println("The result is " + result);
    }

    public void division(){
        int start = numbers[0];
        for (int i = 1; i < numbers.length; i++){
            start -= numbers[i];
        }
        System.out.println("The division is " + start);
    }
}
