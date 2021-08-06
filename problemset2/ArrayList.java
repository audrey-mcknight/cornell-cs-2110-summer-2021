package problemset2;

public class ArrayList {
	
	private static final int G = 2; //geometric growth rate
	private static final int K = 5; //arithmetic growth rate
	private static final int I = 5; //initial array size
	
	private int values[] = new int[5];
	private int current_max = I;
	private int values_in_array = 0;
	private int num_expansions=0;
	
	public ArrayList() {
		
	}
	
	public void addGeom(int e) {
		if(values_in_array<current_max) {
			values[values_in_array]=e;
			values_in_array++;
		}
		else {
			int new_max_size= G*values_in_array;
			int temp[] = new int[new_max_size];
			for(int i=0; i<values_in_array;i++) {
				temp[i]=values[i];
			}
			current_max=new_max_size;
			num_expansions++;
			values=temp;
			values[values_in_array]=e;
			values_in_array++;
		}
		
		
	}
	
	public void addArith(int e) {
		if(values_in_array<current_max) {
			values[values_in_array]=e;
			values_in_array++;
		}
		else {
			int new_max_size= K+values_in_array;
			int temp[] = new int[new_max_size];
			for(int i=0; i<values_in_array;i++) {
				temp[i]=values[i];
			}
			current_max=new_max_size;
			num_expansions++;
			values=temp;
			values[values_in_array]=e;
			values_in_array++;
		}
		
		
	}
	
	public static void main(String [] args) {
		ArrayList arith = new ArrayList();
		ArrayList geo = new ArrayList();
		System.out.println("n\tarith\t geom");
		for(int i=0;i<500;i++) {
			arith.addArith(10);
			geo.addGeom(10);
			if (i%25 == 0) {
				System.out.println(i + "\t" + arith.num_expansions + "\t" + geo.num_expansions);
			}
		}
		
	}

}
