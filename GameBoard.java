import java.util.*;
import java.lang.*; 

class GameBoard {

    private static char currentPlayer = 'x'; 
    public final static char[][] board = new char[3][3];

 
    public static void setBoard() {

        System.out.println("Here is the empty game board: \n");
        System.out.println("-------------"); 

		for(int i = 0 ; i < board.length;i++)
		{
			for(int j = 0 ; j < board[0].length;j++)
			{
                board[i][j] = '-'; 

                if (j % 3 == 0 ) {
                    System.out.print("| ");
                }
                System.out.print(board[i][j] + " | "); 
            }
            
            System.out.println();
            System.out.println("-------------"); 
        }
    }

    public static void printBoard() {
        System.out.println("-------------"); 

        for (int i =0; i <3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------"); 
        }
    }
    
    
    public static void playerChange() {
        if (currentPlayer == 'x') {
            currentPlayer = 'o';
        }
        else {
            currentPlayer = 'x';
        }
    }

    public static char getCurrentPlayer()
    {
        return currentPlayer;
    }


    public static boolean setPosition(int row, int col) { //sets the board

        if ((row >= 0) && (row < 3)) {
            if ((col >= 0) && (col < 3)) {
                if (board[row][col] == '-') {
                    board[row][col] = currentPlayer;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkWinnerRowColumns(char a, char b, char c) {
        return ((a != '-') && (a == b) && (b == c));
    } 


    public boolean checkWinnerRows() { 

        for (int i = 0; i < 3; i++) {
            if (checkWinnerRowColumns(this.board[i][0], this.board[i][1],this.board[i][2]) == true) {
                return true;
            }
        }
        return false; 
    }

    public boolean checkWinnerColumms(){ 

        for (int i = 0; i < 3; i++) {
            if (checkWinnerRowColumns(this.board[0][i],this.board[1][i],this.board[2][i]) == true) {
                return true;
            }
        }
        return false; 
    }

    public boolean checkWinnerDiagonals(){ 
        return ((checkWinnerRowColumns(this.board[0][0], this.board[1][1], this.board[2][2]) == true || checkWinnerRowColumns(this.board[0][2],this.board[1][1],this.board[2][0]) == true));

    }

    public boolean checkFinalWin() {
        return (checkWinnerRows() || checkWinnerColumms() || checkWinnerDiagonals());
    }


    public boolean boardFull() {
        boolean s = true;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    s = false;
                }
            }
        }
        return s; 
    }

    }

