package problemset2;

import java.util.*;

public class ProblemThree {
//
	public static boolean canReorder(List<Integer> inputOrder, int k) {
		List<Stack<Integer>> holdingTracks = new ArrayList<Stack<Integer>>();
		int nextN = 1; //the next car needed for output
		for (int i=0;i<k;i++) {
			holdingTracks.add(new Stack<Integer>());
		}
		for (int i=0;i<inputOrder.size();i++) {
			Integer train = inputOrder.get(i); 
			if (train.equals(nextN)) { //can go straight on output track
				nextN++;
			} else { //need to hold this one
				boolean done = false;
				//check the tops of all of the tracks for a next car
				while (!done) {
					done = true;
					for (int j=0;j<k;j++) {
						if (holdingTracks.get(j).size() > 0) 
							if (holdingTracks.get(j).peek().equals(nextN)) {
								nextN++;
								holdingTracks.get(j).pop();
								done = false; //we found one, so we have to do the checks again
							}
					}
				}
				boolean placed = false;
				int j = 0;
				while (!placed) {
					if (j>=k) {return false;} //nowhere to put this train!
					if ((holdingTracks.get(j).size() == 0) || (holdingTracks.get(j).peek() > train)) {
						holdingTracks.get(j).push(train);
						placed = true;
					}
					j++;
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		List<Integer> trains = new ArrayList<Integer>();
		trains.add(2);
		trains.add(3);
		trains.add(4);
		trains.add(5);
		trains.add(1);
		System.out.println(canReorder(trains, 4));
	}

}
