import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class GameTestSuite {


    @Test
    void testOWinsInRow(){
        // Given
        Winner winner=new Winner();
        char [][] board = new char[10][10];
        char activePlayer='O';
        board[2][0]='O';
        board[2][1]='O';
        board[2][2]='O';
        board[2][3]='O';
        board[2][4]='O';
        // When
        boolean result=winner.checkWinnerInRows(board, activePlayer);
        // Then
        Assertions.assertTrue(result);
}


    @Test
    void testOWinsInColumns(){
        // Given
        Winner winner=new Winner();
        char [][] board = new char[10][10];
        char activePlayer='O';
        board[5][2]='O';
        board[6][2]='O';
        board[7][2]='O';
        board[8][2]='O';
        board[9][2]='O';
        // When
        boolean result=winner.checkWinnerInColumns(board, activePlayer);
        // Then
        Assertions.assertTrue(result);
    }


    @Test
    void testOWinsDiagonally(){
        // Given
        Winner winner=new Winner();
        char [][] board = new char[3][3];
        char activePlayer='O';
        board[0][0]='O';
        board[1][1]='O';
        board[2][2]='O';
        board[0][2]='X';
        board[2][0]=' ';
        // When
        boolean result=winner.checkWinnerDiagonally(board, activePlayer);
        // Then
        Assertions.assertTrue(result);
    }


    @Test
    void testXWinsInRow(){
        // Given
        Winner winner=new Winner();
        char [][] board = new char[10][10];
        char activePlayer='X';
        board[9][0]='X';
        board[9][1]='X';
        board[9][2]='X';
        board[9][3]='X';
        board[9][4]='X';
        // When
        boolean result=winner.checkWinnerInRows(board, activePlayer);
        // Then
        Assertions.assertTrue(result);
    }


    @Test
    void testXWinsInColumns(){
        // Given
        Winner winner=new Winner();
        char [][] board = new char[10][10];
        char activePlayer='X';
        board[5][0]='X';
        board[6][0]='X';
        board[7][0]='X';
        board[8][0]='X';
        board[9][0]='X';
        // When
        boolean result=winner.checkWinnerInColumns(board, activePlayer);
        // Then
        Assertions.assertTrue(result);
    }


    @Test
    void testXWinsDiagonally(){
        // Given
        Winner winner=new Winner();
        char [][] board = new char[10][10];
        char activePlayer='0';
        board[0][4]='0';
        board[1][3]='0';
        board[2][2]='0';
        board[3][1]='0';
        board[4][0]='0';
        // When
        boolean result=winner.checkWinnerDiagonally(board, activePlayer);
        // Then
        Assertions.assertTrue(result);
    }


    @Test
    void testWhenIsADraw(){
        // Given
        Winner winner=new Winner();
        GameLogic gameLogic=new GameLogic();
        gameLogic.move=9;
        char [][] board = new char[3][3];
        board[0][0]='X';
        board[1][0]='0';
        board[2][0]='X';
        board[0][1]='0';
        board[1][1]='X';
        board[2][1]='X';
        board[0][2]='0';
        board[1][2]='X';
        board[2][2]='0';
        // When
        boolean result=winner.checkDraw(board, gameLogic );
        // Then
        Assertions.assertTrue(result);
    }


    @Test
    void testBusyFieldException()  {
        // Given
        Player player = new Player();
        char[][] board = new char[3][3];
        int row = 2;
        int column = 2;
        char activePlayer = 'O';
        board[2][2] = 'X';
        // When
        try {
            player.getPlayerInput(board, activePlayer, row, column);
        } catch (BusyFieldException b){
                System.out.println("\u001B[34m" +"Error. Field is busy."+ "\u001B[0m");
        }
        //then
        Assertions.assertThrows(BusyFieldException.class, () -> player.getPlayerInput(board, activePlayer, row, column));
        }



}
