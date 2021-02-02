import java.util.*;
import sun.tools.jar.resources.jar_pt_BR;
import java.lang.*; 

class GameGrid {


    public static void main(String[] args) {

        dashedLines(); 

        System.out.println("Welcome to Tic Tac Toe!"); 
        dashedLines(); 
        

        setBoard(); 

    } 
 
    public static void setBoard() {

        final Cell[][] board = new Cell[3][3];
		int num = 1; 
		for(int i = 0 ; i < board.length;i++)
		{
			for(int j = 0 ; j < board[0].length;j++)
			{
                board[i][j] = new Cell(num++);
                System.out.print(board[i][j]); 
			}
        }

    }
	

    
    //Constructor here

    /* public static void getPosition();

    public static void setPosition();

    public static void checkWinner(); */



//Method to print out dashed lines to separate printed deck 
public static void dashedLines() {

    System.out.println(); 
    for (int i = 1; i <=150; i++) {
        System.out.print("-");
    }
    System.out.println();

}


}