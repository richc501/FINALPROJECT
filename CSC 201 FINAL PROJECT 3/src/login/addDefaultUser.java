package login;

import java.io.File;

//Richard Cunningham
public class addDefaultUser {
	public static void main(String[]args)
	{
		//deletes info.dat and n.dat
		File infoFile = new File("info.dat");
		File nFile = new File("n.dat");
		boolean isDeleted = infoFile.delete();
		if(infoFile.exists())
		{
			if(isDeleted)
				System.out.println("Info File Deleted");
		}
		isDeleted = nFile.delete();
		if(nFile.exists())
		{
			if(isDeleted)
				System.out.println("N File Deleted");
		}
		if(!(infoFile.exists())&&!(nFile.exists()))
		{
			System.out.println("Files Deleted, Recreating Files with default Admin User");
			//sets default user for first launch
			userAndPasswordSaver admin = new userAndPasswordSaver("Admin",1234);
		}
	}
}
