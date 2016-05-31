package schedGen;

import java.io.IOException;

public class Main {

	public static void main(String args[]) throws IOException{
			readEmployees temp = new readEmployees();
			employee[] emps = temp.readFile();
			if(emps==null)
				System.out.println("Empty file");
			else if(emps.length==0)
				System.out.println("No employees");
			else{
				for(int i=0; i<emps.length; i++)
					System.out.println(emps[i]);
				form form1 = new form(emps);
				form1.main(args);
			}
	}	
}
