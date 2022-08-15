//*******************************************************************************************************
//Course     : CMP-2261-001
//Author     : Silvia Matthews
//Professor  : Steve Riegerix
//Project 3  : This project is to encode a string and convert(decode) it to the standard output by using
//           : the org.apache.commons.codec.binary.Base64 class from the Apache Commons Codec library.
//Date       : 03/3/2022
//*******************************************************************************************************
package edu.umsl;
import java.util.Scanner; //Scanner is in the java.util package
import org.apache.commons.codec.binary.Base64;

public class EncodeString {

    public static void main(String[] args) {

        String str = "SSBsb3ZlIG15IENNUCBTQ0kgMjI2MSBjbGFzcyBzbyBtdWNoLCBJIHdpc2ggSSBjb3VsZCBiZSBqdXN0IGFzIGNvb2wgYXMgbXkgcHJvZmVzc29y";

        //Encode the string
        byte[] decodedStr = Base64.decodeBase64(str.getBytes());
        System.out.println("Decoded string: " + new String(decodedStr));

        //Decode the string (Convert the encoded string back to the original string)
        byte[] encodedStr = Base64.decodeBase64(decodedStr);
        System.out.println("Encoded string: " + new String(encodedStr));

        //Prompt a user to enter a string
        Scanner input = new Scanner(System.in);   //Create a Scanner object
        System.out.print("Please type a string to encode: ");
        String userStr = input.nextLine();  //nextLine() method can capture a space in the string

        //Encode the user's string
        byte[] encodedUserStr = Base64.encodeBase64(userStr.getBytes());
        System.out.println("Encoded the user's string: " + new String(encodedUserStr));

        //Decode the user's string (Convert the encoded string back to the original string)
        byte[] decodedUserStr = Base64.decodeBase64(encodedUserStr);
        System.out.println("Decoded the user's string: " + new String(decodedUserStr));

    }
}


/*
//Prompt a user to enter a string
        Scanner input = new Scanner(System.in);   //Create a Scanner object
        boolean finish = false;
        Scanner again = new Scanner(System.in);
        System.out.print("Please type a string to encode: ");

        do {
            String userStr = input.nextLine();  //nextLine() method can capture a space in the string

            //Encode the user's string
            byte[] encodedUserStr = Base64.encodeBase64(userStr.getBytes());
            System.out.println("Encoded the user's string: " + new String(encodedUserStr));

            //Decode the user's string (Convert the encoded string back to the original string)
            byte[] decodedUserStr = Base64.decodeBase64(encodedUserStr);
            System.out.println("Decoded the user's string: " + new String(decodedUserStr));

            System.out.print("Do you want to encode one more string?(Yes/No): ");
            String a = again.next();

            if ( a.equalsIgnoreCase("yes") )     //Compare two strings
                System.out.print("Please type a string to encode: ");
            else
                finish = true;
        }while ( !finish );
 */
