package login;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.swing.JOptionPane;

public class FindUser {

	private String UserName = null;
	private int password;
	public FindUser(int password) 
	{
		this.password = password;
		
	}
	protected String findUserFromPassword() 
	{
		boolean foundUserName=false;
		int retry = 0;
		try
		{
			RandomAccessFile readFile = new RandomAccessFile("Info.dat","rw");
			readFile.seek(0);
			do
			{
				String userTemp = readFile.readUTF();
				int passwordTemp = readFile.readInt();
				if(passwordTemp==password)
				{
					UserName = userTemp;
					foundUserName=true;
				}
				else
				{
					retry = JOptionPane.showConfirmDialog(null,"User Not found. Do you want to try again?","Error",JOptionPane.YES_NO_OPTION);
					foundUserName=false;
				}
			}while(foundUserName==false&&retry==JOptionPane.YES_OPTION);
			readFile.close();
		}
		catch(FileNotFoundException e)
		{
			JOptionPane.showMessageDialog(null, "File Not Found!");
		}
		catch(IOException e)
		{
			JOptionPane.showMessageDialog(null, "IO Exception");
		}
		return UserName;
	}

}
