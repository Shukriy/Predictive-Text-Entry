package predictive;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
/**
 * class PredictivePrototype contains two method
 * wordToSignature and signatureToWords
 * @author ShukriAli
 *@version 5/2/2018
 */
public class PredictivePrototype {

	/**
	 * wordToSignature method converts a word into a signature 
	 * based on the T9 system, where it checks each letter and 
	 * assigns it to a corresponding number if it is an alphabetic 
	 * character. This method used StringBuffer instead of String
	 * because the String object is immutable. When you concatenated
	 * Strings then in the bytecode it uses StringBuffer as it has 
	 * an append method and converts back to a String. By using a
	 * StringBuffer you can skip that whole part making it
	 * more efficient.
	 * @param word is the String that is being converted
	 * @return retuns a String of the numbers corresponding 
	 * to the word
	 */
	public static String wordToSignature(String word) {
		StringBuffer str = new StringBuffer();

		word = word.toLowerCase();
		int x;

		for (int i = 0; i < word.length(); i++) {
			x = word.charAt(i)-97;
			if(x<0 || x > 25){
				str.append(" ");

			}else 
				// these numbers round up to a number higher than the number allocated in the t9
				if (x == 18 ||x == 21 || x == 24 || x == 25) {
					str.append(x/3+1);
				}
				else 
					str.append(x/3+2);
		}
		return str.toString();
	}
	/**
	 * signatureToWords method creates a set with all 
	 * possible matches of a signature from a 
	 * file.
	 * @param signature is String of the signature numbers
	 * @return returns a set of words matching the signature
	 */
	public static Set<String> signatureToWords(String signature){

		Set<String> setOfWords = new TreeSet<>();
		Scanner scr = null;
		String line;

		try {
			// wrap a scanner around FileReader
			scr = new Scanner(new FileReader("/Users/ShukriAli/Downloads/words"));

			// use the hasNext() method of the Scanner to read one line at a time.
			// if there is no more lines left it will be false and stop the loop
			//toLowerCase() ensures that the words from the dictionary are lowercase
			//otherwise method wordToSignature might not work
			while ((scr.hasNext())){
				//uses wordToSignature method to convert the word in the dictionary into a signuture and 
				//the compares if the signutures are the same and if that word is not already
				// in the list
				//and ignores words with non-alphabetic characters
				line = scr.next().toLowerCase();

				if (isValidWord(line)){

					if (wordToSignature(line).equals(signature)){
						// if the word fillfulls the previous conditions the the word is added to the set
						setOfWords.add(line);
					}
				}
			}
		}

		catch (IOException e) {
			System.out.println("Words file has not been found.");
		} finally {
			scr.close(); 
		}
		return setOfWords;
	}

	/**
	 * This method checks whether the words in the 
	 * dictionary are non-alphabetic characters
	 * @param word is the words in dictionary to be checked 
	 * if it is a valid word
	 * @return returns true if the word exists of only
	 * alphabetic characters else returns false
	 */
	public static boolean isValidWord(String word) {

		word = word.toLowerCase();
		int x;

		for (int i = 0; i < word.length(); i++) {

			x = word.charAt(i);
			if(x<97 || x > 122){
				return false;
			}
		}
		return true;

	}
}
