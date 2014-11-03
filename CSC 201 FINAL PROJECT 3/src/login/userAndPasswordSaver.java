package login;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class userAndPasswordSaver {
	private String userName;
	private int password;
	public userAndPasswordSaver(String userName, int password)
	{
		this.setUserName(userName);
		this.setPassword(password);
		saveToFile();
	}
	public void saveToFile()
	{
		try
		{
			RandomAccessFile info = new RandomAccessFile("info.dat","rw");
			info.writeUTF(userName);
			info.writeInt(password);
			info.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		} catch (IOException e) {
			System.out.println("IO Exception");
		}
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
