package login;
//Richard Cunningham
//Admin: Pasword- 1234
//test1: PAsword- 5678
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
		//find user bases on password
		//using Random Access File Class
		try
		{
			RandomAccessFile readFile = new RandomAccessFile("Info.dat","rw");
			RandomAccessFile numberOfVaribles = new RandomAccessFile("n.dat","rw");
			readFile.seek(0);
			numberOfVaribles.seek(0);
			int loopLimit = numberOfVaribles.readInt()/2;
			for(int i=0;i<loopLimit;i++)
			{
				String userTemp = readFile.readUTF();
				int passwordTemp = readFile.readInt();
				if(passwordTemp==password)
				{
					UserName = userTemp;
					break;
				}
				else if(userTemp==null)
					loopLimit++;
			}
			readFile.close();
			numberOfVaribles.close();
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
	protected boolean testPassword() 
	{
		boolean foundUserName = false;
		try
		{
			RandomAccessFile readFile = new RandomAccessFile("Info.dat","rw");
			RandomAccessFile numberOfVaribles = new RandomAccessFile("n.dat","rw");
			readFile.seek(0);
			numberOfVaribles.seek(0);
			int loopLimit = numberOfVaribles.readInt()/2;
			System.out.println("loopLimit:"+loopLimit);
			for(int i=0;i<loopLimit;i++)
			{
				String userTemp = readFile.readUTF();
				int passwordTemp = readFile.readInt();
				if(passwordTemp==password)
				{
					foundUserName=true;
					break;
				}
				else if(userTemp==null)
					loopLimit++;
				else
				{
					foundUserName=false;
				}
			}
			readFile.close();
			numberOfVaribles.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File Not Found!");
		}
		catch(IOException e)
		{
			System.out.println("IO Exception");
		}
		return foundUserName;
	}
}
