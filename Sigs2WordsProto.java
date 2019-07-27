package predictive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Sigs2WordsProto {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("/usr/share/dict/words");
		Scanner scr = new Scanner(file);

		for (int i=0;i<args.length;i++) {

			System.out.println(args[i] + " = " + PredictivePrototype.signatureToWords(args[i]));
		}       

		scr.close();
	}
}

