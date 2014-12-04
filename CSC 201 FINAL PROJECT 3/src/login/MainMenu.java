package login;
//Richard Cunningham
//Admin: Pasword- 1234
//test1: PAsword- 5678
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.*;
//Someone else would make this menu work
public class MainMenu extends JFrame implements ActionListener{
	private String userName;
	Date date = new Date();
	JButton jbtExit = new JButton("Exit");
	JButton jbtLogOut = new JButton("Log Out");
	//Main Menu for after login
	public MainMenu(String userName)
	{
		this.userName = userName;
		JPanel jplControlPanel = new JPanel();
		jplControlPanel.setLayout(new BoxLayout(jplControlPanel, BoxLayout.Y_AXIS));
		JLabel jlTitle = new JLabel(userName+"| Station 1 : "+date.toString()+" |");
		setTitle("Point of Sale System: Main Menu");
		jplControlPanel.add(jlTitle);
		jplControlPanel.add(jbtExit);
		jplControlPanel.add(jbtLogOut);
		jbtExit.addActionListener(this);
		jbtLogOut.addActionListener(this);
		add(jplControlPanel);
		setSize(300,100);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jbtExit)
		{
			System.exit(0);
		}
		if(e.getSource()==jbtLogOut)
		{
			this.setVisible(false);
			this.dispose();
			loginPage menu = new loginPage();
		}
	}

}
