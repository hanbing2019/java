package rmi.demo;

public class UserSever
{
	public static void main(String[] args)
	{
		// UserSever userServer = new UserSever();
		// userServer.setAge(18);
		// User_Skeleton us = new User_Skeleton(userServer);

		// Æô¶¯·þÎñ
		// new Thread(us).start();

		User user = new User();
		user.setAge(18);
		User_Skeleton us = new User_Skeleton("localhost:8888/age", user);

		new Thread(us).start();
	}

}
