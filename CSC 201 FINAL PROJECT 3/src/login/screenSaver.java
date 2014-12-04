package login;
//Richard Cunningham
//Admin: Pasword- 1234
//test1: PAsword- 5678
import java.awt.AWTException;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class screenSaver extends JFrame implements MouseMotionListener{
	int xPos, yPos;
	Toolkit tk = Toolkit.getDefaultToolkit();
	//sets resolution of screen to x and y ints
	final int xSize = ((int) tk.getScreenSize().getWidth());  
	final int ySize = ((int) tk.getScreenSize().getHeight());
	final int centerX=xSize/2, centerY=ySize/2;//numbers for position of cursor when screen saver opens
	JPanel jplImage = new JPanel();
	
	public screenSaver()
	{
		setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));//changes cursor to loading cursor
		//removes windowed mode
		setExtendedState(screenSaver.MAXIMIZED_BOTH);
		setUndecorated(true);
		
		moveCursor();
		addMouseMotionListener(this);
		//sets size to resolution of computer
		  
		addImages();
		add(jplImage);
		setSize(xSize,ySize); 
		setVisible(true);
	}
	private void addImages() {//adds image JPanel
		ImageIcon image = new ImageIcon("bigLogo.jpg");//makes image
		JLabel jlImage = new JLabel(image);
		jplImage.add(jlImage);
	}
	public void moveCursor()
	{
		//forces cursor to center of screen
		try {
			Robot robot = new Robot();
			robot.mouseMove(centerX,centerY);
		} catch (AWTException e) {
			System.out.println("AWTException");
		}
	}
	@Override
	public void mouseDragged(MouseEvent arg0) {
			
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		//checks position of cursor
		xPos = e.getXOnScreen();
		yPos = e.getYOnScreen();
		if(xPos!=centerX||yPos!=centerY)//if they are not center the jframe closes 
		{
		this.setVisible(false);
		this.dispose();
		}
	}
}
