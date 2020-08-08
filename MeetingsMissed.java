package proj;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class MeetingsMissed {

	private JFrame frame;
	private JTextField textField;
	private JTable table;
	private JScrollPane scrollPane;
	private String gName;
	private JTable table_1;
	private JTable table_2;
	private JScrollPane scrollPane_1;
	public static String mmData[][] = new String[20][1];

	/**
	 * Launch the application.
	 */
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MeetingsMissed window = new MeetingsMissed();
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
	public MeetingsMissed() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter a name to view meetings missed");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(-10, 22, 436, 13);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(117, 70, 96, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		
		
		Home home = new Home();
		int size = home.senators.size();
		String[] colName = {"Meetings Missed"};
		
		
		// Set everything in the array to an empty string to avoid nulls
		for (int i = 0; i < mmData.length; i++) {
			for (int j = 0; j < mmData[i].length; j++) {
				mmData[i][j] = "";
			}
		}
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//table.setVisible(true);
				//Find the name of the senator and meetings missed into data array
				gName = textField.getText();
				for (int i = 0; i < size; i++) {
					if (home.senators.get(i).getName().equalsIgnoreCase(gName)) {
						for (int j = 0; j < home.senators.get(i).meetingsMissed.size(); j++) {
							String temp = home.senators.get(i).meetingsMissed.get(j);
							mmData[j][0] = temp;
						}
					}
				}
				
				// Show whats inside data
				for (int i = 0; i < mmData.length; i++) {
					for (int j = 0; j < mmData[i].length; j++) {
						System.out.println("Values at arr["+i+"]["+j+"] is "+ mmData[i][j]);;
					}
				}
				
				MMList mm = null; 
				mm.NewScreen();

			}
		});
		btnNewButton.setBounds(223, 69, 85, 21);
		frame.getContentPane().add(btnNewButton);
		
		// NOTE: this is fixable by creating a new page
		
//		scrollPane_1 = new JScrollPane();
//		scrollPane_1.setBounds(117, 205, 191, -68);
//		frame.getContentPane().add(scrollPane_1);
//		
//		table_2 = new JTable(data, colName);
//		scrollPane_1.setViewportView(table_2);
				
			
		

	}
}
