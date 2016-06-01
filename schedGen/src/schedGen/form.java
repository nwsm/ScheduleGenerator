package schedGen;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSlider;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class form {
	
	private JFrame frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					form window = new form();
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
	public form() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton editEmpButton = new JButton("Edit Employees");
		editEmpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		editEmpButton.setBounds(0, 10, 444, 40);
		editEmpButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				editEmployees form2 = new editEmployees();
				String[] str=null;
				form2.main(str);
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(editEmpButton);
		
		JButton editShiftsButton = new JButton("Edit Shifts");
		editShiftsButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				editShifts form3 = new editShifts();
				String[] str=null;
				form3.main(str);
				
			}
		});
		editShiftsButton.setBounds(0, 100, 444, 40);
		frame.getContentPane().add(editShiftsButton);
		
		JButton calcShiftsButton = new JButton("Calculate Shifts");
		calcShiftsButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				calcShifts form4 = new calcShifts();
				String[] str=null;
				form4.main(str);
			}
		});
		calcShiftsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		calcShiftsButton.setBounds(0, 194, 444, 40);
		frame.getContentPane().add(calcShiftsButton);
	}
}
