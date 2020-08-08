package proj;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.text.DefaultCaret;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Home extends JFrame{

	private JFrame frame;
	public static ArrayList<Senator> senators = new ArrayList<Senator>();

	/**
	 * Launch the application.
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Scanner reader = new Scanner(System.in);
		parseFile("senators.csv", reader);
		parseFileMM("meetingsMissed.csv", reader);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		Runtime.getRuntime().addShutdownHook(new Thread() {
	        public void run(){
	        	SaveSenatorsList(senators);
	        	saveMeetingsMissed(senators);
	        }
	    });
	}

	/**
	 * Create the application.
	 */
	public Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 529, 492);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		JLabel lblNewLabel = new JLabel("Student Government Attendence Tracker");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 40, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 0, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel, -388, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, 515, SpringLayout.WEST, frame.getContentPane());
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Created by Ellis Levine");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 8, SpringLayout.SOUTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_1, 193, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, -367, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_1, 349, SpringLayout.WEST, frame.getContentPane());
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("View Senators");
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 123, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton, 58, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton, -111, SpringLayout.SOUTH, frame.getContentPane());
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewSenators vs = null;
				vs.NewScreen();
				
			}
		});
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Add Absense Point");
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton, -57, SpringLayout.WEST, btnNewButton_1);
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_1, 63, SpringLayout.SOUTH, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_1, 288, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton_1, -323, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_1, -258, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Remove Absense Point ");
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_2, 164, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_2, 0, SpringLayout.WEST, btnNewButton_1);
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton_2, -264, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_2, -17, SpringLayout.EAST, btnNewButton_1);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_5 = new JButton("List Options");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListOptions lo = null;
				lo.NewScreen();
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_5, 370, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton_5, -64, SpringLayout.SOUTH, frame.getContentPane());
		frame.getContentPane().add(btnNewButton_5);
		
		JButton btnNewButton_7 = new JButton("Add Absence Point");
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_7, 243, SpringLayout.NORTH, frame.getContentPane());
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PointAdder pa = null;
				pa.NewScreen();
			}
		});
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_5, 0, SpringLayout.WEST, btnNewButton_7);
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_5, 161, SpringLayout.WEST, btnNewButton_7);
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_7, 27, SpringLayout.EAST, btnNewButton);
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton_7, 84, SpringLayout.SOUTH, btnNewButton_2);
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_7, 215, SpringLayout.EAST, btnNewButton);
		frame.getContentPane().add(btnNewButton_7);
		
		JButton btnNewButton_7_1 = new JButton("Remove Absence Point");
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_7_1, 301, SpringLayout.NORTH, frame.getContentPane());
		btnNewButton_7_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PointDeleter pd = null;
				pd.NewScreen();
			}
		});
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_7_1, 0, SpringLayout.WEST, btnNewButton_7);
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton_7_1, 58, SpringLayout.SOUTH, btnNewButton_7);
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_7_1, 0, SpringLayout.EAST, btnNewButton_7);
		frame.getContentPane().add(btnNewButton_7_1);
		
		JButton btnNewButton_7_2 = new JButton("Add Senator");
		btnNewButton_7_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddSenator as = null;
				as.NewScreen();
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_7_2, 0, SpringLayout.SOUTH, btnNewButton_1);
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_7_2, 0, SpringLayout.WEST, btnNewButton_7);
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton_7_2, 0, SpringLayout.NORTH, btnNewButton_2);
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_7_2, 0, SpringLayout.EAST, btnNewButton_7);
		frame.getContentPane().add(btnNewButton_7_2);
		
		JButton btnNewButton_7_3 = new JButton("Remove Senator");
		btnNewButton_7_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteSenator ds = null;
				ds.NewScreen();
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_7_3, 23, SpringLayout.SOUTH, btnNewButton_7_2);
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_7_3, 0, SpringLayout.WEST, btnNewButton_5);
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton_7_3, -24, SpringLayout.NORTH, btnNewButton_7);
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_7_3, 0, SpringLayout.EAST, btnNewButton_7);
		frame.getContentPane().add(btnNewButton_7_3);
		
		JButton btnNewButton_3 = new JButton("View Meetings Missed");
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_3, 0, SpringLayout.NORTH, btnNewButton_5);
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_3, 80, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_3, -27, SpringLayout.WEST, btnNewButton_5);
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MeetingsMissed mm = null;
				mm.NewScreen();
			}
		});
		frame.getContentPane().add(btnNewButton_3);
	}
	
	public static void parseFile(String fileName, Scanner reader) throws FileNotFoundException, IOException {
		File inputFile = new File(fileName);
		if(inputFile.exists()) {
			System.out.println("parseFile Method: file exists");
			try(Scanner fileScan = new Scanner(inputFile)) {
				int line = 1;
				try {
					fileScan.useDelimiter(System.lineSeparator());
					boolean firstLine = true;
					while(fileScan.hasNext()) {
						
						String fileLine = ""; 
						if(firstLine) { 	//Skip first line
							fileLine = fileScan.next();
							firstLine = false;
						}
						fileLine = fileScan.next();
						String[] fileLineAry = fileLine.split(",");
						
						int abPoints = Integer.parseInt(fileLineAry[1]);
						
						Senator sen = new Senator();
						sen.setName(fileLineAry[0]);
						sen.setAbPoints(abPoints);
						sen.setnNum(fileLineAry[2]);
						sen.setCommittee(fileLineAry[3]);
						
						senators.add(sen);
						
					}
				} catch (Exception e) {
					System.out.println(e);
				}	
			}
		}
	}

	private static void parseFileMM(String fileName, Scanner reader) throws FileNotFoundException, NumberFormatException {
		System.out.println("PARSE IS OPEN");
		File inputFile = new File(fileName); 
		if (inputFile.exists()) {
			System.out.println("MM File Exists");
			try (Scanner fileScan = new Scanner(inputFile)) {
				int line = 1;
				try {
					fileScan.useDelimiter(System.lineSeparator());
					boolean firstLine = true;
					while(fileScan.hasNext()) {	
						String fileLine = ""; 
						if(firstLine) { 	//Skip first line
							fileLine = fileScan.next();
							firstLine = false;
						}
						fileLine = fileScan.next();
						String[] fileLineAry = fileLine.split(",");
						
						// Find the Senator that matches the firsts column and then add meetings missed until line runs out.
						for (int i = 0; i < senators.size(); i++) {
							if (senators.get(i).getName().equals(fileLineAry[0])) {
								System.out.println("it happend");
								System.out.println("Length of fileline } " + fileLineAry.length);
								for (int j = 1; j < fileLineAry.length; j++) {
									System.out.print(j + " ");
									senators.get(i).meetingsMissed.add(fileLineAry[j]);
								}
							}
						}
					
					}
				} catch (Exception e) {
					System.out.println("something went wroong " + e);
				}
			}
		}
		for (int i = 0; i < senators.size(); i++) {
			System.out.println(senators.get(i).getName());
			for (int j = 0; j < senators.get(i).meetingsMissed.size(); j++) {
				System.out.println(senators.get(i).meetingsMissed.get(j));
			}
		}
	}
	
	
	private static void SaveSenatorsList(ArrayList<Senator> senatorList){
		
		String fileName = "senators.csv";
		try
		{
			FileWriter fw = new FileWriter(fileName);
			try(PrintWriter pw = new PrintWriter(fw))
			{
				pw.println("Senator Name,Absence Points,Nnumber,Committee");
				for(int i =0; i < senatorList.size();i++)
				{
					Senator curr = senators.get(i);
					pw.println(curr.getName()+","+curr.getAbPoints()+","+curr.getnNum()+","+curr.getCommittee());
				}
			}
		}
		catch(Exception ex)
		{
			System.out.println("Error Writing to File: "+ ex.getMessage());
		}
	}
	
	//todo: problem with save
	
	// Saving to the file is working
	private static void saveMeetingsMissed(ArrayList<Senator> senatorList) {
		
		for (int i = 0; i < senators.size(); i++) {
			System.out.println(senators.get(i).getName());
			for (int j = 0; j < senators.get(i).meetingsMissed.size(); j++) {
				System.out.println(senators.get(i).meetingsMissed.get(j));
			}
		}
		
		String fileName = "meetingsMissed.csv";
		try
		{
			FileWriter fw = new FileWriter(fileName);
			try(PrintWriter pw = new PrintWriter(fw))
			{
				pw.println("Senator Name, Meetings Missed"); 
				for (int i = 0; i < senatorList.size(); i++) {
					Senator curr = senators.get(i);
					pw.print(curr.getName()+",");
					for (int j = 0; j < senators.get(i).meetingsMissed.size(); j++) {
						if (j == 0) {
							pw.print(senators.get(i).meetingsMissed.get(j));
						}
						else {
							pw.print(","+senators.get(i).meetingsMissed.get(j));
						}
					}
					pw.println(); 
				}
			}
		}
		catch(Exception ex)
		{
			System.out.println("Error Writing to File: "+ ex.getMessage());
		}
		
	}
	

	
}
