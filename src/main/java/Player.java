import java.util.InputMismatchException;
import java.util.Scanner;

public class Player {

    Scanner scanner = new Scanner(System.in);
    char selectedPlace;
    int row=0 ;
    int column=0;

    public void getPlayerInput(char[][]board, char activePlayer, int row, int column) throws BusyFieldException {
        boolean correctMove=false;

        while (!correctMove) {

            if (board[row][column] == 'X'||board[row][column] == 'O'){
                throw new BusyFieldException();
            } else {
               // if (board[row][column] == ' ') {
                board[row][column] = activePlayer;
                selectedPlace = board[row][column];
                correctMove=true;
            }
        }
    }

    public static int getInt() {
        return new Scanner(System.in).nextInt();
    }

    public void playerValidatedInput(char activePlayer, char[][] board) {

        boolean validated=false;
        System.out.println("Player "+activePlayer+" Enter row number:");
        do {
            try {
                row = getInt();

                if ((row > -1) && (row < board.length)) {
                    validated = true;
                } else {
                    System.out.println("Only numbers 0 - 9, enter row number:");
                }
            } catch (InputMismatchException e){
                System.out.println("Error. Only numbers. Player "+activePlayer+" Enter row number:");
            }
        } while (!validated);



        validated=false;
        System.out.println("Player "+activePlayer+" Enter column number:");
        do {
            try {
                column = getInt();
                if ((column > -1) && (column < board.length)) {
                    validated = true;
                } else {
                    System.out.println("Only numbers 0 - 9, enter column number:");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error. Only numbers. Player "+activePlayer+" Enter column number:");
            }

        } while (!validated);
    }




}
