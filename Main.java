package GuesserGame;
import java.util.Scanner;

/**
 * The Guesser class is responsible for allowing the Guesser to input a number.
 * This number will later be used by the Umpire to compare with the players' guesses.
 */
class Guesser {
    /**
     * The number guessed by the Guesser.
     */
    int gnum;

    /**
     * Prompts the Guesser to enter a number using the provided Scanner.
     *
     * @param scan The Scanner object used to read user input.
     * @return The number guessed by the Guesser.
     */
    int guessingNum(Scanner scan) {
        System.out.println("Guesser, kindly guess a number between 1 and 10");
        gnum = scan.nextInt();
        return gnum;
    }
}

/**
 * The Player class represents a participant in the guessing game.
 * Each Player is prompted to predict the number guessed by the Guesser.
 */
class Player {
    /**
     * The number predicted by the Player.
     */
    int pnum;

    /**
     * Prompts the Player to enter their predicted number using the provided Scanner.
     *
     * @param scan The Scanner object used to read user input.
     * @return The number predicted by the Player.
     */
    int predictingNum(Scanner scan) {
        System.out.println("Player, kindly predict a number between 1 and 10");
        pnum = scan.nextInt();
        return pnum;
    }
}

/**
 * The Umpire class is responsible for conducting the game.
 * It collects the number from the Guesser and each Player,
 * then compares them to determine the winner.
 */
class Umpire {
    /**
     * The number guessed by the Guesser.
     */
    int numFromGuesser;

    /**
     * The number predicted by Player 1.
     */
    int numFromPlayer1;

    /**
     * The number predicted by Player 2.
     */
    int numFromPlayer2;

    /**
     * The number predicted by Player 3.
     */
    int numFromPlayer3;

    /**
     * A Scanner object used throughout the game to collect input from the console.
     */
    Scanner scan = new Scanner(System.in);

    /**
     * Collects the number guessed by the Guesser using a Guesser object.
     */
    void collectNumFromGuesser() {
        Guesser g = new Guesser();
        numFromGuesser = g.guessingNum(scan);
    }

    /**
     * Collects the numbers predicted by three players using separate Player objects.
     */
    void collectNumFromPlayers() {
        Player p1 = new Player();
        numFromPlayer1 = p1.predictingNum(scan);

        Player p2 = new Player();
        numFromPlayer2 = p2.predictingNum(scan);

        Player p3 = new Player();
        numFromPlayer3 = p3.predictingNum(scan);
    }

    /**
     * Compares the number guessed by the Guesser to each Player's prediction.
     * Declares the winner based on who guessed correctly.
     */
    void compare() {
        System.out.println("Guesser has guessed: " + numFromGuesser);
        System.out.println("Player 1 has predicted: " + numFromPlayer1);
        System.out.println("Player 2 has predicted: " + numFromPlayer2);
        System.out.println("Player 3 has predicted: " + numFromPlayer3);

        if (numFromGuesser == numFromPlayer1) {
            System.out.println("Player 1 has won the game!");
        } else if (numFromGuesser == numFromPlayer2) {
            System.out.println("Player 2 has won the game!");
        } else if (numFromGuesser == numFromPlayer3) {
            System.out.println("Player 3 has won the game!");
        } else {
            System.out.println("No one has won the game.");
        }
    }
}

/**
 * The Main class contains the main method, which is the entry point of the program.
 * It starts the game by creating an Umpire object and triggering the game sequence.
 */
public class Main {
    /**
     * The main method starts the program and runs the guessing game.
     *
     * @param args Command-line arguments (not used here).
     */
    public static void main(String[] args) {
        Umpire u = new Umpire();            // Create an umpire
        u.collectNumFromGuesser();         // Get number from Guesser
        u.collectNumFromPlayers();         // Get numbers from Players
        u.compare();                       // Compare and decide winner
        u.scan.close();                    // Close scanner resource
    }
}
