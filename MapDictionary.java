package predictive;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * class MapDictionary is a “multi-valued map” data structure that 
 * maps each signature to set of words and implements interface Dictionary.
 * This class contains methods signatureToWords and addWords
 * Map implementation used in this class is the HashMap because
 * it provides constant-time performance for the 
 * basic operations (get and put) and these are the main
 * function we are using for the map
 * @author ShukriAli
 * @version 13/02/3018
 */
public class MapDictionary implements Dictionary{
	
	private HashMap<String,Set<String>> dict; // is this right way to implement generics

	/**
	 * MapDictionary constructor takes in words from the
	 * dictionary file and constructs HashMap dictionary
	 * each word is converted into a signature then each
	 * signature has set of words
	 */
	public MapDictionary(String path) {
		this.dict = new HashMap<>();
		
		Scanner scr = null;
		
		try {
			File theFile = new File(path);
			scr = new Scanner(theFile);

			while (scr.hasNext()) {
				String wordx = scr.next().toLowerCase();
				String sig = PredictivePrototype.wordToSignature(wordx);
				if (PredictivePrototype.isValidWord(wordx));
				dict.put(sig, addWords(sig, wordx));
			}
		}
		catch (IOException e) {
			System.out.println("File has not been found.");
		} finally {
			scr.close(); 
		}
	}
	/**
	 * interface signatureToWords method converts the signature
	 * into a word for the HashMap
	 * @param sig is a String
	 * @return returns a set of words matching the signature
	 */
	@Override
	public Set<String> signatureToWords(String signature) {
		if (dict.containsKey(signature))
			return dict.get(signature);
		else 
			return Collections.emptySet();
	}
	/**
	 * This method adds words and signature to the HashMap Set if the 
	 * signature is not in the Map else adds the word to the signature alreade
	 * in the Map 
	 * @param signature is a String and the key
	 * @param word is a String
	 * @return Set of words for the Map
	 */
	 public Set<String> addWords(String signature, String word) {
		 Set<String> setWords = new TreeSet<String>();
		 if (!dict.containsKey(signature)) {
			 setWords.add(word);
		 		dict.put(signature, setWords);
		 }
		 else {
			 setWords = dict.get(signature);
			 setWords.add(word);
			 dict.put(signature, setWords);
		 }
		 return setWords;
	 }
}
