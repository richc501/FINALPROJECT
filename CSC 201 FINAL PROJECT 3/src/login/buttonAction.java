package login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class buttonAction extends loginPage implements ActionListener{
	@SuppressWarnings("deprecation")
	private StringBuilder inputPin = new StringBuilder(jpwPasscode.getText()); 
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jbtButton1||e.getSource()==jbtButton2||e.getSource()==jbtButton3||e.getSource()==jbtButton4||e.getSource()==jbtButton5||e.getSource()==jbtButton6||e.getSource()==jbtButton7||e.getSource()==jbtButton8||e.getSource()==jbtButton9||e.getSource()==jbtButton0||e.getSource()==jbtClear)
		{
			if (inputPin.length()<4)//keeps password field to 4 numbers 
			{
				//adds number to password field according to button
				if(e.getSource()==jbtButton1)
				{
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
					@SuppressWarnings("deprecation")
					String text = jpwPasscode.getText();
					if (text==null)
						text="0";
					else
						text = text+"0";
					jpwPasscode.setText(text);
					System.out.println(text);
				}
				else if(e.getSource()==jbtClear)
				{
					jpwPasscode.setText("");
					inputPin.delete(0, inputPin.length());
				}

			}
		}
	}
}