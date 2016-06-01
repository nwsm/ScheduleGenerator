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

public class editEmployees {

	private JFrame frame;
	private JTable employeesTable;

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
	
	
	
	
	
	public editEmployees() {
		try{
			connection=DriverManager.getConnection(url + dbName, userName, password);
			Statement myStmt = connection.createStatement();
			ResultSet myRs = myStmt.executeQuery("select * from employees");
			initialize(myRs);
		}catch (Exception exc){
			System.out.println("no goood meester coke");
		}
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(final ResultSet myRs) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 157);
		frame.getContentPane().add(scrollPane);
		
		employeesTable = new JTable();
		scrollPane.setViewportView(employeesTable);
		
		JButton loadDataButton = new JButton("Load Data");
		loadDataButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				employeesTable.setModel(DbUtils.resultSetToTableModel(myRs));
				
			}
		});
		loadDataButton.setBounds(90, 194, 138, 23);
		frame.getContentPane().add(loadDataButton);
	}
}
