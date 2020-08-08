

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeleteSenator {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteSenator window = new DeleteSenator();
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
	public DeleteSenator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		System.out.println("Test");
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 345);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter a name to delete senator.");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(49, 33, 194, 13);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(49, 100, 173, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Successfully Deleted Senator ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_1.setBounds(43, 205, 256, 13);
		frame.getContentPane().add(lblNewLabel_1);
		lblNewLabel_1.setVisible(false);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(232, 205, 168, 13);
		frame.getContentPane().add(lblNewLabel_2);
		lblNewLabel_2.setVisible(false);
		
		
		// TODO: Test
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home home = new Home();
				String name = textField.getText();
				Boolean found = false;
				for (int i = 0; i < home.senators.size(); i++) {
					if (name.equalsIgnoreCase(home.senators.get(i).getName())) {
						System.out.println("found" + name);
						home.senators.remove(i);
						found = true;
					}
				}
				if (found) {
					lblNewLabel_1.setVisible(true);
					lblNewLabel_2.setText(name);
					lblNewLabel_2.setVisible(true);
				}
				else {
					lblNewLabel_1.setText("Senator not found");
					lblNewLabel_1.setVisible(true);
				}
			}
		});
		btnNewButton.setBounds(89, 151, 85, 21);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNoteThisWill = new JLabel("Note: This will delete all records of the given Senator");
		lblNoteThisWill.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNoteThisWill.setBounds(49, 56, 351, 13);
		frame.getContentPane().add(lblNoteThisWill);
		
		
	}
}
