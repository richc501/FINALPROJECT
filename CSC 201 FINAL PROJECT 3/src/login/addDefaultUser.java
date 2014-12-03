package login;

public class addDefaultUser {
	public static void main(String[]args)
	{
		//sets default user for first launch
		userAndPasswordSaver admin = new userAndPasswordSaver("Admin",1234);
	}
}
