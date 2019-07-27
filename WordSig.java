package predictive;
/**
 * @author ShukriAli
 * @version 5/2/2018
 */
public class WordSig implements Comparable<WordSig>{

	private String words;
	private String signature;

	/**
	 * WordSig constructor take in a word and 
	 * constructs a WordSig object with a word
	 * and signature
	 * and a signature
	 * @param words is a String
	 */
	public WordSig (String words) {

		this.words = words;
		this.signature = PredictivePrototype.wordToSignature(words);
	}
	/**
	 * WordSig constructor take in an empty String and signature
	 * then constructs a WordSig object with a word and signature
	 * @param words is a String
	 * @param signature is a String
	 */
	public WordSig (String words, String signature) {

		this.words = "";
		this.signature = signature;
	}
	/**
	 * is the getter for words
	 * @return returns a word
	 */
	public String getWords() {
		return words;
	}
	/**
	 * getter for signature
	 * @return returns a signature
	 */
	public String getSignature() {
		return signature;
	}

	/**
	 * compareTo method compares two signatures
	 * @param ws an WordSig signatures
	 * @return returns -1, 0 or 1 according to whether 
	 * the current signatures is less than, equal to, or greater 
	 * than the argument signatures, in the intended ordering
	 */
	public int compareTo(WordSig ws) {

		int x= (this.signature.compareTo(ws.signature));

		if(x>0){
			return 1;
		}
		else if (x<0){
			return -1;
		}
		else return 0;
	}

	public String toString () {
		return signature + " = " + words;
	}



}
