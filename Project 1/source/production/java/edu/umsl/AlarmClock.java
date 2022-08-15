//*******************************************************************************************************
//Course     : CMP-2261-001
//Author     : Silvia Matthews
//Professor  : Steve Riegerix
//Description: Project 1: Take one time stamp in 24-hour notation, and print out a new time stamp,
//           :            45 minutes early also in 24-hour notation.
//Date       : 02/4/2022
//*******************************************************************************************************

package edu.umsl;
import java.util.Scanner;  //Scanner is in the java.util package

import java.util.InputMismatchException;   //Imported for an error

public class AlarmClock {
    public static void main (String[] args) {

        boolean check;     //Hold if the input is right
      do {
            check = false;      //Initialize the input

        try {

            //Create a Scanner object
            Scanner input = new Scanner (System.in);

            //Prompt the user to enter a time
            System.out.println("Enter two integers hour(H) and the minute M)-the format 00 00 ~ 23 59 : ");
            int hours = input.nextInt();
            int minutes = input.nextInt();



        //Check if the input is valid number
        while (hours < 0 || hours > 23 || minutes < 0 || minutes > 59) {
            System.out.print("Please enter two valid numbers: ");
             hours = input.nextInt();
            minutes = input.nextInt();
        }

        //Calculate the final time
        int finalHours = ( hours * 60 + minutes - 45 ) / 60;
        int finalMinutes = ( hours * 60 + minutes - 45 ) % 60;

        if ( finalMinutes < 0 ) {
           finalHours = 23;
           finalMinutes = ( 60 + finalMinutes );
        }

        //Display results
        System.out.println("The new time stamp: " + finalHours + " " + finalMinutes);

        } catch (InputMismatchException exception)  {
            System.out.println("Caught " + exception.getMessage() );
        }

        }while(check);
    }
}
