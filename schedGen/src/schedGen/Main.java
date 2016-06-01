package schedGen;

import java.sql.*;


public class Main {

	public static void main(String args[]) {
		String dbName = "sql5121832";
		
			try{
				String url = "jdbc:mysql://sql5.freemysqlhosting.net:3306/";
				String userName = "sql5121832";
				String password = "WncM9gyuA9";
				Connection connection = DriverManager.getConnection(url + dbName, userName, password);
				
				Statement myStmt = connection.createStatement();
				
				ResultSet myRs = myStmt.executeQuery("select * from employees");
				if (!myRs.isBeforeFirst()) {    		//if ResultSet is empty, say so. Otherwise, print out all names
					 System.out.println("No data"); 
				}else{
					while (myRs.next()){
						System.out.println(myRs.getString("lastName") + ", " + myRs.getString("firstName"));
					
					}
				}
				
			}catch (Exception exc){
				exc.printStackTrace();
			}
			form form1=new form();
			form1.main(args);
			
	}	
}
