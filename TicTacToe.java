public class TicTacToe {
    // 2D array to represent the cells of the board
    private char[][] board;

    // Enum to represent the current state of the game
    private enum GameState {
        ONGOING, X_WINS, O_WINS, DRAW
    }
    private GameState gameState;

    // Variables to track the current player and the players' names, symbols, and colors
    private char currentPlayer;
    private String playerXName;
    private char playerXSymbol;
    private String playerXColor;
    private String playerOName;
    private char playerOSymbol;
    private String playerOColor;

    public TicTacToe() {
        // Initialize the board and game state
        board = new char[3][3];
        gameState = GameState.ONGOING;
        currentPlayer = 'X';

        // Initialize all cells to be empty
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    // Method to print the current state of the board
    public void printBoard() {
        System.out.println("  0 1 2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++) {
                // Use the players' colors when printing the board
                if (board[i][j] == playerXSymbol) {
                    System.out.print((char)27 + "[" + playerXColor + "m" + board[i][j] + (char)27 + "[0m" + " ");
                } else if (board[i][j] == playerOSymbol) {
                    System.out.print((char)27 + "[" + playerOColor + "m" + board[i][j] + (char)27 + "[0m" + " ");
                } else {
                    System.out.print(board[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    // Other methods ...

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();

        //
