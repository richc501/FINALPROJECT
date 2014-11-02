package login;
import java.awt.*;
import java.util.Date;

import javax.swing.*;

@SuppressWarnings("serial")
public class loginPage extends JFrame {
	Date date = new Date();
	JPasswordField jpwPasscode = new JPasswordField();
	JPanel jplControlPanel = new JPanel();
	JPanel jplPinPad = new JPanel(new GridLayout(4,3));
	JPanel jplMessageBoard = new JPanel();
	JPanel jplNorthPanel = new JPanel(new GridLayout(1,2));
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
	JLabel jlEpmty = new JLabel(" ");
	JLabel jlTitle = new JLabel(" ");
	
	public loginPage()
	{
		jplControlPanel.setLayout(new BoxLayout(jplControlPanel, BoxLayout.X_AXIS));
		setTitle("Point of Sale System: Login");
		setSize(850,500);
		northPanel();
		pinPad();
		messageBoard();
		controlPanel();		
		add(jplNorthPanel,BorderLayout.NORTH);
		add(jplControlPanel);
		setLocationRelativeTo(null); // makes frame center
		setVisible(true);
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
		jplPinPad.setSize(100, 100);
		jplPinPad.setBorder(BorderFactory.createLineBorder(Color.black));
	}
	public void messageBoard()
	{
		jplMessageBoard.setSize(300,300);
		jplMessageBoard.setBorder(BorderFactory.createLineBorder(Color.black));
	}
	public void controlPanel()
	{
		//jplControlPanel.add(jplNorthPanel,BorderLayout.NORTH);
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
//		buttonAction buttonAction = new buttonAction();
//		jbtButton0.addActionListener(buttonAction);
//		jbtButton1.addActionListener(buttonAction);
//		jbtButton2.addActionListener(buttonAction);
//		jbtButton3.addActionListener(buttonAction);
//		jbtButton4.addActionListener(buttonAction);
//		jbtButton5.addActionListener(buttonAction);
//		jbtButton6.addActionListener(buttonAction);
//		jbtButton7.addActionListener(buttonAction);
//		jbtButton8.addActionListener(buttonAction);
//		jbtButton9.addActionListener(buttonAction);
//		jbtClear.addActionListener(buttonAction);
		
	}
}
