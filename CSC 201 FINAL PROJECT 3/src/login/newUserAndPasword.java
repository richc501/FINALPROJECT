package login;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		checkIfPasswordOrUserNameExists action = new checkIfPasswordOrUserNameExists();
		jpwUserPassword.addCaretListener(action);
		jtfUserName.addCaretListener(action);
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
			//add joption pane for admin login
			if(userName.length()<5)
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
				jpwUserPassword.setText("");
			}
			else
			{
				passcode1 = Integer.parseInt(passcode.toString());
				//add to checks if user name and password already exists
				userAndPasswordSaver saver = new userAndPasswordSaver(userName,passcode1);
				this.setVisible(false);
				this.dispose();
			}
			System.out.println(userName);
			System.out.println(passcode);

		}
		else if(e.getSource()==jbtCancel)
		{
			this.setVisible(false);
			this.dispose();
		}
	}
	public class checkIfPasswordOrUserNameExists implements CaretListener
	{

		@Override
		public void caretUpdate(CaretEvent e) {
			String password =jpwUserPassword.toString(), userName =jtfUserName.toString();
			int passwordLength = password.length(), userNameLength = userName.length();
			if(passwordLength==4)
			{
				
					System.out.println("test1");
					
			}
			if(userNameLength==5)
			{
					System.out.println("test2");
			}
		}
	}

}
