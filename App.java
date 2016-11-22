//import src.UserBase.*;
//import src.InventoryRepo.*;
import java.awt.*;
import javax.swing.*;

public class App
{
	//member instance variables
	InventoryRepoClass invRepo;
	UserBaseClass usrBase;
	public static User User;
	public static JFrame Window;
	
	public App()
	{
		//initialize App classes
		invRepo = new InventoryRepoClass();
		usrBase = new UserBaseClass();

		Window = new Window();

		//initiate login sequence
		User = usrBase.onStart();

		//set home page
		//setMainPage();
	}
	
	/*
	public void setMainPage()
	{
		if(User instanceof Buyer) {
			
		}	
		
		else if(User instanceof Seller) {
			
		}	

		else {
			
		}	
		
	}	
	*/

	
}