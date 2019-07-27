package predictive;

import java.io.FileNotFoundException;

/**
 * This class is a command line program to run the Sigs2WordsTree program containing the stored dictionary
 * @author Mohammad Ani
 */
public class Sigs2WordsTree {
    public static void main(String[] args) throws FileNotFoundException {
        MapDictionary storedDictionary = new MapDictionary("/usr/share/dict/words");
        for (String arg : args) {
            System.out.println(arg + " : " + storedDictionary.signatureToWords(arg).toString().replace(",", "").replace("[", "").replace("]", "").trim());
        }
    }
}