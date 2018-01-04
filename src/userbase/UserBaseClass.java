package userbase;

import java.util.Scanner;
import java.util.ArrayList;

public class UserBaseClass
{
	public static ArrayList<User> UserList;

	public UserBaseClass() {
		UserList = new ArrayList<User>();
		//this.addUser(new Seller("Jason","password","email@email.com", 	User.Role.Seller));
		//addUser(new Buyer("Jason","password","jason@email.com", User.Role.Buyer));

	}

	//register new user
	//return that new User
	public static User register(String name, String pass, String email, User.Role role)
	{
		User user;

		if(role == User.Role.Buyer) {
			user = new Buyer(name, pass, email, role);
		}

		else if(role == User.Role.Seller) {
			user = new Seller(name, pass, email, role);
		}

		else {
			user = new Admin(name, pass, email, role);
		}

		/*
		user.setName(name);
		user.setPass(pass);
		user.setEmail(email);
		user.setRole(role);
		*/

		addUser(user);

		return user;

	}

	public static void addUser(User user)
	{
		UserList.add(user);
	}

	public static void removeUser(User user)
	{
		UserList.remove(user);
	}

	public static User invokeLogin(String name, String pass)
	{
		//look up in database user and return that user
		return new Buyer();
	}

	public static boolean logout(User user)
	{
		//look up in database user and logout that user
		return true; //loggedOut(user);
	}

}
