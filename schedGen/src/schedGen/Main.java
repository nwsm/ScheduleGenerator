package schedGen;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class Main {

	public static void main(String args[]) throws IOException{
			readEmployees temp = new readEmployees();
			employee[] emps = temp.readFile();
			for(int i=0; i<emps.length; i++)
				System.out.println(emps[i]);
			
		
	}
	
}
