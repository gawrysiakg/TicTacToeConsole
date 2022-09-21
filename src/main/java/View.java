
import java.util.InputMismatchException;
import java.util.Scanner;

public class View {
    Scanner scanner=new Scanner(System.in);
    boolean withComputer=false;
    public static boolean difficulty;



    public void createBoard(char[][] board, int columns, int rows){

        System.out.print("  ");
        for (int l = 0; l<columns; l++){
            System.out.print("   "+l);
        }
        System.out.println();
        for (int j = 0; j < columns; j++) {
            System.out.print(j+"  | ");

            for (int i = 0; i < rows; i++) {
                board[i][j]=' ';
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void showBoard(char[][] board){

        System.out.print("  ");
        for (int l = 0; l< board.length; l++){
            System.out.print("   "+l);
        }
        System.out.println();
        for (int j = 0; j < board.length; j++) {
            System.out.print(j+"  | ");

            for (int i = 0; i < board.length; i++) {
                System.out.print(board[j][i] + " | ");
            }
            System.out.println();
        }
    }



    public void checkFor2Player(){
        int choosePlayer=0;
        boolean inputIsInt = false;

            while (!inputIsInt) {
                System.out.println("Player1 vs Computer, press 1");
                System.out.println("Player1 vs Player2, press 2");

                try {
                    choosePlayer= Player.getInt();

                    inputIsInt=true;
                    if ( choosePlayer== 1) {
                        withComputer = true;
                        System.out.println("Your sign: X, Computer: O");
                        setDifficulty();
                    } else if (choosePlayer == 2) {
                        withComputer = false;
                        System.out.println("Player1 sign: X, Player2 sign: O");
                    } else {
                        System.out.println("Try again");
                        inputIsInt=false;
                    }

                } catch (InputMismatchException e) {
                    System.out.println("Only numbers. Player1 vs Computer press 1, Player1 vs Player2 press 2");
                }
            }
}

    public void setGameVersion(GameLogic gameLogic){
        System.out.println("Board 3x3 press 1, Board 10x10 press 2");
        boolean version=true;
        int bSize;
        while (version) {

            try {
                bSize= Player.getInt();

                if (bSize == 1) {
                    gameLogic.rows = 3;
                    gameLogic.columns = 3;
                    version=false;
                } else if (bSize == 2){
                    gameLogic.rows = 10;
                    gameLogic.columns = 10;
                    version=false;
                } else {
                    System.out.println("Press 1 for board 3x3, press 2 for board 10x10");
                }
            } catch (InputMismatchException e){
                System.out.println("Only numbers. Press 1 for board 3x3, press 2 for board 10x10");
            }
        }
    }

    private void setDifficulty(){
        int chosenDifficulty=0;

        while (true) {
           try {
                System.out.println("Normal version - 1, Difficult - 2");
                chosenDifficulty=Player.getInt();

               if (chosenDifficulty == 2) {
                   difficulty = true;
                   break;
               } else if (chosenDifficulty == 1){
                   difficulty = false;
                   break;
               } else {
                   System.out.println("Invalid number, try again.");
               }
           } catch (InputMismatchException e) {
               System.out.println("Only numbers. Normal version - 1, Difficult - 2");
           }
        }
    }



    public void endOfGame(GameLogic gameLogic){
        System.out.println("The game is over. New game - press 1, End - press 2");
        boolean end=true;
        int endOrNot = 0;

        while (end){
            try{
                endOrNot=Player.getInt();

                if(endOrNot==1){
                    gameLogic.end=false;
                    gameLogic.move=0;
                    gameLogic.gameDuration();
                } else if (endOrNot==2) {
                    System.out.println("Thank you for playing.");
                    System.exit(0);
                } else {
                    System.out.println("Invalid sign. New game - press 1, End - press 2");
                }
            } catch (InputMismatchException e){
                System.out.println("Only numbers. New game - press 1, End - press 2");
            }
        }
    }



    public static void instructions(){
        System.out.println("\u001B[34m"+"Welcome to TIC TAC TOE Game");
        System.out.println("It is a 2 player game.");
        System.out.println("The first player is known as X and the second is O.");
        System.out.println("In 3x3 version: Players play Xs and Os on the game board. 3 signs in line - win.");
        System.out.println("In 10x10 version: 5 signs in line give a victory.\n"+"\u001B[0m");
    }
}