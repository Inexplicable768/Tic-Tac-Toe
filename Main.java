import java.util.Scanner;
import java.util.Arrays;

public class Main {
    static char[][] board = {
        {' ', ' ', ' '},
        {' ', ' ', ' '},
        {' ', ' ', ' '}
    };
    static char currentPlayer = 'X';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean gameEnded = false;

        while (!gameEnded) {
            System.out.print("\033[H\033[2J");  
            printBoard();
            System.out.println("Player " + currentPlayer + "Turn: enter  move row and then column as a number: ");

            int row = scanner.nextInt() - 1;
            int col = scanner.nextInt() - 1;
            

            if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {
                board[row][col] = currentPlayer;

                if (checkWin()) {
                    printBoard();
                    System.out.println("Player " + currentPlayer + " wins!");
                    gameEnded = true;
                } else if (isBoardFull()) {
                    printBoard();
                    System.out.println("It's a draw!");
                    gameEnded = true;
                } else {
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                    
                }
            } else {
                System.out.println("Spot Taken");
            }
        }

        scanner.close();
    }

    public static void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("| " + board[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    public static boolean isBoardFull(String[][] board) {
        return Arrays.asList(board).contains("");
    }

    public static boolean checkWin() {
        for (int i = 0; i < 3; i++)
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer)
                return true;

        for (int i = 0; i < 3; i++)
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer)
                return true;

        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer)
            return true;

        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer)
            return true;

        return false;
    }
}
