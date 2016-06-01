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
		frame.setBounds(100, 100, 675, 432);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 157);
		frame.getContentPane().add(scrollPane);
		
		employeesTable = new JTable();
		scrollPane.setViewportView(employeesTable);
		
		JButton loadDataButton = new JButton("Load Employees");
		loadDataButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					myRs = myStmt.executeQuery("select employeeID, firstName, lastName, jobs, minHours, maxHours from employees");
					employeesTable.setModel(DbUtils.resultSetToTableModel(myRs));
				}catch (Exception e){
					System.out.println(e);
				}
			}
		});
		loadDataButton.setBounds(434, 27, 167, 33);
		frame.getContentPane().add(loadDataButton);
		
		deleteID = new JTextField();
		deleteID.setBounds(515, 148, 86, 20);
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
			}
		});
		deleteEmployeeButton.setBounds(434, 114, 167, 23);
		frame.getContentPane().add(deleteEmployeeButton);
		
		JLabel lblNewLabel = new JLabel("Delete ID:");
		lblNewLabel.setBounds(458, 151, 61, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JButton addEmployeeButton = new JButton("Add Employee");
		addEmployeeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){ //the following is a shitshow
				if(addEmpFName.getText()!=""&&addEmpLName.getText()!=""&&addEmpJobs.getText()!=""
						&&addEmpMin.getText()!=""&&addEmpMax.getText()!=""&&addEmpSun.getText()!=""
						&&addEmpMon.getText()!=""&&addEmpTues.getText()!=""&&addEmpWed.getText()!=""
						&&addEmpThurs.getText()!=""&&addEmpFri.getText()!=""&&addEmpSat.getText()!="")
						System.out.println("hi");
						String str=addEmpID.getText()+",'"+addEmpFName.getText()+"','"+addEmpLName.getText()+"','"+addEmpJobs.getText()+"',"
								+addEmpMin.getText()+","+addEmpMax.getText()+",'"+addEmpSun.getText()+"','"
								+addEmpMon.getText()+"','"+addEmpTues.getText()+"','"+addEmpWed.getText()+"','"
								+addEmpThurs.getText()+"','"+addEmpFri.getText()+"','"+addEmpSat.getText()+"'";
						try{
							System.out.println("insert into employees values("+str+")");
						myStmt.executeUpdate("insert into employees values("+str+")");
						
						//myStmt.executeUpdate("insert into employees values(15,'A','B','0110',10,20,'hi','hi','hi','hi','hi','hi','hi')");
						}catch (Exception exc){
							System.out.print(exc);
						}
			}
		});
		addEmployeeButton.setBounds(10, 179, 110, 23);
		frame.getContentPane().add(addEmployeeButton);
		
		addEmpFName = new JTextField();
		addEmpFName.setBounds(11, 230, 44, 20);
		frame.getContentPane().add(addEmpFName);
		addEmpFName.setColumns(10);
		
		addEmpLName = new JTextField();
		addEmpLName.setBounds(65, 230, 44, 20);
		frame.getContentPane().add(addEmpLName);
		addEmpLName.setColumns(10);
		
		addEmpJobs = new JTextField();
		addEmpJobs.setColumns(10);
		addEmpJobs.setBounds(119, 230, 44, 20);
		frame.getContentPane().add(addEmpJobs);
		
		addEmpMin = new JTextField();
		addEmpMin.setColumns(10);
		addEmpMin.setBounds(173, 230, 44, 20);
		frame.getContentPane().add(addEmpMin);
		
		addEmpMax = new JTextField();
		addEmpMax.setColumns(10);
		addEmpMax.setBounds(227, 230, 44, 20);
		frame.getContentPane().add(addEmpMax);
		
		addEmpSun = new JTextField();
		addEmpSun.setColumns(10);
		addEmpSun.setBounds(281, 230, 44, 20);
		frame.getContentPane().add(addEmpSun);
		
		addEmpTues = new JTextField();
		addEmpTues.setColumns(10);
		addEmpTues.setBounds(389, 230, 44, 20);
		frame.getContentPane().add(addEmpTues);
		
		addEmpWed = new JTextField();
		addEmpWed.setColumns(10);
		addEmpWed.setBounds(443, 230, 44, 20);
		frame.getContentPane().add(addEmpWed);
		
		addEmpThurs = new JTextField();
		addEmpThurs.setColumns(10);
		addEmpThurs.setBounds(497, 230, 44, 20);
		frame.getContentPane().add(addEmpThurs);
		
		addEmpFri = new JTextField();
		addEmpFri.setColumns(10);
		addEmpFri.setBounds(551, 230, 44, 20);
		frame.getContentPane().add(addEmpFri);
		
		addEmpMon = new JTextField();
		addEmpMon.setColumns(10);
		addEmpMon.setBounds(335, 230, 44, 20);
		frame.getContentPane().add(addEmpMon);
		
		addEmpSat = new JTextField();
		addEmpSat.setColumns(10);
		addEmpSat.setBounds(605, 230, 44, 20);
		frame.getContentPane().add(addEmpSat);
		
		lblFname = new JLabel("FName");
		lblFname.setBounds(18, 213, 33, 14);
		frame.getContentPane().add(lblFname);
		
		lblLname = new JLabel("LName");
		lblLname.setBounds(72, 213, 33, 14);
		frame.getContentPane().add(lblLname);
		
		lblMinhrs = new JLabel("minHrs");
		lblMinhrs.setBounds(180, 213, 33, 14);
		frame.getContentPane().add(lblMinhrs);
		
		lblJobs = new JLabel("Jobs");
		lblJobs.setBounds(128, 213, 33, 14);
		frame.getContentPane().add(lblJobs);
		
		lblSun = new JLabel("Sun");
		lblSun.setBounds(293, 213, 33, 14);
		frame.getContentPane().add(lblSun);
		
		lblMaxhrs = new JLabel("maxHrs");
		lblMaxhrs.setBounds(230, 213, 44, 14);
		frame.getContentPane().add(lblMaxhrs);
		
		lblSat = new JLabel("Sat");
		lblSat.setBounds(617, 213, 33, 14);
		frame.getContentPane().add(lblSat);
		
		lblFri = new JLabel("Fri");
		lblFri.setBounds(565, 213, 33, 14);
		frame.getContentPane().add(lblFri);
		
		lblThurs = new JLabel("Thurs");
		lblThurs.setBounds(503, 213, 33, 14);
		frame.getContentPane().add(lblThurs);
		
		lblWed = new JLabel("Wed");
		lblWed.setBounds(450, 213, 33, 14);
		frame.getContentPane().add(lblWed);
		
		lblTues = new JLabel("Tues");
		lblTues.setBounds(398, 213, 33, 14);
		frame.getContentPane().add(lblTues);
		
		lblMon = new JLabel("Mon");
		lblMon.setBounds(345, 213, 33, 14);
		frame.getContentPane().add(lblMon);
		
		editEmployeeButton = new JButton("Edit Employee");
		editEmployeeButton.setBounds(10, 268, 110, 23);
		frame.getContentPane().add(editEmployeeButton);
		
		editEmpFName = new JTextField();
		editEmpFName.setColumns(10);
		editEmpFName.setBounds(11, 319, 44, 20);
		frame.getContentPane().add(editEmpFName);
		
		editEmpLName = new JTextField();
		editEmpLName.setColumns(10);
		editEmpLName.setBounds(65, 319, 44, 20);
		frame.getContentPane().add(editEmpLName);
		
		editEmpJobs = new JTextField();
		editEmpJobs.setColumns(10);
		editEmpJobs.setBounds(119, 319, 44, 20);
		frame.getContentPane().add(editEmpJobs);
		
		editEmpMin = new JTextField();
		editEmpMin.setColumns(10);
		editEmpMin.setBounds(173, 319, 44, 20);
		frame.getContentPane().add(editEmpMin);
		
		editEmpMax = new JTextField();
		editEmpMax.setColumns(10);
		editEmpMax.setBounds(227, 319, 44, 20);
		frame.getContentPane().add(editEmpMax);
		
		editEmpSun = new JTextField();
		editEmpSun.setColumns(10);
		editEmpSun.setBounds(281, 319, 44, 20);
		frame.getContentPane().add(editEmpSun);
		
		editEmpTues = new JTextField();
		editEmpTues.setColumns(10);
		editEmpTues.setBounds(389, 319, 44, 20);
		frame.getContentPane().add(editEmpTues);
		
		editEmpWed = new JTextField();
		editEmpWed.setColumns(10);
		editEmpWed.setBounds(443, 319, 44, 20);
		frame.getContentPane().add(editEmpWed);
		
		editEmpThurs = new JTextField();
		editEmpThurs.setColumns(10);
		editEmpThurs.setBounds(497, 319, 44, 20);
		frame.getContentPane().add(editEmpThurs);
		
		editEmpFri = new JTextField();
		editEmpFri.setColumns(10);
		editEmpFri.setBounds(551, 319, 44, 20);
		frame.getContentPane().add(editEmpFri);
		
		editEmpMon = new JTextField();
		editEmpMon.setColumns(10);
		editEmpMon.setBounds(335, 319, 44, 20);
		frame.getContentPane().add(editEmpMon);
		
		editEmpSat = new JTextField();
		editEmpSat.setColumns(10);
		editEmpSat.setBounds(605, 319, 44, 20);
		frame.getContentPane().add(editEmpSat);
		
		label = new JLabel("FName");
		label.setBounds(18, 302, 33, 14);
		frame.getContentPane().add(label);
		
		label_1 = new JLabel("LName");
		label_1.setBounds(72, 302, 33, 14);
		frame.getContentPane().add(label_1);
		
		label_2 = new JLabel("minHrs");
		label_2.setBounds(180, 302, 33, 14);
		frame.getContentPane().add(label_2);
		
		label_3 = new JLabel("Jobs");
		label_3.setBounds(128, 302, 33, 14);
		frame.getContentPane().add(label_3);
		
		label_4 = new JLabel("Sun");
		label_4.setBounds(293, 302, 33, 14);
		frame.getContentPane().add(label_4);
		
		label_5 = new JLabel("maxHrs");
		label_5.setBounds(230, 302, 44, 14);
		frame.getContentPane().add(label_5);
		
		label_6 = new JLabel("Sat");
		label_6.setBounds(617, 302, 33, 14);
		frame.getContentPane().add(label_6);
		
		label_7 = new JLabel("Fri");
		label_7.setBounds(565, 302, 33, 14);
		frame.getContentPane().add(label_7);
		
		label_8 = new JLabel("Thurs");
		label_8.setBounds(503, 302, 33, 14);
		frame.getContentPane().add(label_8);
		
		label_9 = new JLabel("Wed");
		label_9.setBounds(450, 302, 33, 14);
		frame.getContentPane().add(label_9);
		
		label_10 = new JLabel("Tues");
		label_10.setBounds(398, 302, 33, 14);
		frame.getContentPane().add(label_10);
		
		label_11 = new JLabel("Mon");
		label_11.setBounds(345, 302, 33, 14);
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
	}
}
