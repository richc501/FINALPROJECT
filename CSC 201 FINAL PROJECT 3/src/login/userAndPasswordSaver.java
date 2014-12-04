package login;
//Richard Cunningham
//Admin: Pasword- 1234
//test1: PAsword- 5678
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class userAndPasswordSaver {
	private String userName;
	protected int password;
	public userAndPasswordSaver(String userName, int password)
	{
		this.setUserName(userName);
		this.setPassword(password);
		saveToFile();
	}
	public void saveToFile()
	{
		//saves user and password to dat file
		//saves amount of users to another dat file
		try
		{
			RandomAccessFile info = new RandomAccessFile("info.dat","rw");
			RandomAccessFile numberOfVaribles = new RandomAccessFile("n.dat","rw");
			
			if(numberOfVaribles.length()>0)
			{
			numberOfVaribles.seek(0);
			int amountOfItems = (numberOfVaribles.readInt())+2;
			numberOfVaribles.seek(0);
			numberOfVaribles.writeInt(amountOfItems);
			numberOfVaribles.seek(0);
			info.seek(info.length());
			info.writeUTF(userName);
			info.writeInt(password);
			}
			else
			{
				info.writeUTF(userName);
				info.writeInt(password);
				numberOfVaribles.seek(0);
				numberOfVaribles.writeInt(2);
			}
			numberOfVaribles.close();
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
