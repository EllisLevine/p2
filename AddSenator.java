package proj;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddSenator {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddSenator window = new AddSenator();
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
	public AddSenator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 350, 356);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add a New Senator");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(0, 46, 336, 13);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(141, 91, 144, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setBounds(61, 94, 70, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Committee:");
		lblNewLabel_2.setBounds(61, 168, 70, 13);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(141, 165, 144, 19);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("N Number:");
		lblNewLabel_3.setBounds(61, 132, 70, 13);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Senator Successfully Added!");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_4.setBounds(70, 257, 193, 13);
		frame.getContentPane().add(lblNewLabel_4);
		lblNewLabel_4.setVisible(false);
		
		textField_2 = new JTextField();
		textField_2.setBounds(141, 129, 144, 19);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home home = new Home();
				String name = textField.getText();
				String committee = textField_1.getText();
				String nNumber = textField_2.getText();
				Senator temp = new Senator();
				temp.setName(name);
				temp.setnNum(nNumber);
				temp.setCommittee(committee);
				home.senators.add(temp);
				lblNewLabel_4.setVisible(true);
				System.out.println("Senator List");
				for (int i = 0; i < home.senators.size(); i++) {
					System.out.println("Senator " + home.senators.get(i).getName());
					System.out.println("Absense points " + home.senators.get(i).getAbPoints());
				}
				
			}
		});
		btnNewButton.setBounds(119, 210, 85, 21);
		frame.getContentPane().add(btnNewButton);
		
		
		
		
		
	}
}
