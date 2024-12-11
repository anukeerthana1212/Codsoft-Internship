import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain;
        int totalRounds = 0;
        int totalWins = 0;

        do {
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 10;
            boolean isGuessed = false;

            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("I have generated a random number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts to guess it.");

            while (attempts < maxAttempts && !isGuessed) {
                System.out.print("Enter your guess: ");
                int userGuess = sc.nextInt();
                attempts++;

                if (userGuess < 1 || userGuess > 100) {
                    System.out.println("Please guess a number between 1 and 100.");
                } else if (userGuess < numberToGuess) {
                    System.out.println("Your guess is too low.");
                } else if (userGuess > numberToGuess) {
                    System.out.println("Your guess is too high.");
                } else {
                    System.out.println("Congratulations! You guessed the number!");
                    isGuessed = true;
                }
            }

            if (!isGuessed) {
                System.out.println("All your attempts are done. The number was: " + numberToGuess);
            } else {
                totalWins++;
            }

            totalRounds++;
            System.out.println("You took " + attempts + " attempts.");
            System.out.println("Score: " + totalWins + "/" + totalRounds);

            System.out.print("Do you want to play again? (yes/no): ");
            String response = sc.next();
            playAgain = response.equalsIgnoreCase("yes");

        } while (playAgain);

        System.out.println("Thank you for playing! Your final score: " + totalWins + " of " + totalRounds);
        sc.close();
    }
}