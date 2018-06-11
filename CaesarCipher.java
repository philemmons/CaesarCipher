
/*
 * Title: Cryptography (Caesar Chipher)
 * Abstract: Encrypt or decrypt a message by entering an alphabet shifting value. 
 * There is an option to apply all 26 shifts displaying all possibilities
 * Name: Phillip T. Emmons
 * Date: 12-10-16
 */

package hw7;

import java.util.*;

public class CaesarCipher {
	
	private char[] originalArr;
	private int choice = -1, realShift;
	private boolean decryptMod, going = true;
	private Scanner kb = new Scanner(System.in);
	private String input = "", option = "";
	

	protected CaesarCipher(){
		while( going ){
			System.out.println("\nCryptography (Caesar Cipher)\n" +
					"1. Encrypt.\n2. Decrypt.\n3. All Decrypted Shifts.\n4. Exit.\n" +
					"Select your choice, 1 to 4: ");
			
			choice = kb.nextInt();
			kb.nextLine();
			
			switch( choice ){
				case 1:
					option = "encrypted, shifted right";
					decryptMod = true;
					getText();
					getShift();
					justDoIt();
				break;
				case 2:
					option = "decrypted, shifted left";
					decryptMod = false;
					getText();
					getShift();
					justDoIt();
				break;
				case 3:
					option = "decrypted, shifted left";
					decryptMod = false;
					getText();
					listThemAll();
				break;
				case 4:
					System.out.println("Adios.");
					going = false;
				break;
				
				default:
					System.out.println("Invalid Selection.");
			}
		}
	}
	

	private void listThemAll() {
		for(int p= 0; p<26; p++ ){
			realShift = p;
			System.out.print("\n"+ p + ". ");
			justDoIt();
		}
	}
	
	private void getText(){
		System.out.print("Enter your sentence to be " + option +": ");
		input = kb.nextLine();
		originalArr = input.toCharArray();
	}
	
	private void getShift(){
		System.out.print("Enter a shift value: ");
		int shift = kb.nextInt();
		realShift = shift % 26;
		
	}
	
	private void justDoIt(){
		if( !decryptMod )
			realShift = 26 - realShift;
		char[] newArray = new char[originalArr.length];
		for( int i = 0; i< originalArr.length; i++ ){
			if( originalArr[i] >= 'A' && originalArr[i] <= 'Z' ){
				newArray[i] = (char)( ( ( (originalArr[i] + realShift ) -65 ) % 26) + 65 );	
			}
			
			if( originalArr[i] >= 'a' && originalArr[i] <= 'z' ){
				int ascii = originalArr[i];
				int asciiPlus = ( ascii + realShift );
				int adjAsciiPlus = asciiPlus - 97;
				int modAdjAsciiPlus = adjAsciiPlus % 26;
				int newAsciiLetter =  modAdjAsciiPlus + 97;
				newArray[i] = (char)( newAsciiLetter );
			}
		}
		System.out.println( newArray );
	}
	
	//All the work is done in the object.
	public static void main(String[] args) {
		new CaesarCipher();	
	}
	
}//EOF
