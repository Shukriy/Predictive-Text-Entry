package predictive;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
/**
 * The class ListDictionary creates a dictioanry
 * in a ArrayList with each line containing a WordSig
 * object meaning a word and a signature. Also this class
 * contains the method signatureToWords
 * @author ShukriAli
 * @version 5/2/2018
 */
public class ListDictionary implements Dictionary{

	private ArrayList<WordSig>dictionary;
	/**
	 * ListDictionary constructor takes in  words from the
	 * dictionary file and constructs ArrayList dictionary
	 * with WordSig objects. Also uses Collections sorting method
	 */
	public ListDictionary(String path) {
		Scanner src = null;
		//this Arraylist will create a new dictionary that will hold 
		//all the valid words and their signitures and hold class WordSig 
		//as object
		dictionary = new ArrayList<WordSig>();

		try {
			//locates the file
			File theFile = new File(path);
			//reads the file one word at a time
			src = new Scanner(theFile);

			while (src.hasNext()) {
				//assigns that word to the variable wordx 
				//while ensuring all words are lowercase
				String wordx = src.next().toLowerCase();

				//checks first whether the word is valid
				if (PredictivePrototype.isValidWord(wordx))

					//Then adds the word to the ArrayList dictionary
					dictionary.add(new WordSig(wordx));
			}
		}
		catch (IOException e) {
			System.out.println("File has not been found.");
		} finally {
			src.close(); 

		}
		//ensures that the list will be sorted
		Collections.sort(dictionary);
	}
	/**
	 * interface signatureToWords method creates a set with all 
	 * possible matches of a signature from the 
	 * ArrayList dictionary. The search is done through a 
	 * Collections.binarySearch method
	 * @param sig is a String
	 * @return returns a set of words matching the signature
	 */
	public Set<String> signatureToWords(String sig){

		//stores all the words that match the signature
		Set<String> mathingWords = new HashSet<String>();

		//this is the key of the words we are looking for and since we only have
		//a signature we leave the word part empty
		WordSig key = new WordSig("", sig);

		//this will hold the location of the end of the ArrayList dictionary
		int end = dictionary.size();

		//binarySearch locates whether the signature is in the dictionary
		//if so it returns an index of where the word is located as a positive int
		//else it returns where it should have been located as a negative int
		//meaning it is not in the ArrayList dictionary
		//If multiple elements in the list match the search key(signature), 
		//there’s no guarantee which one will be located first
		int index = Collections.binarySearch(dictionary, key);

		// as method binarySearch locates 1 matching word at a random position
		//in the ArrayList dictionary, we have to keep searching if there are any other
		//matching words below and above the index returned by the BS method
		int below = index;
		int above = index;

		//if there are no more words that match the signature then it will return an empty list
		//meaning method BS returned a negative int
		if (index < 0) {
			return mathingWords;
		}
		else {
			//while loop will keep checking whether the the signature in the 
			//ArrayList dictionary is equal to the one we have and inside the loop it keeps
			//checking the signature that came below and another loop for above the index
			//then checks whether the word matching the signature is already in the set
			//if not then it adds the word to the set
			//it stops the loop(breaks) when it goes below 0 or above end 
			while (sig.equals(dictionary.get(below).getSignature())) {

				if (!mathingWords.contains(dictionary.get(below).getWords())) {

					mathingWords.add(dictionary.get(below).getWords());
				}
				below--;
				if (below<0)
					break;
			}
			while (sig.equals(dictionary.get(above).getSignature())) {
				if (!mathingWords.contains(dictionary.get(above).getWords())) {

					mathingWords.add(dictionary.get(above).getWords());
				}
				above++;
				if (above>end)
					break;	
			}

		}
		return mathingWords;
	}

}
