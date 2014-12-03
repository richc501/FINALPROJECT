package login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.*;

public class MainMenu extends JFrame implements ActionListener{
	private String userName;
	Date date = new Date();
	JButton jbtExit = new JButton("Exit");
	public MainMenu(String userName)
	{
		this.userName = userName;
		JPanel jplControlPanel = new JPanel();
		jplControlPanel.setLayout(new BoxLayout(jplControlPanel, BoxLayout.Y_AXIS));
		JLabel jlTitle = new JLabel(userName+"| Station 1 : "+date.toString()+" |");
		setTitle("Point of Sale System: Main Menu");
		jplControlPanel.add(jlTitle);
		jplControlPanel.add(jbtExit);
		jbtExit.addActionListener(this);
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
		
	}

}
