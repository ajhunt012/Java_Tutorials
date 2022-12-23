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

            // Prompt the user for their next move
            System.out.print("Enter row and column for your next move (e.g. 0 1): ");
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
            if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return true;
            }
        }

        // Check for a win along the columns
        for (int i = 0; i < 3; i++) {
            if (board[0][i] != ' ' && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                return true;
            }
        }

        // Check for a win along the diagonals
    }
}