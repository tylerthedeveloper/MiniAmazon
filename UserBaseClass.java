//package src.Userbase;
//import src.Userbase.*;
import java.util.Scanner;
import java.util.ArrayList;

public class UserBaseClass
{
	public static ArrayList<User> UserList;
	
	public UserBaseClass() {
		UserList = new ArrayList<User>();
	}

	/*
	public User onStart()
	{
		//User = usrBase.login();
		Scanner scanner = new Scanner(System.in);
		
		String name, pass, email;
		
		System.out.println("Would you like to Login or Register");
		
		if(scanner.next().equals("login") || scanner.next().equals("Login"))
		{
			System.out.println("Please enter your name");	
			name = scanner.next();
			
			System.out.println("Please enter your password");	
			pass = scanner.next();
			
			return this.invokeLogin(name, pass);
		}
		
		else
		{
			System.out.println("Please enter your name");	
			name = scanner.next();
			
			System.out.println("Please enter your password");	
			pass = scanner.next();

			System.out.println("Please enter your email");	
			email = scanner.next();
			
			System.out.println("Please select your role: by entering the " +
								"corresponding number \n " +  
								"1. Buyer \n 2. Seller \n 3. Admin");	
			
			
			int _role = scanner.nextInt();
			//enum role;
			User.Role role; //= new Role();
			
			if(_role == 1) {
				role = Role.Buyer;
				System.out.println("in bu" );
				//this.User = new Buyer();
			}	
		

			else if(_role == 2) {
				role = Role.Seller;
				//this.User = new Seller();
			}
				
			else //if(scanner.nextInt() == 3) {
			{
				role = Role.Admin;
				//this.User = new Admin();
			}
			
			
			System.out.println("You chose " + role);
			
			return this.register(name, pass, email, role);
		}	
	}
	*/
	
	//register new user
	//return that new User
	public static User register(String name, String pass, String email, User.Role role) //Role
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
	
	
	public static User invokeLogin(String name, String pass)
	{
		//look up in database user and return that user
		return new Buyer();
	}
	
}