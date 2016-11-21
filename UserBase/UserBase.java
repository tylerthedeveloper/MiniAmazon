import Userbase.*;

public class UserBase
{
	public User onStart()
	{
		//User = usrBase.login();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Would you like to Login or Register");

		if(scanner.next() == "Login") 
		{
			System.out.println("Please enter your name");	
			String name = scanner.next();
			
			System.out.println("Please enter your password");	
			String pass = scanner.next();
			
			return this.usrBase.invokeLogin(name, pass);
		}
		
		else
		{
			System.out.println("Please enter your name");	
			String name = scanner.next();
			
			System.out.println("Please enter your password");	
			String pass = scanner.next();

			System.out.println("Please enter your email");	
			String pass = scanner.next();
			
			System.out.println("Please select your role: by entering the " +
								"corresponding number \n " +  
								" 1. Buyer \n 2. Seller \n 3. Admin");	

			//User User;
			Enum role;
			
			if(scanner.nextInt() == 1) {
				role = Role.Buyer;
				//this.User = new Buyer();
			}	
		

			else if(scanner.nextInt() == 2) {
				role = Role.Seller;
				//this.User = new Seller();
			}
				
			else if(scanner.nextInt() == 3) {
				role = Role.Admin;
				//this.User = new Admin();
			}
			
			return this.register(name, pass, email, role);
		}	
		
	}
	
	//register new user
	//return that new User
	public User register(String name, String pass, String email, Enum role)
	{
		User user;
		
		if(role == Buyer) {
			user = new Buyer();
		}	
		
		else if(role == Seller) {
			user = new Seller();
		}	


		else { 
			user = new Admin();
		}	

		user.name = name;
		user.pass = pass;
		user.email = email;
		user.role = role;
			
		return user;
	
	}
	
	public User invokeLogin(String name, String pass)
	{
		//look up in database user and return that user
		
	}
	
}