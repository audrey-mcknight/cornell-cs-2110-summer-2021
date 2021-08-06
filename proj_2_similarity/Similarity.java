//Audrey McKnight amm498@cornell.edu

package proj_2_similarity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Similarity {

	/*
	 * Reads the specified file of N lines and returns a list of N names and a list
	 * of N lists of rankings (each of length M). It is assumed that each of the N
	 * rows of the text file starts with a name and is followed by M integers, as
	 * shown below where N=3 and M=4 (the blank lines are added so that Eclipse's
	 * auto-formatter does not convert the example into a paragraph):
	 * 
	 * john 3 0 2 1
	 *
	 * jane 0 1 2 3
	 * 
	 * ann 1 2 3 0
	 */
	public static void readRankings(//
			String path, //
			List<String> names, //
			List<List<Integer>> rankings //
	) throws Exception {
		// Opening the file
		File file = new File(path);
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();
		int numOfTokens = -1;
		while (line != null) {
			String[] tokens = line.split(" |,");
			assert tokens.length > 0;
			if (numOfTokens < 0)
				numOfTokens = tokens.length;
			else
				assert numOfTokens == tokens.length;
			names.add(tokens[0]);
			List<Integer> list = new ArrayList<>();
			for (int i = 1; i < tokens.length; i++) {
				int value = Integer.parseInt(tokens[i]);
				list.add(value);
			}
			rankings.add(list);
			line = br.readLine();
		}
	}
	
	/*  merge and sort ADAPTED FROM 
	 *  <a href="https://algs4.cs.princeton.edu/22mergesort">Section 2.2</a> of
	 *  <i>Algorithms, 4th Edition</i>
	 *  @author Robert Sedgewick
	 *  @author Kevin Wayne
	 *  to count inversions
	 */
	 // stably merge a[lo .. mid] with a[mid+1 ..hi] using aux[lo .. hi]
    private static int merge(Integer[] a, Integer[] aux, int lo, int mid, int hi) {
    	int inversions = 0;
    	// copy to aux[]
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k]; 
        }
        // merge back to a[]
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)              a[k] = aux[j++];
            else if (j > hi)               a[k] = aux[i++];
            else if (aux[j] < aux[i]) {
            	//System.out.println( aux[j] + " " + aux[i]);
            	a[k] = aux[j++];
            	inversions += mid - i + 1;
            }
            else                           a[k] = aux[i++];
        }
        return inversions;
    }

    ++
    private static void printArray(Integer[] a) {
    	for(int i=0;i<a.length;i++) {
        	System.out.print(a[i] + " ");
        }
    	System.out.println();
    }
    
    // mergesort a[lo..hi] using auxiliary array aux[lo..hi]
    // return number of inversions 
    private static int sort(Integer[] a, Integer[] aux, int lo, int hi) {
        int inversions = 0;
    	if (hi <= lo) return 0;
        int mid = lo + (hi - lo) / 2;
        //System.out.println("lo " + lo + " mid " + mid+ " hi "+ hi);
        inversions += sort(a, aux, lo, mid);
        //System.out.println("left " +inversions);
        inversions += sort(a, aux, mid + 1, hi);
        //System.out.println("right " + inversions);
        inversions += merge(a, aux, lo, mid, hi);
        //System.out.println("merge " + inversions);
        //printArray(a);
        return inversions;
    }

	
	/*
	 * This mode of the program assumes that the numbering of the movies are
	 * according to the rankings of a person X who is not in the input file. The
	 * goal is to consider all N rows of the input and decide which row is most
	 * consistent with the rankings of X. Stated algorithmically, the goal is the
	 * figure out which row of the N rows of input has the minimum number of
	 * inversions.
	 */
	private static void modeImplicit(List<String> names, List<List<Integer>> rankings) {
		int lowestInversions= Integer.MAX_VALUE;
		String lowInvName= "";
		for (int i=0;i<names.size();i++) {
			int size = rankings.get(i).size();
			Integer personRankings[] = new Integer[size];
			for(int j=0;j<size;j++) {
				personRankings[j] = rankings.get(i).get(j);
			}
			int numInversions = sort(personRankings, new Integer[size], 0, size-1);
			//System.out.println(names.get(i) + " " + numInversions);
			if(numInversions<lowestInversions) {
				lowestInversions=numInversions;
				lowInvName= names.get(i);
			}
		}
		System.out.println(lowInvName);
	}

	/*
	 * This mode of the program assumes that person X is in position 0 (i.e. the
	 * first line of the input file) and that the numbering of the movies is not
	 * based on the rankings of person X.
	 */
	private static void modeFirst(List<String> names, List<List<Integer>> rankings) {
		int rankingSize = rankings.get(0).size();
		int mappings[] = new int[rankingSize];
		for (int i=0;i<rankingSize;i++) {
			mappings[rankings.get(0).get(i)] = i;
		}
		int lowestInversions= Integer.MAX_VALUE;
		String lowInvName= "";
		for(int i=1;i<names.size();i++) {
			Integer mappedRankings[] = new Integer[rankingSize];
			for(int j=0;j<rankingSize;j++) {
				mappedRankings[j] = mappings[rankings.get(i).get(j)];
			}
			//printArray(mappedRankings);
			int numInversions = sort(mappedRankings, new Integer[rankingSize], 0, rankingSize-1);
			//System.out.println(names.get(i) + " " + numInversions);
			if(numInversions<lowestInversions) {
				lowestInversions=numInversions;
				lowInvName= names.get(i);
			}
		}
		System.out.println(lowInvName);
	}

	/*
	 * Given N names and N rankings (both indexed from 0 to N-1), this mode of the
	 * program determines which two people are most consistent with each other.
	 */
	private static void modeAny(List<String> names, List<List<Integer>> rankings) {
		// ...YOUR WORK GOES HERE...
	}

	public static void main(String[] args) throws Exception {
		if (args.length > 1) {
			String mode = args[0];
			String fileName = args[1];
			List<String> names = new ArrayList<>();
			List<List<Integer>> rankings = new ArrayList<List<Integer>>();
			readRankings(Defaults.pkg + File.separatorChar + fileName, names, rankings);

			if (mode.equals("implicit")) {
				modeImplicit(names, rankings);
			} else if (mode.equals("first")) {
				modeFirst(names, rankings);
			} else if (mode.equals("any")) {
				modeAny(names, rankings);
			} else {
				System.err.println("We should never see this!");
			}
		}
	}
}
