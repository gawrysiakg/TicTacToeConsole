public class Winner {
char winner;


    public boolean checkWinnerInColumns(char[][] board, char activePlayer){
        if (board.length == 3) {

            for (int column = 0; column < board.length; column++) {
                boolean win=true;
                for (int row=0; row< board.length; row++) {

                    if (board[row][column] != activePlayer) {
                        win = false;
                        break;
                    }
                }
                if (win){
                    winner = activePlayer;
                    System.out.println("\u001B[34m"+winner + " win in column!"+"\u001B[0m");
                    return true;
                }
            } return false;
        } else {
            for (int column=0; column< board.length; column++) {
                boolean win=false;
                for (int row=0; row< board.length-4; row++) {
                    if((board[row][column])==activePlayer&&
                            (board[row+1][column])==activePlayer&&
                            (board[row+2][column])==activePlayer&&
                            (board[row+3][column])==activePlayer&&
                            (board[row+4][column])==activePlayer) {
                        win=true;
                        break;
                    }

                }
                if (win) {
                    winner = activePlayer;
                    System.out.println("\u001B[34m"+winner + " win in column!"+"\u001B[0m");
                    return true;
                }
            }
            return false;
        }

    }

    public boolean checkWinnerInRows(char[][] board, char activePlayer){
        if (board.length == 3) {

            for (int row = 0; row < board.length; row++) {
                boolean win=true;
                for (int column=0; column< board.length; column++) {

                    if (board[row][column] != activePlayer) {
                        win = false;
                        break;
                    }
                }
                if (win){
                    winner = activePlayer;
                    System.out.println("\u001B[34m"+winner + " win in rows!"+"\u001B[0m");
                    return true;
                }
            } return false;
        } else {
            boolean win=false;
            for (int row=0; row< board.length; row++) {
                for (int column=0; column< board.length-4; column++) {
                    if((board[row][column])==activePlayer&&
                            (board[row][column+1])==activePlayer&&
                            (board[row][column+2])==activePlayer&&
                            (board[row][column+3])==activePlayer&&
                            (board[row][column+4])==activePlayer) {
                        win=true;
                        break;
                    }
                }
                if (win) {
                    winner = activePlayer;
                    System.out.println("\u001B[34m"+winner + " win in rows!"+"\u001B[0m");
                    return true;
                }
            } return false;
        }
    }


    public boolean checkWinnerDiagonally(char[][] board, char activePlayer) {
        if (board.length == 3) {
            boolean win=false;
            if(board[0][0]==activePlayer&&board[1][1]==activePlayer&&board[2][2]==activePlayer
                    ||board[0][2]==activePlayer&&board[1][1]==activePlayer&&board[2][0]==activePlayer) {
                win = true;

            } if (win) {
                winner = activePlayer;
                System.out.println("\u001B[34m" + winner + " win diagonally!" + "\u001B[0m");
                return true;
            }return false;



        } else if (board.length == 10) {

            boolean win=false;
            for (int i=0; i< board.length-4; i++){
                for (int j=0; j< board.length-4; j++) {

                    if (board[i][j] == activePlayer &&
                            board[i + 1][j + 1] == activePlayer &&
                            board[i + 2][j + 2] == activePlayer &&
                            board[i + 3][j + 3] == activePlayer &&
                            board[i + 4][j + 4] == activePlayer) {
                        win = true;
                        break;
                    }

                }  if (win) {
                    winner = activePlayer;
                    System.out.println("\u001B[34m" + winner + " win diagonally!" + "\u001B[0m");
                    return true;
                }
            }


            for (int i=0; i< board.length-4; i++){
                for (int j = board.length-1; j> 3; j--) {

                    if (board[i][j] == activePlayer &&
                            board[i + 1][j - 1] == activePlayer &&
                            board[i + 2][j - 2] == activePlayer &&
                            board[i + 3][j - 3] == activePlayer &&
                            board[i + 4][j - 4] == activePlayer) {
                        win = true;
                        break;
                    }

                }  if (win) {
                    winner = activePlayer;
                    System.out.println("\u001B[34m" + winner + " win diagonally!" + "\u001B[0m");
                    return true;
                }
            } return false;
        } else {
            return false;
        }
    }




   public boolean checkDraw(char[][] board, GameLogic gameLogic){
            if (gameLogic.move==board.length*board.length){
                System.out.println("\u001B[34m"+"It's a Draw!"+"\u001B[0m");
                return true;
        } return false;
   }



}
