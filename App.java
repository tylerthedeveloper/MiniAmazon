import InventoryRepo.*;
import UserBase.*;

public class App
{
	//member instance variables
	InventoryRepo invRepo;
	UserBase usrBase;
	User User;
	
	public App()
	{
		//initialize App classes
		invRepo = new InventoryRepo();
		usrBase = new UserBase();

		//initiate login sequence
		this.invokeLogin();		
		
		//set home page
		//...
		
	}
	
	public User invokeLogin()
	{
		//User = usrBase.login();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Are you already registered: enter y or n");

		if(scanner.next() == 'y') {
			System.out.println("Please enter your username");	
			String name = scanner.next();
			
			System.out.println("Please enter your password");	
			String pass = scanner.next();
		}
		
		else
			
		
	}

}