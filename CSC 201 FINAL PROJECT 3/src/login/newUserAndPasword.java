package login;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class newUserAndPasword extends JFrame implements ActionListener{
	JLabel jlInputLabel = new JLabel();
	JTextField jtfUserName = new JTextField();
	JPasswordField jpwUserPassword = new JPasswordField();
	JPanel jplControlPanel = new JPanel(new GridLayout(2,2));
	JPanel jplButtonPanel = new JPanel(new FlowLayout());
	JButton jbtCancel = new JButton("Cancel");
	JButton jbtSubmit = new JButton("Submit");
	private String userName="",passwordString="";
	public newUserAndPasword()
	{
		setSize(300,150);
		addComponentsToPanels();
		addListeners();
		add(jplControlPanel,BorderLayout.CENTER);
		add(jplButtonPanel,BorderLayout.SOUTH);
		setLocationRelativeTo(null); // makes frame center
		setVisible(true);
		//newUser();
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
		if(e.getSource()==jbtSubmit)
		{ 
			userName = jtfUserName.getText();
			passwordString = jpwUserPassword.getText();
			System.out.println(userName);
			System.out.println(passwordString);
			this.setVisible(false);
		    this.dispose();
		}
		else if(e.getSource()==jbtCancel)
		{
			this.setVisible(false);
		    this.dispose();
		}
	}
	public void newUser()
	{
		StringBuilder password = new StringBuilder();
		int password1 = 0;
		
		boolean isDigit=true;
		JFrame frame = new JFrame();
		do
		{
			Object user = JOptionPane.showInputDialog(frame,"Enter user name: (Only 5 characters long)");
			userName = user.toString();
		}while(userName.length()<5);
		do
		{
			
			Object passcode = JOptionPane.showInputDialog(frame,"Enter password: (only 4 numbers)");
			passwordString = passcode.toString();
			password = new StringBuilder(passwordString);
			for(int i=0;i<password.length();i++)
			{
				if (Character.isDigit(password.charAt(i)))
				{
					isDigit=true;
				}
				else
				{
					isDigit=false;
					break;
				}
			}
		}while(isDigit==false&&password.length()<4);
		password1 = Integer.parseInt(passwordString);
		System.out.println(password1);	
	}

}
