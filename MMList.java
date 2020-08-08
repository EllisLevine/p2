package proj;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MMList {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MMList window = new MMList();
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
	public MMList() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		String colNames[] = {"Meetings Missed"};
		
		frame = new JFrame();
		frame.setBounds(100, 100, 496, 514);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 482, 477);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable(MeetingsMissed.mmData, colNames);
		scrollPane.setViewportView(table);
	}

}
