//import src.UserBase.*;
//import src.InventoryRepo.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;


public class App
{
	//member instance variables
	public static InventoryRepoClass InvRepo;
	public static UserBaseClass UsrBase;
	public static User User;
	public static JFrame Window;
	public static Stack<UIPage> NavStack;
	
	public App()
	{
		//initialize App classes
		InvRepo = new InventoryRepoClass();
		UsrBase = new UserBaseClass();
		NavStack = new Stack<UIPage>();
		Window = new Window();
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