package proj;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ViewSenators {

	private JFrame frame;
	private JTable table;
	private String ary[][];

	/**
	 * Launch the application.
	 */
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewSenators window = new ViewSenators();
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
	public ViewSenators() {
		initialize();
	}

	
	// TODO: Finish class, details below
	// JTable params are JTable(columnNames[], data[][]). column[] names are already done.
	// items in senators<> array list need to be converted to a 2d Array.
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Home home = new Home();
		int size = home.senators.size();
		String[] colNames = {"Name", "Absence Points", "N-Number", "Committee"};
		String data[][] = new String[size][4];
		
		System.out.println(size);
		
		for(int i = 0; i < size; i++) {
			for (int j = 0; j < 4; j++) {
				if (j == 0) {
					data[i][j] = home.senators.get(i).getName();
				}
				else if (j == 1) {
					data[i][j] = Integer.toString(home.senators.get(i).getAbPoints());
				}
				else if (j == 2) {
					data[i][j] = home.senators.get(i).getnNum();
				}
				else {
					data[i][j] = home.senators.get(i).getCommittee();
				}
			}
		}
			
	
		for (int a = 0; a < size; a++) {
			for (int b = 0; b < 4; b++) {
				System.out.print(data[a][b] + " ");
			}
			System.out.println();
		}
	
		frame = new JFrame();
		frame.setBounds(100, 100, 496, 514);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 482, 477);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable(data, colNames);
		scrollPane.setViewportView(table);
		
		
	}
}
