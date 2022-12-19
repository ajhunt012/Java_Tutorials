import java.util.Scanner;
import java.util.Random;

public class Test_game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Initialize player variables
        int health = 100;
        int gold = 10;

        while (true) {
            // Display options
            System.out.println("What would you like to do?");
            System.out.println("1. Go forward");
            System.out.println("2. Go right");
            System.out.println("3. Go back");
            System.out.println("4. Go left");
            System.out.println("5. Fight monster");
            System.out.println("6. Quit game");

            // Read user input
            int choice = scanner.nextInt();

            // Take action based on choice
            switch (choice) {
                case 1 -> System.out.println("You go north.");
                case 2 -> System.out.println("You go south.");
                case 3 -> System.out.println("You go east.");
                case 4 -> System.out.println("You go west.");
                case 5 -> health = fightMonster(health, random);
                case 6 -> {
                    System.out.println("Thanks for playing!");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static int fightMonster(int health, Random random) {
        // Calculate chance of winning, losing, or running away
        int winChance = random.nextInt(100);
        if (winChance < 50) {
            // Player wins
            health += 25;
            System.out.println("You defeated the monster! Your health is now " + health + ".");
        }
        return winChance;
    }
}