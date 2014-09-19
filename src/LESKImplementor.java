import java.util.Arrays;
import java.util.List;

import net.sf.extjwnl.data.IndexWord;
import net.sf.extjwnl.data.Synset;


public class LESKImplementor {
	
	private IndexWord WORD;
	private List<String> ignoreWrds = Arrays.asList("a", "A", "The", "the", "Of", "of", "In", "in", "At", "at");
	
	public void disambiguate (String sentense, IndexWord word) {
		this.WORD = word;
		String glosses[] = getGlosses();
		
		int intersections[] = lesk(glosses,sentense);
		
		int index = getMaxIdx(intersections);
		
		System.out.println("\nCorrect Sense");
		System.out.println(glosses[index]);
	}
	
	private String[] getGlosses() {
		List<Synset> synset = WORD.getSenses();
		
		String glosses[] = new String[synset.size()];
		
		System.out.println("Glosses");
		for (int i=0;i<synset.size();i++) {
			glosses[i] = synset.get(i).getGloss();
			System.out.println(glosses[i]);
		}
		
		return glosses;
	}
	
	private int[] lesk(String[] glosses, String sentense) {
		String wrdsS[] = sentense.split(" ");
		String temp[];
		int intersection[] = new int[glosses.length];
		
		for (int i=0;i<glosses.length;i++) {
			temp = glosses[i].split(" ");
			
			for (int j=0;j<wrdsS.length;j++) {
				for (int k=0;k<temp.length;k++) {
					if (ignoreWrds.contains(wrdsS[j])) {
						continue;
					}
					if (wrdsS[j].equals(temp[k])) {
						intersection[i]++;
					}
				}
			}
			
		}
		System.out.println("\nIntersection array");
		for (int i=0;i<intersection.length;i++) {
			System.out.print(intersection[i]+ " ");
		}
		return intersection;
	}
	
	private int getMaxIdx(int[] intersections) {
		int idx = 0;
		int max = intersections[0];
		
		for (int i=0;i<intersections.length;i++) {
			if (max < intersections[i]) {
				idx = i;
				max = intersections[i];
			}
		}
		return idx;
	}
}