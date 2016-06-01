package schedGen;

import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class editEmployees {

	private JFrame frame;
	private JTable employeesTable;
	ResultSet myRs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					editEmployees window = new editEmployees();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the application.
	 */
	String dbName = "sql5121832";
	String url = "jdbc:mysql://sql5.freemysqlhosting.net:3306/";
	String userName = "sql5121832";
	String password = "WncM9gyuA9";
	Connection connection;
	private JTextField deleteID;
	private JTextField addEmpFName;
	private JTextField addEmpLName;
	private JTextField addEmpJobs;
	private JTextField addEmpMin;
	private JTextField addEmpMax;
	private JTextField addEmpSun;
	private JTextField addEmpTues;
	private JTextField addEmpWed;
	private JTextField addEmpThurs;
	private JTextField addEmpFri;
	private JTextField addEmpMon;
	private JTextField addEmpSat;
	private JLabel lblFname;
	private JLabel lblLname;
	private JLabel lblMinhrs;
	private JLabel lblJobs;
	private JLabel lblSun;
	private JLabel lblMaxhrs;
	private JLabel lblSat;
	private JLabel lblFri;
	private JLabel lblThurs;
	private JLabel lblWed;
	private JLabel lblTues;
	private JLabel lblMon;
	private JButton editEmployeeButton;
	private JTextField editEmpFName;
	private JTextField editEmpLName;
	private JTextField editEmpJobs;
	private JTextField editEmpMin;
	private JTextField editEmpMax;
	private JTextField editEmpSun;
	private JTextField editEmpTues;
	private JTextField editEmpWed;
	private JTextField editEmpThurs;
	private JTextField editEmpFri;
	private JTextField editEmpMon;
	private JTextField editEmpSat;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel label_8;
	private JLabel label_9;
	private JLabel label_10;
	private JLabel label_11;
	private JTextField editEmpID;
	private JLabel lblId;
	private JLabel label_12;
	private JTextField addEmpID;
	
	
	
	
	
	public editEmployees() {
		try{
			connection=DriverManager.getConnection(url + dbName, userName, password);
			Statement myStmt = connection.createStatement();
			initialize(myStmt);
		}catch (Exception e){
			System.out.println(e);
		}
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(final Statement myStmt){
		frame = new JFrame();
		frame.setBounds(100, 100, 810, 423);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 636, 157);
		frame.getContentPane().add(scrollPane);
		
		employeesTable = new JTable();
		scrollPane.setViewportView(employeesTable);
		
		JButton basicInfoButton = new JButton("Load Basic Info");
		basicInfoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					myRs = myStmt.executeQuery("select employeeID, firstName, lastName, jobs, minHours, maxHours from employees");
					employeesTable.setModel(DbUtils.resultSetToTableModel(myRs));
				}catch (Exception e){
					System.out.println(e);
				}
			}
		});
		basicInfoButton.setBounds(656, 11, 128, 20);
		frame.getContentPane().add(basicInfoButton);
		
		deleteID = new JTextField();
		deleteID.setBounds(728, 149, 56, 20);
		frame.getContentPane().add(deleteID);
		deleteID.setColumns(10);
		
		JButton deleteEmployeeButton = new JButton("Delete Employee");
		deleteEmployeeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					myStmt.executeUpdate("delete from employees where employeeID="+deleteID.getText());
					myRs = myStmt.executeQuery("select employeeID, firstName, lastName, jobs, minHours, maxHours from employees");
					employeesTable.setModel(DbUtils.resultSetToTableModel(myRs));
					
				}catch (Exception e){
					System.out.println(e);
				}
				editEmpID.setText("");
				editEmpFName.setText("");
				editEmpLName.setText("");
				editEmpJobs.setText("");
				editEmpMin.setText("");
				editEmpMax.setText("");
				editEmpSun.setText("");
				editEmpMon.setText("");
				editEmpTues.setText("");
				editEmpWed.setText("");
				editEmpThurs.setText("");
				editEmpFri.setText("");
				editEmpSat.setText("");
			}
		});
		deleteEmployeeButton.setBounds(656, 121, 128, 23);
		frame.getContentPane().add(deleteEmployeeButton);
		
		JLabel lblNewLabel = new JLabel("Delete ID:");
		lblNewLabel.setBounds(657, 152, 61, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JButton addEmployeeButton = new JButton("Add Employee");
		addEmployeeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){ //the if statement makes sure all relevant textfields have data in them
				if(!addEmpFName.getText().equals("")&&!addEmpLName.equals("")&&!addEmpJobs.equals("")
						&&!addEmpMin.equals("")&&!addEmpMax.equals("")&&!addEmpSun.equals("")
						&&!addEmpMon.getText().equals("")&&!addEmpTues.getText().equals("")&&!addEmpWed.getText().equals("")
						&&!addEmpThurs.getText().equals("")&&!addEmpFri.getText().equals("")&&!addEmpSat.getText().equals("")){
						
						String str=addEmpID.getText()+",'"+addEmpFName.getText()+"','"+addEmpLName.getText()+"','"+addEmpJobs.getText()+"',"
								+addEmpMin.getText()+","+addEmpMax.getText()+",'"+addEmpSun.getText()+"','"
								+addEmpMon.getText()+"','"+addEmpTues.getText()+"','"+addEmpWed.getText()+"','"
								+addEmpThurs.getText()+"','"+addEmpFri.getText()+"','"+addEmpSat.getText()+"'";
						try{
							System.out.println("insert into employees values("+str+")");
							myStmt.executeUpdate("insert into employees values("+str+")");
							myRs = myStmt.executeQuery("select employeeID, firstName, lastName, jobs, minHours, maxHours from employees");
							employeesTable.setModel(DbUtils.resultSetToTableModel(myRs));							
						
						
						}catch (Exception exc){
							System.out.print(exc);
						}
						//Clear all the relevant textfields
						addEmpID.setText("");
						addEmpFName.setText("");
						addEmpLName.setText("");
						addEmpJobs.setText("");
						addEmpMin.setText("");
						addEmpMax.setText("");
						addEmpSun.setText("");
						addEmpMon.setText("");
						addEmpTues.setText("");
						addEmpWed.setText("");
						addEmpThurs.setText("");
						addEmpFri.setText("");
						addEmpSat.setText("");
			}
			}
		});
		addEmployeeButton.setBounds(10, 179, 110, 23);
		frame.getContentPane().add(addEmployeeButton);
		
		addEmpFName = new JTextField();
		addEmpFName.setText(" ");
		addEmpFName.setBounds(20, 230, 50, 20);
		frame.getContentPane().add(addEmpFName);
		addEmpFName.setColumns(10);
		
		addEmpLName = new JTextField();
		addEmpLName.setBounds(84, 230, 50, 20);
		frame.getContentPane().add(addEmpLName);
		addEmpLName.setColumns(10);
		
		addEmpJobs = new JTextField();
		addEmpJobs.setColumns(10);
		addEmpJobs.setBounds(148, 230, 50, 20);
		frame.getContentPane().add(addEmpJobs);
		
		addEmpMin = new JTextField();
		addEmpMin.setColumns(10);
		addEmpMin.setBounds(212, 230, 50, 20);
		frame.getContentPane().add(addEmpMin);
		
		addEmpMax = new JTextField();
		addEmpMax.setColumns(10);
		addEmpMax.setBounds(276, 230, 50, 20);
		frame.getContentPane().add(addEmpMax);
		
		addEmpSun = new JTextField();
		addEmpSun.setColumns(10);
		addEmpSun.setBounds(340, 230, 50, 20);
		frame.getContentPane().add(addEmpSun);
		
		addEmpTues = new JTextField();
		addEmpTues.setColumns(10);
		addEmpTues.setBounds(468, 230, 50, 20);
		frame.getContentPane().add(addEmpTues);
		
		addEmpWed = new JTextField();
		addEmpWed.setColumns(10);
		addEmpWed.setBounds(532, 230, 50, 20);
		frame.getContentPane().add(addEmpWed);
		
		addEmpThurs = new JTextField();
		addEmpThurs.setColumns(10);
		addEmpThurs.setBounds(596, 230, 50, 20);
		frame.getContentPane().add(addEmpThurs);
		
		addEmpFri = new JTextField();
		addEmpFri.setColumns(10);
		addEmpFri.setBounds(660, 230, 50, 20);
		frame.getContentPane().add(addEmpFri);
		
		addEmpMon = new JTextField();
		addEmpMon.setColumns(10);
		addEmpMon.setBounds(404, 230, 50, 20);
		frame.getContentPane().add(addEmpMon);
		
		addEmpSat = new JTextField();
		addEmpSat.setColumns(10);
		addEmpSat.setBounds(724, 230, 50, 20);
		frame.getContentPane().add(addEmpSat);
		
		lblFname = new JLabel("FName");
		lblFname.setBounds(30, 213, 50, 14);
		frame.getContentPane().add(lblFname);
		
		lblLname = new JLabel("LName");
		lblLname.setBounds(90, 213, 44, 14);
		frame.getContentPane().add(lblLname);
		
		lblMinhrs = new JLabel("minHrs");
		lblMinhrs.setBounds(212, 213, 50, 14);
		frame.getContentPane().add(lblMinhrs);
		
		lblJobs = new JLabel("Jobs");
		lblJobs.setBounds(158, 213, 33, 14);
		frame.getContentPane().add(lblJobs);
		
		lblSun = new JLabel("Sun");
		lblSun.setBounds(350, 213, 33, 14);
		frame.getContentPane().add(lblSun);
		
		lblMaxhrs = new JLabel("maxHrs");
		lblMaxhrs.setBounds(280, 213, 56, 14);
		frame.getContentPane().add(lblMaxhrs);
		
		lblSat = new JLabel("Sat");
		lblSat.setBounds(734, 213, 33, 14);
		frame.getContentPane().add(lblSat);
		
		lblFri = new JLabel("Fri");
		lblFri.setBounds(674, 213, 33, 14);
		frame.getContentPane().add(lblFri);
		
		lblThurs = new JLabel("Thurs");
		lblThurs.setBounds(606, 213, 33, 14);
		frame.getContentPane().add(lblThurs);
		
		lblWed = new JLabel("Wed");
		lblWed.setBounds(542, 213, 33, 14);
		frame.getContentPane().add(lblWed);
		
		lblTues = new JLabel("Tues");
		lblTues.setBounds(478, 213, 33, 14);
		frame.getContentPane().add(lblTues);
		
		lblMon = new JLabel("Mon");
		lblMon.setBounds(414, 213, 33, 14);
		frame.getContentPane().add(lblMon);
		
		editEmployeeButton = new JButton("Edit Employee");
		editEmployeeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String sql="";
				if(!editEmpID.getText().equals("")){	//check that an ID is given		
					if(!editEmpFName.getText().equals("")){ //if a first name is given, add the correct code to change
						if(sql!="")							//the syntax of the sql statement to change the first name
							sql+=",";						//I do this for ever relevant text field
						sql+="firstName=";
						sql+="'"+editEmpFName.getText()+"'";
					}
					if(!editEmpLName.getText().equals("")){
						if(sql!="")
							sql+=",";
						sql+="lastName=";
						sql+="'"+editEmpLName.getText()+"'";
					}
					if(!editEmpJobs.getText().equals("")){
						if(sql!="")
							sql+=",";
						sql+="jobs=";
						sql+="'"+editEmpJobs.getText()+"'";
					}
					if(!editEmpMin.getText().equals("")){
						if(sql!="")
							sql+=",";
						sql+="minHours=";
						sql+=editEmpMin.getText();
					}
					if(!editEmpMax.getText().equals("")){
						if(sql!="")
							sql+=",";
						sql+="maxHours=";
						sql+=editEmpMax.getText();
					}
					if(!editEmpSun.getText().equals("")){
						if(sql!="")
							sql+=",";
						sql+="sun=";
						sql+="'"+editEmpSun.getText()+"'";
					}
					if(!editEmpMon.getText().equals("")){
						if(sql!="")
							sql+=",";
						sql+="mon=";
						sql+="'"+editEmpMon.getText()+"'";
					}
					if(!editEmpTues.getText().equals("")){
						if(sql!="")
							sql+=",";
						sql+="tue=";
						sql+="'"+editEmpTues.getText()+"'";
					}
					if(!editEmpWed.getText().equals("")){
						if(sql!="")
							sql+=",";
						sql+="wed=";
						sql+="'"+editEmpWed.getText()+"'";
					}
					if(!editEmpThurs.getText().equals("")){
						if(sql!="")
							sql+=",";
						sql+="thu=";
						sql+="'"+editEmpThurs.getText()+"'";
					}
					if(!editEmpFri.getText().equals("")){
						if(sql!="")
							sql+=",";
						sql+="fri=";
						sql+="'"+editEmpFri.getText()+"'";
					}
					if(!editEmpSat.getText().equals("")){
						if(sql!="")
							sql+=",";
						sql+="sat=";
						sql+="'"+editEmpSat.getText()+"'";
					}
					
					try{	//execute sql statment
						sql="update employees set "+sql+" where employeeID="+editEmpID.getText();
						System.out.println(sql);
						myStmt.executeUpdate(sql);
						myRs = myStmt.executeQuery("select employeeID, firstName, lastName, jobs, minHours, maxHours from employees");
						employeesTable.setModel(DbUtils.resultSetToTableModel(myRs));
					}catch (Exception exc){
						System.out.println(exc);
					}
					
					//clear relevant text fields
					editEmpID.setText("");
					editEmpFName.setText("");
					editEmpLName.setText("");
					editEmpJobs.setText("");
					editEmpMin.setText("");
					editEmpMax.setText("");
					editEmpSun.setText("");
					editEmpMon.setText("");
					editEmpTues.setText("");
					editEmpWed.setText("");
					editEmpThurs.setText("");
					editEmpFri.setText("");
					editEmpSat.setText("");
				}
			}
		});
		editEmployeeButton.setBounds(10, 268, 110, 23);
		frame.getContentPane().add(editEmployeeButton);
		
		editEmpFName = new JTextField();
		editEmpFName.setColumns(10);
		editEmpFName.setBounds(20, 319, 50, 20);
		frame.getContentPane().add(editEmpFName);
		
		editEmpLName = new JTextField();
		editEmpLName.setColumns(10);
		editEmpLName.setBounds(84, 319, 50, 20);
		frame.getContentPane().add(editEmpLName);
		
		editEmpJobs = new JTextField();
		editEmpJobs.setColumns(10);
		editEmpJobs.setBounds(148, 319, 50, 20);
		frame.getContentPane().add(editEmpJobs);
		
		editEmpMin = new JTextField();
		editEmpMin.setColumns(10);
		editEmpMin.setBounds(212, 319, 50, 20);
		frame.getContentPane().add(editEmpMin);
		
		editEmpMax = new JTextField();
		editEmpMax.setColumns(10);
		editEmpMax.setBounds(276, 319, 50, 20);
		frame.getContentPane().add(editEmpMax);
		
		editEmpSun = new JTextField();
		editEmpSun.setColumns(10);
		editEmpSun.setBounds(340, 319, 50, 20);
		frame.getContentPane().add(editEmpSun);
		
		editEmpTues = new JTextField();
		editEmpTues.setColumns(10);
		editEmpTues.setBounds(468, 319, 50, 20);
		frame.getContentPane().add(editEmpTues);
		
		editEmpWed = new JTextField();
		editEmpWed.setColumns(10);
		editEmpWed.setBounds(532, 319, 50, 20);
		frame.getContentPane().add(editEmpWed);
		
		editEmpThurs = new JTextField();
		editEmpThurs.setColumns(10);
		editEmpThurs.setBounds(596, 319, 50, 20);
		frame.getContentPane().add(editEmpThurs);
		
		editEmpFri = new JTextField();
		editEmpFri.setColumns(10);
		editEmpFri.setBounds(660, 319, 50, 20);
		frame.getContentPane().add(editEmpFri);
		
		editEmpMon = new JTextField();
		editEmpMon.setColumns(10);
		editEmpMon.setBounds(404, 319, 50, 20);
		frame.getContentPane().add(editEmpMon);
		
		editEmpSat = new JTextField();
		editEmpSat.setColumns(10);
		editEmpSat.setBounds(724, 319, 50, 20);
		frame.getContentPane().add(editEmpSat);
		
		label = new JLabel("FName");
		label.setBounds(30, 302, 60, 14);
		frame.getContentPane().add(label);
		
		label_1 = new JLabel("LName");
		label_1.setBounds(90, 302, 44, 14);
		frame.getContentPane().add(label_1);
		
		label_2 = new JLabel("minHrs");
		label_2.setBounds(212, 302, 50, 14);
		frame.getContentPane().add(label_2);
		
		label_3 = new JLabel("Jobs");
		label_3.setBounds(158, 302, 33, 14);
		frame.getContentPane().add(label_3);
		
		label_4 = new JLabel("Sun");
		label_4.setBounds(350, 302, 33, 14);
		frame.getContentPane().add(label_4);
		
		label_5 = new JLabel("maxHrs");
		label_5.setBounds(280, 302, 56, 14);
		frame.getContentPane().add(label_5);
		
		label_6 = new JLabel("Sat");
		label_6.setBounds(734, 302, 33, 14);
		frame.getContentPane().add(label_6);
		
		label_7 = new JLabel("Fri");
		label_7.setBounds(674, 302, 33, 14);
		frame.getContentPane().add(label_7);
		
		label_8 = new JLabel("Thurs");
		label_8.setBounds(606, 302, 33, 14);
		frame.getContentPane().add(label_8);
		
		label_9 = new JLabel("Wed");
		label_9.setBounds(542, 302, 33, 14);
		frame.getContentPane().add(label_9);
		
		label_10 = new JLabel("Tues");
		label_10.setBounds(478, 302, 33, 14);
		frame.getContentPane().add(label_10);
		
		label_11 = new JLabel("Mon");
		label_11.setBounds(414, 302, 33, 14);
		frame.getContentPane().add(label_11);
		
		editEmpID = new JTextField();
		editEmpID.setBounds(153, 269, 34, 20);
		frame.getContentPane().add(editEmpID);
		editEmpID.setColumns(10);
		
		lblId = new JLabel("ID:");
		lblId.setBounds(135, 272, 20, 14);
		frame.getContentPane().add(lblId);
		
		label_12 = new JLabel("ID:");
		label_12.setBounds(130, 182, 20, 14);
		frame.getContentPane().add(label_12);
		
		addEmpID = new JTextField();
		addEmpID.setColumns(10);
		addEmpID.setBounds(148, 179, 34, 20);
		frame.getContentPane().add(addEmpID);
		
		JButton btnLoadAvailability = new JButton("Load Availability");
		btnLoadAvailability.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					myRs = myStmt.executeQuery("select employeeID as 'ID', lastName, sun, mon, tue, wed, thu, fri, sat from employees");
					employeesTable.setModel(DbUtils.resultSetToTableModel(myRs));
				}catch (Exception e){
					System.out.println(e);
				}
			}
		});
		btnLoadAvailability.setBounds(656, 42, 128, 20);
		frame.getContentPane().add(btnLoadAvailability);
	}
}
