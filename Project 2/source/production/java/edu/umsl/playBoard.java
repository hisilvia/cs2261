//*******************************************************************************************************
//Course     : CMP-2261-001
//Author     : Silvia Matthews
//Professor  : Steve Riegerix
//Project 2  : The program prompts two players to drop a red or yellow disk alternately in a column
//           : of their choosing (six-row and seven-column). The one who reaches in consecutive four
//           : same color disks will win the game.
//Date       : 02/16/2022
//*******************************************************************************************************
package edu.umsl;
import java.util.Scanner;
import java.util.InputMismatchException;   //Imported for an error

public class playBoard {
    public static void main(String[] args) {
        String[][] matrix = new String[6][7];
        boolean start = true;
        String user1 = "R";
        String user2 = "Y";

        //Initial matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = " ";
            }
        }
        displayBoard(matrix);

        //Start to play the game
        while (start) {
            //Call the method prompt the first player(R) to drop the disk
            dropDisk(user1, matrix);
            displayBoard(matrix);

            //Check if the player wins
            if (checkWinner(matrix) != null) {
                if (checkWinner(matrix) == user1) {
                    System.out.println("Game is over and the red player won.");
                    //Ends the game if the first player wins
                    System.exit(1); }
                else if (checkWinner(matrix) == user2) {
                    System.out.println("Game is over and the yellow player won.");
                    //Ends the game if the second player wins
                    System.exit(2);}

                //The game ends if the first player wins
                start = false;

            }

            //Call the method prompt the second player(Y) to drop the disk
            dropDisk(user2, matrix);
            displayBoard(matrix);

            //Check if the player wins
            if (checkWinner(matrix) != null) {
                if (checkWinner(matrix) == user1)
                    System.out.println("Game is over and the red player won.");
                else if (checkWinner(matrix) == user2)
                    System.out.println("Game is over and the yellow player won.");
                //The game ends if the second player wins
                start = false;
            }
        }
    }

    //Display the board game
    public static void displayBoard(String[][] matrix) {
        System.out.println(" 0 1 2 3 4 5 6 ");
        for (int i = matrix.length-1; i >= 0; i--) {
            System.out.print("|");
            for (int j = 0 ; j <= matrix[i].length-1; j++) {
                System.out.print(matrix[i][j] + "|");
            }
            System.out.println();
        }
        System.out.println("________________");
    }


    //Check if the cells of the array are empty
    public static boolean isDiskEmpty(String[][] matrix, int column, String diskColor) {
        for (int i = 0; i < 6; i++) {
            if (matrix[i][column] == " ") {
                matrix[i][column] = diskColor;
                return true;
            }
        }
        return false;
    }

    //Drop the disk
    public static void dropDisk (String disk, String[][] matrix) {
        boolean check; //Hold if the input is right
        do {
            check = false;
            try {
                //Create a Scanner object
                Scanner input = new Scanner(System.in);
                //Prompt the player to enter the number (0-6)
                boolean finish = false;
                do {
                    System.out.print("Please choose a column (0-6) to drop the " + disk + " disk: ");
                    int number = input.nextInt();

                    //Check if the input is a valid number
                    while ((number < 0) || (number > 6) ) {
                        System.out.print("Please enter the number between 0 and 6, try it again: ");
                        number = input.nextInt();}

                    //Check if the cells of the array are empty
                    if (isDiskEmpty(matrix, number, disk)) {
                        finish = true;    //If the cell of array is empty, then drop the disk. Otherwise, choose another cell.
                    }
                    else {
                        System.out.println ("This column is full. Please choose a different column");
                    }
                }while (!finish);
            }catch (InputMismatchException exception) {
                System.out.println("Caught " + exception.getMessage());
            }
        }while(check);
    }


    //Check the winning conditions
    public static String checkWinner(String[][] matrix) {
        boolean win = true;

        //Check the horizontal situation
        for (int i = 0; i < matrix.length; i++) {
            for ( int j = 0; j < (matrix[i].length-3); j++) {
                if ( (matrix[i][j] != " ") && (matrix[i][j] == matrix[i][j+1] )  && (matrix[i][j] == matrix[i][j+2] ) && (matrix[i][j] == matrix[i][j+3] ) ) {
                    return matrix[i][j];
                }
            }
        }

        //Check the vertical situation
        for (int i = 0; i < 3; i++) {
            for ( int j = 0; j < 7; j++) {
                if ( (matrix[i][j] != " ") && (matrix[i][j] == matrix[i+1][j] )  && (matrix[i][j] == matrix[i+2][j] ) && (matrix[i][j] == matrix[i+3][j] ) ){
                    return matrix[i][j];
                }
            }
        }

        //Check the diagonal situation (top left to bottom right)
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if ( (matrix[i][j] != " ") && (matrix[i][j] == matrix[i+1][j+1]) && (matrix[i][j] == matrix[i+2][j+2]) && (matrix[i][j] == matrix[i+3][j+3]) )
                    return matrix[i][j];
            }
        }
        //Check the diagonal situation (top right to bottom left)
        for (int i = 0; i < 3; i++) {
            for (int j = 3; j < 7; j++) {
                if ( (matrix[i][j] != " ") && (matrix[i][j] == matrix[i+1][j-1]) && (matrix[i][j] == matrix[i+2][j-2]) && (matrix[i][j] == matrix[i+3][j-3]) )
                    return matrix[i][j];
            }
        }

        //Return null if no same colored disk is found
        return null;
    }

}
