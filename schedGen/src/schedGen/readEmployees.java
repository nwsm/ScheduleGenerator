package schedGen;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class readEmployees{

	employee[] readFile() throws IOException{
		String file="employees.txt";		
		BufferedReader br = new BufferedReader(new FileReader(file));
	
		String line = null;
		char[] lineChar=null;
		int numJobs=0;
		String firstName;
		String lastName;
		int numEmployees=-1;
		boolean go = true;
		
		while((line=br.readLine()) != null){			//reads first line and counts number of commas to determine
			lineChar=line.toCharArray();			//number of jobs
			for(int i=0; i<lineChar.length; i++){
				if(lineChar[i]==',' && go)
					numJobs++;				
			}
			go=false;
			numEmployees++;
		}
		br.close();
		if(numEmployees<0){
			employee[] temp = null;
			return temp;	//return empty array if file is empty		
			
		}
		employee[] employees=new employee[numEmployees];
		br= new BufferedReader(new FileReader(file));
		
		String[] allJobs= new String[numJobs];
		String jobName="";
		int iter =0;
		if((line=br.readLine()) != null){			//reads first line again and fills allJobs with job names
			lineChar=line.toCharArray();
			for(int i=0; i<lineChar.length; i++){
				if(lineChar[i]==','){
					allJobs[iter]=jobName;
					iter++;
					jobName="";
				}
				else
					jobName+=lineChar[i];				
			}
		}
		String tempName="";
		String minHours="";
		String maxHours="";
		boolean[] jobs = new boolean[numJobs];
		int x=0;
		while ((line = br.readLine()) != null){
			iter=0;
			minHours="";
			maxHours="";
			lineChar=line.toCharArray();
			while(lineChar[iter]!=','){ //read first name
				tempName+=lineChar[iter];
				iter++;
			}
			firstName=tempName;
			tempName="";
			iter++;
			while(lineChar[iter]!=','){ //read last name
				tempName+=lineChar[iter];
				iter++;
			}
			lastName=tempName;
			tempName="";
			iter++;
			
			for(int i=0; i<numJobs; i++){
				if(lineChar[iter]=='0') //reads job skills
					jobs[i]=false;
				else
					jobs[i]=true;
				iter++;
			
			}
			iter++;
			minHours="";
			minHours=""+lineChar[iter]+lineChar[iter+1]; //reads min hours
			iter+=3;
			maxHours=""+lineChar[iter]+lineChar[iter+1]; //max hours
			
			employees[x]=new employee(firstName,lastName,jobs,Integer.parseInt(minHours),Integer.parseInt(maxHours));
			x++;
		}
	
		br.close();
		return employees;
	}

}
