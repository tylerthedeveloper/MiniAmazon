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
		//this.invokeLogin(this.onStart());		
		User = UserBase.onStart();
		
		//set home page
		//...
		
	}
}