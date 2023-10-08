 

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int lowerLimit = 1;
        int upperLimit = 100;
        int secretNumber;
        int maxAttempts = 10; // You can change this number to set the limit of attempts.
        int attempts;
        int score = 0;

        System.out.println("Welcome to the Guess the Number Game!");

        do {
            secretNumber = random.nextInt(upperLimit - lowerLimit + 1) + lowerLimit;
            attempts = 0;

            System.out.println("I'm thinking of a number between " + lowerLimit + " and " + upperLimit + ".");

            while (attempts < maxAttempts) {
                System.out.print("Attempt " + (attempts + 1) + "/" + maxAttempts + ": Enter your guess: ");
                int userGuess = scanner.nextInt();

                if (userGuess < lowerLimit || userGuess > upperLimit) {
                    System.out.println("Please enter a number between " + lowerLimit + " and " + upperLimit + ".");
                } else {
                    if (userGuess == secretNumber) {
                        System.out.println("Congratulations! You guessed the correct number, which was " + secretNumber + "!");
                        score++;
                        break;
                    } else if (userGuess < secretNumber) {
                        System.out.println("Your guess is too low. Try again.");
                    } else {
                        System.out.println("Your guess is too high. Try again.");
                    }
                    attempts++;
                }
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next();
            if (!playAgain.toLowerCase().equals("yes")) {
                System.out.println("Thanks for playing! Your score is: " + score);
                break;
            }
        } while (true);

        scanner.close();
    }
}
