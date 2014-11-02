package login;

import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class drawOvals extends JPanel{
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawOval(20, 10, 250, 200);
		g.drawOval(25, 10, 250, 200);
		g.drawOval(30, 10, 250, 200);
		g.drawOval(35, 10, 250, 200);
	}
}
