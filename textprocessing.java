/*  Name: Ellis Sentoso
 *  Instructor: Dave Harden
 *  Assignment: Lab 5 - Text Processing
 *  Description: Get string from the user and key character from the user to search in the
 *  				string then mask it with '$', then remove it from the string, and count 
 *  				the key characters
 *  Email: ellissentoso@gmail.com
 *  Date: 07/19/2019
 */
/*___________________________________________________________________________________________*/
package assignment5;

import java.util.Scanner;


public class Foothill {
	static final int minString = 4; // minimum characters allowed
	static final int maxString = 500; // maximum characters allowed

/*___________________________________________________________________________________________*/

	public static void main(String[] args) {

		String theString;
		char keyCharacter;

		theString = getString(); // storing value of string to string variable
		keyCharacter = getkeyCharacter(); // storing value of character to character variable
		maskCharacter(theString, keyCharacter); // invoking masking method
		removeCharacter(theString,keyCharacter); // invoking removing character method
		countKey(theString, keyCharacter);		// invoking counting keyCharacter of a string
	}
/*___________________________________________________________________________________________*/
	//Precondition: none
	//Postcondition: return phrase and sentences from the user
	public static String getString() {
		String word;
		int lengths;
		lengths = 0;
		Scanner input = new Scanner(System.in);  // Create a Scanner object

		do { // Ask the user for a string between 4 to 500 range
			System.out.println("Please enter a phrase or sentence >= 4 and <= 500 characters"); // ensure a range of 4 letters from the user
			word = input.nextLine();
			lengths = word.length();
		} while (lengths < minString || lengths > maxString);
		return word;
	}
/*___________________________________________________________________________________________*/
	//Precondition: none for parameters and user input of string
	//Postcondition: return a key character variable from the user 
	public static char getkeyCharacter() {
		String key;
		Scanner input = new Scanner(System.in);  // Create a Scanner object
		// This function will take only the first letter if more than one characters are typed
		do {
			System.out.println("Please enter a SINGLE character to act as key: "); // ensure a range of 4 letters from the user
			key = input.nextLine();					// store character to a char variable
		} while (key.length()>1);
		input.close(); 							// Prevents leak
		return key.charAt(0);

	}
/*___________________________________________________________________________________________*/
	//Precondition: string and char variable
	//Postcondition: return a string that has a key character in a string masked with '$'	
	public static String maskCharacter(String theString, char keyCharacter) {
		String initialStr = ""; // The empty starter string		
		char aArray[] = new char[theString.length()]; // character array to store

		for (int i = 0; i < theString.length() ; i++) { // go through each in a string
			if (theString.charAt(i)== keyCharacter) {   // if it's the key character
				aArray[i] = '$'; 						// store '$' to that position
			}
			else if (theString.charAt(i) != keyCharacter) { // If it's not the keyCharacter,
				aArray[i] = theString.charAt(i);			// store it normally to the char Array
			}
		}
		for(int i = 0; i < theString.length();i++) {
			initialStr += String.valueOf(aArray[i]); 
		}
		System.out.println("String with " + "'"+ keyCharacter + "'" + " masked");
		System.out.println(initialStr); // Displaying to the user
		return initialStr;

	}
/*___________________________________________________________________________________________*/
	//Precondition: string and char variables
	//Postcondition:  return the string that has key character removed from the string variable
	public static String removeCharacter(String theString, char keyCharacter) {
		String initialStr = ""; // The empty starter string		
		char aArray[] = new char[theString.length()]; // character array to store

		for (int i = 0; i < theString.length();i++) { // Go hrough each in the string
			if (theString.charAt(i) != keyCharacter) { // if it's not the keyCharacter
				aArray[i] = theString.charAt(i);	   // Then store it in the char array
			}
		}
		for(int i = 0; i < theString.length();i++) {
			initialStr += String.valueOf(aArray[i]); // Change character Array to string
			// Storing to the string variable
		}
		System.out.println("\nString with " + "'"+ keyCharacter + "'" + " removed");
		System.out.println(initialStr); // Displaying to user
		return initialStr;
	}
/*___________________________________________________________________________________________*/
	//Precondition: string and char variables
	//Postcondition:  return the number of key character in the string
	public static int countKey(String theString, char keyCharacter) {
		int keyCount;
		keyCount = 0;

		for (int i = 0; i < theString.length() ; i++) { // Go through each character of a string
			if (theString.charAt(i)== keyCharacter) {   // if it matches the keyCharacter
				keyCount++;								// increase the keyCharacter counter
			}
		}
		System.out.println("\n# " + keyCharacter + "s: " + keyCount);

		return keyCount;
	}
/*___________________________________________________________________________________________*/

}

/*________________________________Sample Run__________________________________________
 * Please enter a phrase or sentence >= 4 and <= 500 characters
sdf
Please enter a phrase or sentence >= 4 and <= 500 characters
sfd sf jko POIJ  JKOLP  lkjsdf psadfjP sdfj erP sdfp
Please enter a SINGLE character to act as key: 
dgkfpo
Please enter a SINGLE character to act as key: 
O*(U
Please enter a SINGLE character to act as key: 
P
String with 'P' masked
sfd sf jko $OIJ  JKOL$  lkjsdf psadfj$ sdfj er$ sdfp

String with 'P' removed
sfd sf jko  OIJ  JKOL   lkjsdf psadfj  sdfj er  sdfp

# Ps: 4
/*________________________________Sample Run #2__________________________________________
Please enter a phrase or sentence >= 4 and <= 500 characters
kds adfjdfh skdjfhdsa
Please enter a SINGLE character to act as key: 
2132sdfa
Please enter a SINGLE character to act as key: 
kksdfsdj
Please enter a SINGLE character to act as key: 
u
String with 'u' masked
kds adfjdfh skdjfhdsa

String with 'u' removed
kds adfjdfh skdjfhdsa

# us: 0
 */


