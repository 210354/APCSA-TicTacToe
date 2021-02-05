import java.util.*;
import jdk.javadoc.internal.tool.resources.javadoc;
import java.lang.*; 


class MainTicTacToe {

    static Scanner input = new Scanner(System.in);
    static int row; //Need these to set position of a player's mark 
    static int column;
    
    static GameBoard game = new GameBoard();
    public static void main(String[] args) {

        dashedLines(); //Makes it neater to read 

        System.out.println("\nWelcome to Tic Tac Toe!"); 
        dashedLines(); 

        game.setBoard(); //set board first 
        dashedLines();

        System.out.println("Would you like to play the (C)omputer version or 2 (P)layer version? "); //Two versions of the game
        String version = input.nextLine(); 

        if (version.equals("P")) { //To let two users play the game

            runGameTwoPlayers();

            while (game.checkFinalWin() == false && game.boardFull() == false) { //Keep playing moves until a tie or a win 
                
                GameBoard.playerChange(); //Change player after every move 
                runGameTwoPlayers(); 
        }
    } 

//Computer vs player version of the game
    else if (version.equals("C")){

        runGameComputer(); 

            while (game.checkFinalWin() == false && game.boardFull() == false) {
                
            GameBoard.playerChange();
            runGameComputer();
            }


    }

//If the board is full with no wins, it's a tie
    if (game.boardFull() == true ) {
        System.out.println("It's a tie!");

    }

//If either player wins, then this will show (use the getCurrentPlayer() method for this)
    else {
        System.out.println("\nPlayer " + Character.toUpperCase(game.getCurrentPlayer()) + " wins!\n"); 
    }


} 


//Asks the user for which row and column they would like to make a mark in 
    public static void runGameTwoPlayers() {
        System.out.println("\nPlayer " + GameBoard.getCurrentPlayer() + ", please enter the column you'd like (from 1-3): ");
        column = input.nextInt() - 1; 

        System.out.println("Now please enter the row you'd like (from 1-3): "); 
        row = input.nextInt() - 1;

        game.setPosition(row, column); //Marks position on the board

        GameBoard.printBoard(); //Shows the player what the board looks like 
        dashedLines();

    }

//Computer vs player version of the game
    public static void runGameComputer() {

            Random random = new Random();
 
//When it's the user's turn 
            if (GameBoard.getCurrentPlayer() == 'x') {

                System.out.println("\nPlayer x, please enter the column you'd like (from 1-3): ");
                column = input.nextInt() - 1; 
        
                System.out.println("Now please enter the row you'd like (from 1-3): "); 
                row = input.nextInt() - 1;
            }


//when it's the computer's turn 
        else {

//First priority is to get the entry in the middle of the board 
            if (GameBoard.getPosition(1,1) == true) {
                row = 1;
                column = 1; 
            }

//If that's taken, it randomly generates ints to place a mark on the board 
            else { 

            int randCol = random.nextInt(2);
            int randRow = random.nextInt(2); 

//If the entry isn't taken, it makes a mark
            if (GameBoard.getPosition(randRow, randCol) == true) {

                column = randCol; 
                row = randRow; 
            }


            else if (GameBoard.getPosition(randRow,randCol) == false) {
                
//If the entry has been marked, it runs a for loop to find an empty entry 
/*Couldn't keep using a random number generator for this because if there's a limited number of 
slots available, random number generator would keep going for a long time trying to look for the available slot */
                for (int i =0; i < 3; i++) {
                    for (int j =0; j < 3; j++) {

                        if (GameBoard.getPosition(i,j) == true) {
                            column = i;
                            row = j; 
                        }
                        else {
                            i++;
                            j++; 
                        }
                    }
                }
            }
            }

            System.out.println("The computer has played a move!");

        }

        game.setPosition(row, column); //Marks the entry of the board 

        GameBoard.printBoard(); 
        dashedLines();

    }



    //Method to print out dashed lines to make it easier for the user to read 
public static void dashedLines() {

    System.out.println(); 
    for (int i = 1; i <=150; i++) {
        System.out.print("-");
    }
    System.out.println();

}


}

