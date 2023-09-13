import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int lowerBound = 1;
        int upperBound = 100;
        int numberToGuess = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
        
        int maxAttempts = 10;
        int attempts = 0;
        int score = 0;
        
        boolean isGameOn = true;
        
        System.out.println("Welcome to Number Guessing Game!");
        System.out.println("I've selected a random number between " + lowerBound + " and " + upperBound + ".");
        System.out.println("Try to guess it in " + maxAttempts + " or fewer attempts.");
        
        while (isGameOn) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            
            attempts++;
            
            if (userGuess == numberToGuess) {
                System.out.println("Congratulations! You've guessed the number (" + numberToGuess + ") correctly in " + attempts + " attempts.");
                score += (maxAttempts - attempts + 1); // Assigning score based on the number of attempts.
                System.out.println("Your score: " + score);
                
                System.out.print("Do you want to play again? (yes/no): ");
                String playAgain = scanner.next().toLowerCase();
                if (!playAgain.equals("yes")) {
                    isGameOn = false;
                } else {
                    numberToGuess = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
                    attempts = 0;
                    System.out.println("\nNew game started!");
                }
            } else if (userGuess < numberToGuess) {
                System.out.println("Try a higher number.");
            } else {
                System.out.println("Try a lower number.");
            }
            
            if (attempts >= maxAttempts) {
                System.out.println("Sorry, you've reached the maximum number of attempts. The number was " + numberToGuess + ".");
                System.out.println("Your final score: " + score);
                
                System.out.print("Do you want to play again? (yes/no): ");
                String playAgain = scanner.next().toLowerCase();
                if (!playAgain.equals("yes")) {
                    isGameOn = false;
                } else {
                    numberToGuess = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
                    attempts = 0;
                    System.out.println("\nNew game started!");
                }
            }
        }
        
        System.out.println("Thanks for playing Guess the Number!");
        scanner.close();
    }
}
