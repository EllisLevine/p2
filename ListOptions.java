package proj;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.awt.event.ActionEvent;

public class ListOptions extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListOptions frame = new ListOptions();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public ListOptions() {
		initialize();
	}

	/**
	 * Create the frame.
	 */
	public void initialize() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 427, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Done! : )");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 282, 393, 20);
		lblNewLabel_1.setVisible(false);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Sort by Name");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home home = new Home();
				for (int i = 0; i < home.senators.size() - 1; i++) {
					for (int j = 0; j < home.senators.size() - i - 1; j++) {
						if (home.senators.get(j).getName().compareTo(home.senators.get(j+1).getName()) > 0) {
							Collections.swap(home.senators, j, j + 1);
						}
					}
				}
				lblNewLabel_1.setVisible(true);
			}
		});
		btnNewButton.setBounds(10, 82, 393, 28);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Sort by Committee");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home home = new Home();
				for (int i = 0; i < home.senators.size() - 1; i++) {
					for (int j = 0; j < home.senators.size() - i - 1; j++) {
						if (home.senators.get(j).getCommittee().compareTo(home.senators.get(j+1).getCommittee()) > 0) {
							Collections.swap(home.senators, j, j + 1);
						}
					}
				}
				lblNewLabel_1.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(10, 131, 393, 28);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Sort by most Absence Points");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home home = new Home();
				for (int i = 0; i < home.senators.size() - 1; i++) {
					for (int j = 0; j < home.senators.size() - i - 1; j++) {
						if (home.senators.get(j).getAbPoints() < home.senators.get(j+1).getAbPoints()) {
							Collections.swap(home.senators, j, j + 1);
						}
					}
				}
				lblNewLabel_1.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(10, 181, 393, 28);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Delete All Data");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home home = new Home();
				for (int i = 0; i < home.senators.size() - 1; i++) {
					home.senators.remove(i);
				}
				lblNewLabel_1.setVisible(true);
			}	
		});
		btnNewButton_3.setBounds(10, 231, 393, 28);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel = new JLabel("List Options");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 25, 393, 28);
		contentPane.add(lblNewLabel);
		
		
	}
}
