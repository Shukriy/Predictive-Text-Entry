package predictive;

public class Sigs2WordsList {

	public static void main(String[] args) {

		ListDictionary dictionary = new ListDictionary("/usr/share/dict/words");

		for (String x: args) {
			System.out.println(x+" : "+ dictionary.signatureToWords(x));
		}
	}
}
