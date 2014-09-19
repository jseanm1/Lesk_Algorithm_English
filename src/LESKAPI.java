import net.sf.extjwnl.JWNLException;
import net.sf.extjwnl.data.IndexWord;
import net.sf.extjwnl.data.POS;
import net.sf.extjwnl.dictionary.Dictionary;


public class LESKAPI {
	private Dictionary dictionary;
	private IndexWord WORD;
	private LESKImplementor leskImplementor;
	
	public LESKAPI (Dictionary dictionary) {
		this.dictionary = dictionary;
		this.leskImplementor = new LESKImplementor();
	}
	
	public void run(String sentense, String word) throws JWNLException {
		WORD = dictionary.lookupIndexWord(POS.NOUN, word);
		
		leskImplementor.disambiguate(sentense, WORD);
		
	}

}