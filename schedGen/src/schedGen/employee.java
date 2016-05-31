package schedGen;
//commentttttttttt
//also a comment
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
	
	public String toString(){ 	//whenever you try to convert an employee variable to String, 
		String output="";		//like if you call System.out.println(empVar);, this gets called.
		output+=firstName + " " + lastName + " ";
		for(int i=0; i<jobs.length; i++)
			output+=jobs[i];
		output+=" " + minHours + " " + maxHours;
		
		return output;	//basically it makes a string that displays all the employee variables.
	
	}
	
	
	
}
