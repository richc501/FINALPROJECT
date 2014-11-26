package login;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class adminLogin{
	public int adminAuthentication()
	{
		int adminPasscode = 0;
		try
		{
			RandomAccessFile readFile = new RandomAccessFile("Info.dat","r");
			RandomAccessFile numberOfVaribles = new RandomAccessFile("n.dat","r");
			readFile.seek(0);
			numberOfVaribles.seek(0);
			int loopLimit = numberOfVaribles.readInt()/2;
			for(int i=0;i<loopLimit;i++)
			{
				String userTemp = readFile.readUTF();
				int passcodeTemp = readFile.readInt();
				if(userTemp.equals("Admin"))
				{
					adminPasscode = passcodeTemp;
					break;
				}
			}
			readFile.close();
			numberOfVaribles.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File not found!");
		}
		catch(IOException e)
		{
			System.out.println("IOException");
		}
		return adminPasscode;
	}
}
