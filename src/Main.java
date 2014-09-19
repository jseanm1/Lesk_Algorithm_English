import java.util.Scanner;

import net.sf.extjwnl.JWNLException;
import net.sf.extjwnl.dictionary.Dictionary;


public class Main {

public static void main (String arg[]) throws JWNLException {
		
		Dictionary dictionary = Dictionary.getDefaultResourceInstance();
		Scanner scan = new Scanner(System.in);
		
		String sentense = scan.nextLine();
		String word = scan.nextLine();
		
		new LESKAPI(dictionary).run(sentense, word);
		
	}
}
