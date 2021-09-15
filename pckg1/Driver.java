package pckg1;
import java.lang.Math;

import java.util.Scanner;

public class Driver {
	
	/*
	 * Validates yesno string, to ensure either contains Y or N (case insensitive)
	 */
	public static boolean validateYesNo(String yesno) { // returns true if valid
		if (yesno.equalsIgnoreCase("Y"))
			return true;
		if (yesno.equalsIgnoreCase("N"))
			return true;
		else return false; // if invalid	
	}

	public static void main(String[] args) {

		// WELCOME
		System.out.println("****** Welcome to the One Time Pad Encoder ******"
				+ "\n\nThis program encodes plaintext into ciphertext using the One-Time Pad encryption model."
				+ "\nPlease keep in mind that this program utilizes pseudo-randomness to generate the key."
				+ "\nTherefore, it is not perfectly secure like a proper One-Time Pad system should be via, say, dice rolling."
				+ "\nThis program simply emulates the process of its encryption."); // Introduction

		// STREAMS
		Scanner keyboard = new Scanner(System.in); // will get input from keyboard
		boolean done = false; // this boolean will ensure program loops until
		String yesno = ""; // this will hold a value, either Y or N that determines whether to loop the program until done


		while (!done) {

			//USER INPUT
			System.out.println("\n\nPlease enter the cipher to encrypt:"); // prompt user for input
			String plaintxt = keyboard.nextLine(); // getting user input

			// KEY GENERATION
			System.out.println("\nGenerating key..."); // feedback to user		
			Key key = new Key(plaintxt.length()); // generate key according to cipher length
			key.printKey(0); // printing key

			// ENCRYPTION	
			System.out.println("\nEncrypting..."); // feedback to user
			Encrypter cipher = new Encrypter(plaintxt, key);
			System.out.println("Encrypted ciphertext: \'"+cipher.toString()+"\'\n"); // printing

			// DECRYPTION	
			System.out.println("\nNow decrypting..."); // feedback to user
			Decrypter dec_plaintxt = new Decrypter(cipher.toString(), key);
			System.out.println("Decrypted plaintext: \'"+dec_plaintxt.toString()+"\'\n"); // printing

			do  { // prompts for Y/N until valid
				System.out.println("\nWould you like to try a new password? Please enter Y/N");
				yesno = keyboard.nextLine();
				if (!validateYesNo(yesno))
					System.out.println("\nError. Invalid input. Please try again");
			}	while (!validateYesNo(yesno));

			if (yesno.equalsIgnoreCase("N")) // if user wishes to end program
				done = true; // set done to true to avoid looping	

		} // while !done

		// PROGRAM END
		System.out.println("\nThank you for using the program! Closing.");
		keyboard.close(); // closing streams

	}

}
