public class GameLogic {
    View view = new View();
    Winner winner = new Winner();
    Player player = new Player();
    Computer computer = new Computer();
    int columns;
    int rows;
    public char  [][] board ;
    private char activePlayer;
    private char player1='X';
    private char player2='O';
    private char comp ='O';
    boolean end = false;
    int move;


public void gameDuration()  {

        View.instructions();
        view.checkFor2Player();
        view.setGameVersion(this);
        board= new char[rows][columns];
        view.createBoard(board, rows, columns);
        activePlayer=player1;
        boolean error;
        boolean computerError;

       while (!end){

           do {

               player.playerValidatedInput(activePlayer, board);
               int row=player.row;
               int column=player.column;
               try {
                   player.getPlayerInput(board, activePlayer, row, column);
                   error = false;
               } catch (BusyFieldException b) {
                   System.out.println("Field is occupied, try another one");
                   error = true;
               }
           } while (error);


           view.showBoard(board);
           move++;

            if( winner.checkWinnerInColumns(board, activePlayer)|| winner.checkWinnerInRows(board, activePlayer)|| winner.checkWinnerDiagonally(board, activePlayer)||winner.checkDraw(board, this)){
                end=true;
                view.endOfGame(this);
            }


           if (view.withComputer){
               activePlayer= comp;

               do {
                   try {
                       computer.getComputerInput(board, activePlayer);
                       computerError = false;
                   } catch (BusyFieldException b) {
                       System.out.println("Field is occupied.");
                       computerError = true;
                   }
               } while (computerError);

               view.showBoard(board);
               move++;

               if( winner.checkWinnerInColumns(board, activePlayer)|| winner.checkWinnerInRows(board, activePlayer)|| winner.checkWinnerDiagonally(board, activePlayer)||winner.checkDraw(board, this)){
                   end=true;
                   view.endOfGame(this);
               } else {
                   activePlayer=player1;
               }

           } else {
               if (activePlayer == 'X') {
                   activePlayer = player2;
               } else activePlayer = player1;
           }
       }
}


}
