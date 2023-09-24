import java.util.Random;
import java.util.Scanner;

public class Number_game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int minRange = 1;
        int maxRange = 100;
        int secretNumber;
        int userGuess;
        int attempts;
        int rounds = 0;
        int totalAttempts = 0;
        
        System.out.println("Welcome to the Guess the Number game!");
        
        do {
            // Generate a random number within the specified range
            secretNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            attempts = 0;
            rounds++;

            System.out.println("I'm thinking of a number between " + minRange + " and " + maxRange + ".");
            
            while (true) {
                try {
                    System.out.print("Take a guess: ");
                    userGuess = scanner.nextInt();
                    attempts++;

                    if (userGuess < secretNumber) {
                        System.out.println("Too low! Try again.");
                    } else if (userGuess > secretNumber) {
                        System.out.println("Too high! Try again.");
                    } else {
                        System.out.println("Congratulations! You guessed the number " + secretNumber + " in " + attempts + " attempts.");
                        break;
                    }
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.next(); // Clear the invalid input from the scanner
                }
            }

            totalAttempts = totalAttempts + attempts;

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();
            if (!playAgain.equals("yes")) {
                break;
            }
        } while (true);

        System.out.println("Thanks for playing! You played " + rounds + " rounds and took an average of " + (double) totalAttempts / rounds + " attempts per round.");
        
        scanner.close();
    }
}
