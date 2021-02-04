import java.util.*;
import java.lang.*; 



class MainTicTacToe {

    static Scanner input = new Scanner(System.in);
    static int row;
    static int column;
    
    static GameBoard game = new GameBoard();
    public static void main(String[] args) {


        dashedLines(); 

        System.out.println("\nWelcome to Tic Tac Toe!"); 
        dashedLines(); 
        

        game.setBoard(); 

        dashedLines();

        runGame();


        while (game.checkFinalWin() == false && game.boardFull() == false) {
            
            GameBoard.playerChange();
            runGame(); 

    } 

    if (game.boardFull() == true ) {
        System.out.println("It's a tie!");

    }

    else {
        System.out.println("\nPlayer " + Character.toUpperCase(game.getCurrentPlayer()) + " wins!\n"); 
    }


} 

    public static void runGame() {
        System.out.println("\nPlayer " + GameBoard.getCurrentPlayer() + ", please enter the column you'd like (from 1-3): ");
        column = input.nextInt() - 1; 

        System.out.println("Now please enter the row you'd like (from 1-3): "); 
        row = input.nextInt() - 1;

        game.setPosition(row, column);

        GameBoard.printBoard(); 
        dashedLines();

    }


    //Method to print out dashed lines to separate 
public static void dashedLines() {

    System.out.println(); 
    for (int i = 1; i <=150; i++) {
        System.out.print("-");
    }
    System.out.println();

}


}

