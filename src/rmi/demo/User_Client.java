package rmi.demo;

public class User_Client
{
	public static void main(String[] args)
	{
		User_Stub us = new User_Stub();
		System.out.println((User) us.getUser());
	}

}
