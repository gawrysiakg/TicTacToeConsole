import java.util.Random;

public class Computer {


    public void getComputerInput(char[][] board, char activePlayer) throws BusyFieldException {

        if (board.length == 3) {

            if (View.difficulty){
                if(board[0][0]=='X'&&board[2][2]=='X'&&board[1][1]==' ') {
                    board[1][1]='O';
                } else if (board[0][2]=='X'&&board[2][0]=='X'&&board[1][1]==' ') {
                    board[1][1]='O';
                } else if (board[0][0]=='X'&&board[0][2]=='X'&&board[0][1]==' ') {
                    board[0][1]='0';
                } else if (board[1][0]=='X'&&board[1][2]=='X'&&board[1][1]==' ') {
                    board[1][1]='0';
                } else if (board[2][0]=='X'&&board[2][2]=='X'&&board[2][1]==' ') {
                    board[2][1]='0';
                } else if (board[0][2]=='X'&&board[1][1]=='X'&&board[2][0]==' ') {
                    board[2][0]='O';
                } else if (board[2][2]=='X'&&board[1][1]=='X'&&board[0][0]==' ') {
                    board[0][0]='O';
                } else if (board[0][2]=='X'&&board[1][1]=='X'&&board[2][2]==' ') {
                    board[2][2]='O';
                } else {

                    randomComputerMove(board, activePlayer);
                }
            } else {

                randomComputerMove(board, activePlayer);
            }



        } else {
            // board 10x10

            //if difficult version
            if (View.difficulty){

                int found=0;

                        //find block in columns
                        for (int column = 0; column < board.length; column++) {
                            for (int row = 0; row < board.length - 4; row++) {

                                if ((board[row][column]) == 'X' &&
                                        (board[row + 1][column]) == 'X' &&
                                        (board[row + 2][column]) == 'X' &&
                                        (board[row + 3][column]) == 'X' &&
                                        (board[row + 4][column]) == ' ') {
                                    board[row + 4][column] = 'O';
                                    found=1;
                                    break;
                                }
                            } if (found==1){
                                    break;
                            }
                        }
                        //if no block in columns, find block in rows
                        if (found==0) {
                            for (int row = 0; row < board.length; row++) {
                                for (int column = 0; column < board.length - 4; column++) {

                                    if ((board[row][column]) == 'X' &&
                                            (board[row][column + 1]) == 'X' &&
                                            (board[row][column + 2]) == 'X' &&
                                            (board[row][column + 3]) == 'X' &&
                                            (board[row][column + 4]) == ' ') {
                                        board[row][column + 4] = 'O';
                                        found = 1;
                                        break;
                                    }
                                }
                                if (found == 1) {
                                    break;
                                }
                            }
                        }
                // if no blocks in columns and rows, do random move
                if (found==0) {
                randomComputerMove(board, activePlayer);
                }



            // if normal version
            } else {
                randomComputerMove(board, activePlayer);
            }
        }
    }


    private void randomComputerMove(char[][] board, char activePlayer) {
         boolean correctMove;
         Random random = new Random();
         do {
            int row = random.nextInt(board.length);
            int column = random.nextInt(board.length);
           if (board[row][column] == ' ') {
                board[row][column] = activePlayer;
                correctMove = false;
            } else {
                correctMove = true;
            }
        }while (correctMove);
    }
}
