//*******************************************************************************************************
//Course     : CMP-2261-001
//Author     : Silvia Matthews
//Professor  : Steve Riegerix
//Project 4  : PyPy needs to find the minimum number of moves PyPy to kill the magical Hydra
//Date       : 03/18/2022
//*******************************************************************************************************

package edu.umsl;
import java.util.Scanner;
import java.util.InputMismatchException; //Imported for an error

public class KillHydraGame {

    public static void main(String[] args) {

        int s;          //Hod the moving state
        int heads;      //Hold the data from a user
        int tails;      //Hold the data from a user

        int algHead;    //Hold the user data for calculate the minimum number of moves
        int algTail;    //Hold the user data for calculate the minimum number of moves
        int count = 0;  //Initialize the minimum number of moves

        //Describe the game's rule
        System.out.println("--------------------Hydra vs Knight PyPy-----------------------------");
        System.out.println("The only way to kill Hydra is to cut off all H heads and all T tails.");
        System.out.println("--------Please read the rules as below before you start it!----------");
        System.out.println("Knight PyPy only know four moves: ");
        System.out.println("1. Knight PyPy can cut off exactly one of Hydra's heads.");
        System.out.println("2. Knight PyPy can cut off exactly one of Hydra's tails.");
        System.out.println("3. Knight PyPy can cut off exactly two of Hydra's heads.");
        System.out.println("4. Knight PyPy can cut off exactly two of Hydra's tails.");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Hydra is a powerful magical creature with H heads and T tails as below: ");
        System.out.println("If PyPy cuts off exactly one head, a new head grows immediately.");
        System.out.println("If PyPy cuts off exactly one tail, two new tails grow immediately.");
        System.out.println("If PyPy cuts off exactly two tails, a new head grows immediately.");
        System.out.println("If PyPy cuts off exactly two heads, nothing happens.");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Note that a Hydra with 0 heads and T > 0 tails is still alive — in which case it is called a ‘Headless Hydra’.");
        System.out.println("----------------------------------------------------------------------");

        //Prompt a gamer for how many heads and tails to start the game
        boolean check;  //Hold if the input is right
        do {
            check = false;
            try {
                Scanner input = new Scanner(System.in);  //Create a Scanner object
                System.out.print("Enter how many heads to start the game: ");
                int h = input.nextInt();
                System.out.print("Enter how many tails to start the game: ");
                int t = input.nextInt();
                heads = h;
                tails = t;


                System.out.println("About the moving rules:");
                System.out.println("Press 1. Cut off 1 head, then grow a new head.");
                System.out.println("Press 2. Cut off 1 tail, then grow two new tails.");
                System.out.println("Press 3. Cut off 2 heads, then nothing happens.");
                System.out.println("Press 4. Cut off 2 tails, then grow a new head.");
                System.out.println("Press 5. Quit");

                //Copy the data to another variable to count the minimum number of moves
                algHead = heads;
                algTail = tails;

                //Call the function
                s = algorithm(algHead, algTail,count);

                //Allow a user to choose the move steps
                while (heads > 0 || tails > 0) {
                    System.out.print("Choose a number to move: ");
                    int moveSteps = input.nextInt();

                    //Check if the input is valid
                    while (moveSteps < 0 || moveSteps > 5) {
                        System.out.println("Please type a number from 1 to 5. Try it again:");
                        moveSteps = input.nextInt();
                    }

                    //Control the games for the user in case there is no enough head or tail to be cut off
                    if (moveSteps == 5) {
                        System.out.println("You gave up.");
                        System.exit(0);
                    } else {
                        if ((moveSteps == 4) && (tails >= 2)) {
                            tails = tails - 2;
                            heads = heads + 1;
                            display(heads, tails);

                        } else {
                            if ((moveSteps == 3) && (heads >= 2)) {
                                heads = heads - 2;
                                display(heads, tails);

                            } else {
                                if ((moveSteps == 2) && (tails >= 1)) {
                                    tails = tails - 1;
                                    tails = tails + 2;
                                    display(heads, tails);

                                } else {
                                    if ((moveSteps == 1) && (heads >= 1)) {
                                        heads = heads - 1;
                                        heads = heads + 1;
                                        display(heads, tails);

                                    } else {
                                        System.out.println("No enough head or tail to be killed.");
                                    }
                                }
                            }
                        }


                    }
                    //Tell a user the game is over
                    if ((heads == 0) && (tails == 0)) {
                        System.out.println("You killed the Hydra.");
                        System.exit(0);
                    }

                    //Tell a user they are in a special situation
                    if ((heads == 1) && (tails == 0)) {
                         System.out.println("It's impossible to kill Hydra.");
                            s = -1;
                          }

                    //Display the case situation
                    if (s == -1) {
                        System.out.println("It is impossible to kill Hydra!");
                    } else {
                       System.out.println("Pypy can kill Hydra with " + s + " moves in the minimum number.");
                    }
            }

            } catch (InputMismatchException exception) {
                System.out.println("Caught Null" + exception.getMessage());
            }
        }while(check);



    }

    //Display the remaining heads and tails
    public static void display(int heads, int tails) {
          System.out.println("Hydra has " + heads + " heads and " + tails + " tails.");
    }

    //Method to get the minimum number of moves
    public static int algorithm(int heads, int tails, int si) {
        while ((heads > 0) || (tails > 0)) {
            if ((heads % 2 == 0) && (heads != 0)) {
                // moveSteps = 3;
                heads = heads - 2;
                si++;
            } else
                if ((tails <= 3) && (heads == 0)) {
                    //moveSteps = 2;
                    tails++;
                    si++;
                } else {
                    //moveSteps =4;
                    tails = tails - 2;
                    heads = heads + 1;
                    si++;
                }
        }
        return si;
    }
}
