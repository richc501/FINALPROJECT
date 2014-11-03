package login;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class newUserAndPasword extends loginPage{
	public newUserAndPasword()
	{
		newUser();
	}
	public void newUser()
	{
		//JFrame frame = new JFrame();
		Object user = JOptionPane.showInputDialog("Enter user name:");
		String userName = user.toString();
		Object passcode = JOptionPane.showInputDialog("Enter password: (only 4 numbers)");
		System.out.println(userName);
		int password = Integer.parseInt(passcode.toString());
		System.out.println(password);
	}
}
