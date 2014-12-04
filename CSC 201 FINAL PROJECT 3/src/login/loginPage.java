package login;
//Richard Cunningham
//Admin: Pasword- 1234
//test1: PAsword- 5678
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
	public JPasswordField jpwPasscode = new JPasswordField();
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
	JButton jbtClearPowerOff = new JButton("Power Off");
	JButton jbtNewUser = new JButton("New User");
	//JButton jbtExit = new JButton("Exit");
	JLabel jlEpmty = new JLabel(" ");
	JLabel jlTitle = new JLabel(" ");
	JLabel jblAnnoucement = new JLabel("");
	Timer timer = new Timer(10000, null);
	motionSensor mouse = new motionSensor();
	JFrame f = new JFrame();
	public loginPage()
	{
		SetTimer();//keeps track of timer
		f.addMouseMotionListener(mouse);//adds listener for mouse movement
		jplControlPanel.setLayout(new BoxLayout(jplControlPanel, BoxLayout.X_AXIS));
		f.setTitle("Point of Sale System: Login");
		f.setSize(850,500);
		northPanel();
		pinPad();
		messageBoard();
		controlPanel();
		jplSouthPanel.add(jbtNewUser);
		//jplSouthPanel.add(jbtExit);
		f.add(jplNorthPanel,BorderLayout.NORTH);
		f.add(jplSouthPanel,BorderLayout.SOUTH);
		f.add(jplControlPanel);
		f.setLocationRelativeTo(null); // makes frame center
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	private void SetTimer() {
		//activates screen saver when timer runs out
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
		//adds attributes to JPanel
		jlTitle = new JLabel("Station 1 : "+date.toString());
		jplTitlePanel.add(jlTitle);
		jplNorthPanel.setBorder(BorderFactory.createLineBorder(Color.blue));
		jplNorthPanel.add(jplTitlePanel);
		jplNorthPanel.add(jpwPasscode);
		jplNorthPanel.setSize(800,450);
		jplNorthPanel.setBorder(BorderFactory.createLineBorder(Color.red));
	}
	public void pinPad()//adds items to pin pad JPanel
	{
		addButtons();
		addListeners();
		jplPinPad.setForeground(Color.red);
		jplPinPad.setSize(100,100);
		jplPinPad.setBorder(BorderFactory.createLineBorder(Color.black));
	}
	public void messageBoard()//adds items to Message Board JPanel
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
		//JTextArea jtaMessage = new JTextArea(getMessageFromTXT());
		addAnnoucementsToMsgBoard();
	}
	private void addAnnoucementsToMsgBoard() {//adds annoucements to Message Board from txt file 
		try
		{
			Scanner fileReader = new Scanner(new File("MOTD.txt"));
			while(fileReader.hasNextLine())
			{
				jblAnnoucement = new JLabel(fileReader.nextLine());
				jplMessageBoard.add(jblAnnoucement);
			}
			fileReader.close();
		}catch(FileNotFoundException e){
			System.out.println("File not found");
		}
	}
	public void controlPanel() // adds items to JPanel
	{
		jplControlPanel.add(jplMessageBoard,BorderLayout.WEST);
		jplControlPanel.add(jplPinPad,BorderLayout.CENTER);
		jplControlPanel.setSize(800,450);
		jplControlPanel.setBorder(BorderFactory.createRaisedBevelBorder());
	}
	public void addButtons()//adds numbers buttons to pin pad Panel 
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
		jplPinPad.add(jbtClearPowerOff);
	}
	public void addListeners()//adds listeners for buttons etc.
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
		jbtClearPowerOff.addActionListener(this);
		jbtNewUser.addActionListener(this);
		//jbtExit.addActionListener(this);
		jpwPasscode.addCaretListener(action);
	}
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e)//makes button do what they are suppost to do
	{
		
		StringBuilder inputPin = new StringBuilder(jpwPasscode.getText());
		if(e.getSource()==jbtButton1||e.getSource()==jbtButton2||e.getSource()==jbtButton3||e.getSource()==jbtButton4||e.getSource()==jbtButton5||e.getSource()==jbtButton6||e.getSource()==jbtButton7||e.getSource()==jbtButton8||e.getSource()==jbtButton9||e.getSource()==jbtButton0||e.getSource()==jbtClearPowerOff||e.getSource()==jbtNewUser)
		{
			if(e.getSource()==jbtClearPowerOff)
			{
				if(jbtClearPowerOff.getText().equals("Delete"))
				{
					if(!(jpwPasscode.getText().equals("")))
					{
						String text = jpwPasscode.getText();
						text = text.substring(0,text.length()-1);
						System.out.println(text);
						jpwPasscode.setText(text);
						inputPin = new StringBuilder(text);
					}
					if(jpwPasscode.getText().equals(""))
					{
						jbtClearPowerOff.setText("Power Off");
					}
					timer.stop();
					screenSaver saver = new screenSaver();
				}
				else if(jbtClearPowerOff.getText().equals("Delete All"))//deletes all when text is length of 4
				{
					if(!(jpwPasscode.getText().equals("")))
					{
						String text = "";
						System.out.println(text);
						jpwPasscode.setText(text);
						inputPin = new StringBuilder(text);
					}
					if(jpwPasscode.getText().equals(""))
					{
						jbtClearPowerOff.setText("Power Off");
					}
					timer.stop();
					screenSaver saver = new screenSaver();
				}
				else if(jbtClearPowerOff.getText().equals("Power Off"))
				{
					System.exit(0);
				}
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
//			else if(e.getSource()==jbtExit)
//			{
//				System.exit(0);
//			}
			else if (inputPin.length()<4)//keeps password field to 4 numbers 
			{
				//adds number to password field according to button
				if(e.getSource()==jbtButton1)
				{
					jbtClearPowerOff.setText("Delete");
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
					jbtClearPowerOff.setText("Delete");
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
					jbtClearPowerOff.setText("Delete");
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
					jbtClearPowerOff.setText("Delete");
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
					jbtClearPowerOff.setText("Delete");
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
					jbtClearPowerOff.setText("Delete");
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
					jbtClearPowerOff.setText("Delete");
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
					jbtClearPowerOff.setText("Delete");
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
					jbtClearPowerOff.setText("Delete");
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
					jbtClearPowerOff.setText("Delete");
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
	private boolean isAdmin(int adminPasscode) {//checks for admin password
		boolean passcodeCorrect=false;
		adminLogin adminUser = new adminLogin();
		int correctPasscode = adminUser.adminAuthentication();
		if(correctPasscode==adminPasscode)
			passcodeCorrect=true;
		else
			passcodeCorrect=false;
		return passcodeCorrect;
	}
	public class authentacation implements CaretListener//check for password and if corrects logs in with user associated with said password
	{
		@Override
		public void caretUpdate(CaretEvent arg0) {
			System.out.println("TEST");
			@SuppressWarnings("deprecation")
			String passcode = jpwPasscode.getText();
			int passcodeLength = passcode.length();
			if(passcodeLength==4)
			{
				jbtClearPowerOff.setText("Delete All");
				FindUser user = new FindUser(Integer.parseInt(passcode));
				String userName = user.findUserFromPassword();
				if(user.testPassword())
				{
					timer.stop();
					f.setVisible(false);
					f.dispose();
					MainMenu menu = new MainMenu(userName);
					JOptionPane.showMessageDialog(null, "Welcome, "+userName);
				}
				else
				{
					
					JOptionPane.showMessageDialog(null, "Incorrect Passcode!");
				}
			}
		}		
	}
	public class motionSensor implements MouseMotionListener
	{
		@Override
		public void mouseDragged(MouseEvent arg0) {
		}
		@Override
		public void mouseMoved(MouseEvent e) {//keeps track of mouse moving
			if(timer.isRunning())
				timer.restart();//restart timer if timer is running
			else
				timer.start();//starts timer if timer is not running
		}

	}
}




