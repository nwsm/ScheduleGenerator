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
	private void initialize(final Statement myStmt) {
		frame = new JFrame();
		frame.setBounds(100, 100, 627, 432);
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
					myRs = myStmt.executeQuery("select * from employees");
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
	}
}
