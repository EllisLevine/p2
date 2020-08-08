package proj;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PointAdder {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PointAdder window = new PointAdder();
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
	public PointAdder() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 396);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter a name to add a point");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(49, 44, 194, 13);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(49, 88, 173, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Successfully Added Absense Point To");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_1.setBounds(43, 276, 256, 13);
		frame.getContentPane().add(lblNewLabel_1);
		lblNewLabel_1.setVisible(false);
		
		JLabel lblNewLabel_2 = new JLabel("Successfully Added Absense Points To");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_2.setBounds(43, 276, 256, 13);
		frame.getContentPane().add(lblNewLabel_2);
		lblNewLabel_2.setVisible(false);
		
		JLabel nameLabel = new JLabel("");
		nameLabel.setBounds(276, 276, 122, 13);
		frame.getContentPane().add(nameLabel);
		lblNewLabel_2.setVisible(false);
		
		JLabel lblEnterTheMeeting = new JLabel("Enter the meeting missed");
		lblEnterTheMeeting.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEnterTheMeeting.setBounds(49, 131, 194, 13);
		frame.getContentPane().add(lblEnterTheMeeting);
		
		textField_1 = new JTextField();
		textField_1.setBounds(49, 170, 96, 19);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		
		JButton btnNewButton = new JButton("Add 1 Point");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel_2.setVisible(false);
				//nameLabel.setVisible(false);
				Home home = new Home();
				String name = textField.getText();
				Boolean found = false;
				for (int i = 0; i < home.senators.size(); i++) {
					if (name.equalsIgnoreCase(home.senators.get(i).getName())) {
						System.out.println("found" + name);
						home.senators.get(i).addPoint();
						home.senators.get(i).addPoint();
						home.senators.get(i).meetingsMissed.add(textField_1.getText());
						found = true;
					}
				}
				if (found) {
					lblNewLabel_1.setVisible(true);
					nameLabel.setText(name);
					nameLabel.setVisible(true);
				}
				else {
					nameLabel.setVisible(false);
					lblNewLabel_1.setText("Senator not found");
					lblNewLabel_1.setVisible(true);
				}
			}
		});
		btnNewButton.setBounds(49, 220, 122, 21);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Add 2 Points");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel_1.setVisible(false);
				//nameLabel.setVisible(false);
				Home home = new Home();
				String name = textField.getText();
				Boolean found = false;
				for (int i = 0; i < home.senators.size(); i++) {
					if (name.equalsIgnoreCase(home.senators.get(i).getName())) {
						System.out.println("found" + name);
						home.senators.get(i).addPoint();
						home.senators.get(i).meetingsMissed.add(textField_1.getText());
						found = true;
					}
				}
				if (found) {
					lblNewLabel_2.setVisible(true);
					nameLabel.setText(name);
					nameLabel.setVisible(true);
				}
				else {
					nameLabel.setVisible(false);
					lblNewLabel_2.setText("Senator not found");
					lblNewLabel_2.setVisible(true);
				}
			}
	
		});
		btnNewButton_1.setBounds(201, 220, 122, 21);
		frame.getContentPane().add(btnNewButton_1);
		
		
		
		
	}
}
