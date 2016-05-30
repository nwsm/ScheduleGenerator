package schedGen;

public class employee {
	String firstName;
	String lastName;
	boolean[] jobs;
	int minHours;
	int maxHours;
	
	employee(String FN, String LN, boolean[] Jobs, int minH, int maxH){
		firstName=FN;
		lastName=LN;
		jobs=Jobs;
		minHours=minH;
		maxHours=maxH;
	}
	
	public String toString(){
		String output="";
		output+=firstName + " " + lastName + " ";
		for(int i=0; i<jobs.length; i++)
			output+=jobs[i];
		output+=" " + minHours + " " + maxHours;
		
		return output;
	
	}
	
	
	
}
