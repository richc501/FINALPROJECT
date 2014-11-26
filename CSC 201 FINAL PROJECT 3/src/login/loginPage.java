package login;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.StyledDocument;

@SuppressWarnings("serial")
public class loginPage extends JFrame implements ActionListener{
	Date date = new Date();
	JPasswordField jpwPasscode = new JPasswordField();
	JPanel jplControlPanel = new JPanel();
	JPanel jplPinPad = new JPanel(new GridLayout(4,3));
	JPanel jplMessageBoard = new JPanel();
	JPanel jplNorthPanel = new JPanel(new GridLayout(1,2));
	JPanel jplSouthPanel = new JPanel(new GridLayout(1,2));
	JPanel jplTitlePanel = new JPanel();
	JPanel jplGraphicOvals = new JPanel();
	JButton jbtButton0 = new JButton("0");
	JButton jbtButton1 = new JButton("1");
	JButton jbtButton2 = new JButton("2");
	JButton jbtButton3 = new JButton("3");
	JButton jbtButton4 = new JButton("4");
	JButton jbtButton5 = new JButton("5");
	JButton jbtButton6 = new JButton("6");
	JButton jbtButton7 = new JButton("7");
	JButton jbtButton8 = new JButton("8");
	JButton jbtButton9 = new JButton("9");
	JButton jbtClear = new JButton("C");
	JButton jbtNewUser = new JButton("New User");
	JButton jbtExit = new JButton("Exit");
	JLabel jlEpmty = new JLabel(" ");
	JLabel jlTitle = new JLabel(" ");
	Timer timer = new Timer(10000, null);
	motionSensor mouse = new motionSensor();
	JFrame f = new JFrame();
	public loginPage()
	{
		SetTimer();//keeps track of timer
		f.addMouseMotionListener(mouse);
		jplControlPanel.setLayout(new BoxLayout(jplControlPanel, BoxLayout.X_AXIS));
		f.setTitle("Point of Sale System: Login");
		f.setSize(850,500);
		northPanel();
		pinPad();
		messageBoard();
		controlPanel();
		jplSouthPanel.add(jbtNewUser);
		jplSouthPanel.add(jbtExit);
		f.add(jplNorthPanel,BorderLayout.NORTH);
		f.add(jplSouthPanel,BorderLayout.SOUTH);
		f.add(jplControlPanel);
		f.setLocationRelativeTo(null); // makes frame center
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	private void SetTimer() {
		timer = new Timer(25000, new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				timer.stop();
				screenSaver saver = new screenSaver();
			}
		});
		timer.start();
	}
	public void northPanel()
	{
		jlTitle = new JLabel("Station 1 : "+date.toString());
		jplTitlePanel.add(jlTitle);
		jplNorthPanel.setBorder(BorderFactory.createLineBorder(Color.blue));
		jplGraphicOvals.add(new drawOvals());
		jplGraphicOvals.setSize(100,100);
		jplGraphicOvals.setBorder(BorderFactory.createLineBorder(Color.green));
		jplNorthPanel.add(jplTitlePanel);
		jplNorthPanel.add(jpwPasscode);
		jplNorthPanel.setSize(800,450);
		jplNorthPanel.setBorder(BorderFactory.createLineBorder(Color.red));
	}
	public void pinPad()
	{
		addButtons();
		addListeners();
		jplPinPad.setForeground(Color.red);
		jplPinPad.setSize(100,100);
		jplPinPad.setBorder(BorderFactory.createLineBorder(Color.black));
	}
	public void messageBoard()
	{
		ImageIcon image = new ImageIcon("logo.jpg");//makes image
		JLabel jlImage = new JLabel(image);
		jplMessageBoard.setSize(300,300);
		jplMessageBoard.setLayout(new BoxLayout(jplMessageBoard, BoxLayout.Y_AXIS));
		jplMessageBoard.setBorder(BorderFactory.createLineBorder(Color.black));
		jplMessageBoard.add(jlImage);
		jlTitle = new JLabel("  Annoucements");
		Font font = new Font("Impact",Font.BOLD,32);
		jlTitle.setFont(font);
		jplMessageBoard.add(jlTitle);
		JTextArea jtaMessage = new JTextArea(getMessageFromTXT());
		
		jplMessageBoard.add(jtaMessage);
	}
	private String getMessageFromTXT() {
		StringBuilder MOTD = new StringBuilder();
		String message=null;
		try
		{
			Scanner fileReader = new Scanner(new File("MOTD.txt"));
			while(fileReader.hasNextLine())
			{
				MOTD.append("\n"+fileReader.nextLine());
			}
			fileReader.close();
		}catch(FileNotFoundException e){
			System.out.println("File not found");
		}
		message = MOTD.toString();
		return message;
	}
	public void controlPanel()
	{
		jplControlPanel.add(jplMessageBoard,BorderLayout.WEST);
		jplControlPanel.add(jplPinPad,BorderLayout.CENTER);
		jplControlPanel.setSize(800,450);
		jplControlPanel.setBorder(BorderFactory.createRaisedBevelBorder());
	}
	public void addButtons()
	{
		jplPinPad.add(jbtButton1);
		jplPinPad.add(jbtButton2);
		jplPinPad.add(jbtButton3);
		jplPinPad.add(jbtButton4);
		jplPinPad.add(jbtButton5);
		jplPinPad.add(jbtButton6);
		jplPinPad.add(jbtButton7);
		jplPinPad.add(jbtButton8);
		jplPinPad.add(jbtButton9);
		jplPinPad.add(jlEpmty);
		jplPinPad.add(jbtButton0);
		jplPinPad.add(jbtClear);
	}
	public void addListeners()
	{
		authentacation action = new authentacation();
		jbtButton0.addActionListener(this);
		jbtButton1.addActionListener(this);
		jbtButton2.addActionListener(this);
		jbtButton3.addActionListener(this);
		jbtButton4.addActionListener(this);
		jbtButton5.addActionListener(this);
		jbtButton6.addActionListener(this);
		jbtButton7.addActionListener(this);
		jbtButton8.addActionListener(this);
		jbtButton9.addActionListener(this);
		jbtClear.addActionListener(this);
		jbtNewUser.addActionListener(this);
		jbtExit.addActionListener(this);
		jpwPasscode.addCaretListener(action);
	}
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e)
	{
		StringBuilder inputPin = new StringBuilder(jpwPasscode.getText());
		if(e.getSource()==jbtButton1||e.getSource()==jbtButton2||e.getSource()==jbtButton3||e.getSource()==jbtButton4||e.getSource()==jbtButton5||e.getSource()==jbtButton6||e.getSource()==jbtButton7||e.getSource()==jbtButton8||e.getSource()==jbtButton9||e.getSource()==jbtButton0||e.getSource()==jbtClear||e.getSource()==jbtNewUser||e.getSource()==jbtExit)
		{
			if(e.getSource()==jbtClear)
			{
				if(!(jpwPasscode.getText().equals("")))
				{
				String text = jpwPasscode.getText();
				text = text.substring(0,text.length()-1);
				System.out.println(text);
				jpwPasscode.setText(text);
				inputPin = new StringBuilder(text);
				}
				timer.stop();
				screenSaver saver = new screenSaver();
			}
			else if(e.getSource()==jbtNewUser)
			{

				int adminPasscode = Integer.parseInt(JOptionPane.showInputDialog(null,"Insert Admin Passcode"));
				if(isAdmin(adminPasscode))
				{
					newUserAndPasword user = new newUserAndPasword();
				}
				else
					JOptionPane.showMessageDialog(null, "Passcode Incorrect");
			}
			else if(e.getSource()==jbtExit)
			{
				System.exit(0);
			}
			else if (inputPin.length()<4)//keeps password field to 4 numbers 
			{
				//adds number to password field according to button
				if(e.getSource()==jbtButton1)
				{
					@SuppressWarnings("deprecation")
					String text = jpwPasscode.getText();
					if (text==null)
						text="1";
					else
						text = text+"1";
					jpwPasscode.setText(text);
					System.out.println(text);
				}
				else if(e.getSource()==jbtButton2)
				{
					@SuppressWarnings("deprecation")
					String text = jpwPasscode.getText();
					if (text==null)
						text="2";
					else
						text = text+"2";
					jpwPasscode.setText(text);
					System.out.println(text);
				}
				else if(e.getSource()==jbtButton3)
				{
					@SuppressWarnings("deprecation")
					String text = jpwPasscode.getText();
					if (text==null)
						text="3";
					else
						text = text+"3";
					jpwPasscode.setText(text);
					System.out.println(text);
				}
				else if(e.getSource()==jbtButton4)
				{
					@SuppressWarnings("deprecation")
					String text = jpwPasscode.getText();
					if (text==null)
						text="4";
					else
						text = text+"4";
					jpwPasscode.setText(text);
					System.out.println(text);
				}
				else if(e.getSource()==jbtButton5)
				{
					@SuppressWarnings("deprecation")
					String text = jpwPasscode.getText();
					if (text==null)
						text="5";
					else
						text = text+"5";
					jpwPasscode.setText(text);
					System.out.println(text);
				}
				else if(e.getSource()==jbtButton6)
				{
					@SuppressWarnings("deprecation")
					String text = jpwPasscode.getText();
					if (text==null)
						text="6";
					else
						text = text+"6";
					jpwPasscode.setText(text);
					System.out.println(text);
				}
				else if(e.getSource()==jbtButton7)
				{
					@SuppressWarnings("deprecation")
					String text = jpwPasscode.getText();
					if (text==null)
						text="7";
					else
						text = text+"7";
					jpwPasscode.setText(text);
					System.out.println(text);
				}
				else if(e.getSource()==jbtButton8)
				{
					@SuppressWarnings("deprecation")
					String text = jpwPasscode.getText();
					if (text==null)
						text="8";
					else
						text = text+"8";
					jpwPasscode.setText(text);
					System.out.println(text);
				}
				else if(e.getSource()==jbtButton9)
				{
					@SuppressWarnings("deprecation")
					String text = jpwPasscode.getText();
					if (text==null)
						text="9";
					else
						text = text+"9";
					jpwPasscode.setText(text);
					System.out.println(text);
				}
				else if(e.getSource()==jbtButton0)
				{
					@SuppressWarnings("deprecation")
					String text = jpwPasscode.getText();
					if (text==null)
						text="0";
					else
						text = text+"0";
					jpwPasscode.setText(text);
					System.out.println(text);
				}
			}
		}
	}
	private boolean isAdmin(int adminPasscode) {
		boolean passcodeCorrect=false;
		adminLogin adminUser = new adminLogin();
		int correctPasscode = adminUser.adminAuthentication();
		if(correctPasscode==adminPasscode)
			passcodeCorrect=true;
		else
			passcodeCorrect=false;
		return passcodeCorrect;
	}
	public class authentacation implements CaretListener
	{
		@Override
		public void caretUpdate(CaretEvent arg0) {
			// TODO Auto-generated method stub
			System.out.println("TEST");
			@SuppressWarnings("deprecation")
			String passcode = jpwPasscode.getText();
			int passcodeLength = passcode.length();
			if(passcodeLength==4)
			{
				FindUser user = new FindUser(Integer.parseInt(passcode));
				String userName = user.findUserFromPassword();
				if(user.testPassword())
				{
					f.setVisible(false);
					f.dispose();
					JOptionPane.showMessageDialog(null, "Welcome, "+userName);
				}
				else
					JOptionPane.showMessageDialog(null, "Incorrect Passcode!");
			}
		}		
	}
	public class motionSensor implements MouseMotionListener
	{
		@Override
		public void mouseDragged(MouseEvent arg0) {
		}
		@Override
		public void mouseMoved(MouseEvent e) {
			if(timer.isRunning())
				timer.restart();
			else
				timer.start();
		}
		
	}
}




