package predictive;

public class Sigs2WordsMap {

	public static void main(String[] args) {

		MapDictionary dictionary = new MapDictionary("/usr/share/dict/words");

		for (String x: args) {
			System.out.println(x+" : "+ dictionary.signatureToWords(x));
		}
	}
}
