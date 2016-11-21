//package src.Userbase;
//import src.Userbase.*;
import java.util.Scanner;

public class UserBaseClass
{
	public UserBaseClass() {}
	
	public enum Role 
	{
		Buyer,
		Seller,
		Admin
	};

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
			Role role; //= new Role();
			
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
	
	//register new user
	//return that new User
	public static User register(String name, String pass, String email, Role role)
	{
		User user;
		
		if(role == Role.Buyer) {
			user = new Buyer();
		}	
		
		else if(role == Role.Seller) {
			user = new Seller();
		}	

		else { 
			user = new Admin();
		}	

		user.setName(name);
		user.setPass(pass);
		user.setEmail(email);
		user.setRole(role.toString());

		return user;
	
	}
	
	public static User invokeLogin(String name, String pass)
	{
		//look up in database user and return that user
		return new User();
	}
	
}