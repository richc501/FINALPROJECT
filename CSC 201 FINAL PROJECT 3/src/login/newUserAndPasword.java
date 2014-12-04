package login;
//Richard Cunningham
//Admin: Pasword- 1234
//test1: PAsword- 5678
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

@SuppressWarnings("serial")
public class newUserAndPasword extends JFrame implements ActionListener{
	JLabel jlInputLabel = new JLabel();
	JTextField jtfUserName = new JTextField();
	JPasswordField jpwUserPassword = new JPasswordField();
	JPanel jplControlPanel = new JPanel(new GridLayout(2,2));
	JPanel jplButtonPanel = new JPanel(new FlowLayout());
	JButton jbtCancel = new JButton("Cancel");
	JButton jbtSubmit = new JButton("Submit");
	private String userName="";
	private StringBuilder passcode = new StringBuilder();
	private int passcode1;
	//Makes JFrame after admin authenticates
	public newUserAndPasword()
	{
		setSize(300,150);
		addComponentsToPanels();
		addListeners();
		add(jplControlPanel,BorderLayout.CENTER);
		add(jplButtonPanel,BorderLayout.SOUTH);
		setLocationRelativeTo(null); // makes frame center
		setVisible(true);
	}
	private void addListeners() {
		jbtSubmit.addActionListener(this);
		jbtCancel.addActionListener(this);
	}
	private void addComponentsToPanels() {
		jlInputLabel = new JLabel(" Input User Name: ");
		jplControlPanel.add(jlInputLabel);
		jplControlPanel.add(jtfUserName);
		jlInputLabel = new JLabel(" Input User Password: ");
		jplControlPanel.add(jlInputLabel);
		jplControlPanel.add(jpwUserPassword);
		jplButtonPanel.add(jbtSubmit);
		jplButtonPanel.add(jbtCancel);
	}
	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		boolean isDigit=false;
		if(e.getSource()==jbtSubmit)
		{ 
			userName = jtfUserName.getText();
			passcode = new StringBuilder(jpwUserPassword.getText());
			if(userName.length()<5||userName.length()>5)
			{
				JOptionPane.showMessageDialog(null, "User Name Must be 5 letters in length");
			}
			for(int i=0;i<passcode.length();i++)
			{
				if(Character.isDigit(passcode.charAt(i)))
				{
					isDigit=true;
				}
				else
				{
					isDigit=false;
					break;
				}
			}
			if(passcode.length()<4||isDigit==false)
			{
				JOptionPane.showMessageDialog(null, "Password must be 4 numbers");
			}
			else
			{
				passcode1 = Integer.parseInt(passcode.toString());
				//checks if user name and password already exists
				if(doesUserExist())
					JOptionPane.showMessageDialog(null, "User Exists Please Change User Name");
				if(doesPasswordExist())
					JOptionPane.showMessageDialog(null, "Password Exists Please Change Password");
				if(doesUserExist()==false&&doesPasswordExist()==false)
				{
					userAndPasswordSaver saver = new userAndPasswordSaver(userName,passcode1);
					this.setVisible(false);
					this.dispose();
				}
			}
//			System.out.println(userName);
//			System.out.println(passcode);

		}
		else if(e.getSource()==jbtCancel)
		{
			this.setVisible(false);
			this.dispose();
		}
	}
	
	public boolean doesUserExist()
	{
		boolean userExists=false;
		try
		{
			RandomAccessFile info = new RandomAccessFile("info.dat","r");
			RandomAccessFile amountOfVaribles = new RandomAccessFile("n.dat","r");
			info.seek(0);
			amountOfVaribles.seek(0);
			int loopLimit = amountOfVaribles.readInt()/2;
			for(int i=0;i<loopLimit;i++)
			{
				String userTemp = info.readUTF();
				int passcodeTemp = info.readInt();
				if (userTemp.equals(jtfUserName.getText()))
				{
					userExists=true;
					break;
				}
				else
				{
					userExists=false;
				}
			}
			info.close();
			amountOfVaribles.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File not found!");
		}
		catch(IOException e)
		{
			System.out.println("IOException!");
		}
		return userExists;
		
	}
	public boolean doesPasswordExist()
	{
		boolean passwordExists=false;
		try
		{
			RandomAccessFile info = new RandomAccessFile("info.dat","r");
			RandomAccessFile amountOfVaribles = new RandomAccessFile("n.dat","r");
			info.seek(0);
			amountOfVaribles.seek(0);
			int loopLimit = amountOfVaribles.readInt()/2;
			@SuppressWarnings("deprecation")
			String enteredPasscode = jpwUserPassword.getText();
			for(int i=0;i<loopLimit;i++)
			{
				String userTemp = info.readUTF();
				int passcodeTemp = info.readInt();
				if (passcodeTemp==Integer.parseInt(enteredPasscode))
				{
					passwordExists=true;
					break;
				}
				else
				{
					passwordExists=false;
				}
			}
			info.close();
			amountOfVaribles.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File not found!");
		}
		catch(IOException e)
		{
			System.out.println("IOException!");
		}
		return passwordExists;
		
	}
}
