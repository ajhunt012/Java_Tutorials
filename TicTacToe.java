import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        // Create a new game board
        char[][] board = new char[3][3];

        // Initialize the game board to all empty spaces
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }

        // Create a scanner to read input from the command line
        Scanner scanner = new Scanner(System.in);

        // Prompt the players for their names
        System.out.print("Enter player 1's name: ");
        String player1Name = scanner.nextLine();
        System.out.print("Enter player 2's name: ");
        String player2Name = scanner.nextLine();

        // The current player (X or O)
        char player = 'X';

        // The game loop
        while (true) {
            // Print the game board
            System.out.println("  0 1 2");
            for (int i = 0; i < 3; i++) {
                System.out.print(i + " ");
                for (int j = 0; j < 3; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }

            // Get the name of the current player
            String currentPlayerName;
            if (player == 'X') {
                currentPlayerName = player1Name;
            } else {
                currentPlayerName = player2Name;
            }

            // Prompt the user for their next move
            System.out.print(currentPlayerName + ", enter row and column for your next move (e.g. 0 1): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            // Make sure the move is valid
            if (row < 0 || row > 2 || col < 0 || col > 2) {
                System.out.println("Invalid move, try again.");
                continue;
            }
            if (board[row][col] != ' ') {
                System.out.println("That square is already occupied, try again.");
                continue;
            }

            // Make the move
            board[row][col] = player;

            // Check if the game is over
            if (isGameOver(board)) {
                System.out.println("Game over!");
                break;
            }

            // Switch to the other player
            if (player == 'X') {
                player = 'O';
            } else {
                player = 'X';
            }
        }
    }

    public static boolean isGameOver(char[][] board) {
        // Check for a win along the rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != ' ' && board[i][0] == board) {

            }
        }
    }
}
