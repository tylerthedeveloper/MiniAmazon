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


	static boolean onStart = true;

	public App()
	{
		//initialize App classes
		InvRepo = new InventoryRepoClass();
		InvRepo.MarketItemList.add(new Item("itemID", "name", Item.Category.Electronics, "description", 50, 50, true, "sellerID"));
<<<<<<< HEAD
    InvRepo.MarketItemList.add(new Item("itemID2", "name2", Item.Category.Electronics, "description2", 50, 50, true, "sellerID2"));
		UsrBase = new UserBaseClass();
		UsrBase.addUser(new Seller("Jason","password","email@email.com",null));
		UsrBase.addUser(new Buyer("Jason","password","jason@email.com",null));

=======
        InvRepo.MarketItemList.add(new Item("itemID2", "name2", Item.Category.Electronics, "description2", 50, 50, true, "sellerID2"));
        InvRepo.MarketTransactionList.add(InvRepo.makeTransaction(new Item("itemID2", "name2", Item.Category.Electronics, "description2", 50, 50, true, "sellerID2"))); 
		UsrBase = new UserBaseClass();
//		UsrBase.addUser(new Seller("Jason","password","email@email.com", (User.getClass()Role));
>>>>>>> ddc41dff360c6d04b35de952f6190f3e79be54b7
		NavStack = new Stack<UIPage>();
		startUp();
		Window = new Window();
	}

	public void startUp() {
		//check onstart
		if(onStart) {
			//helper to aggregate and organize UI elements and dialogs
			StartupHelper SUPHelper = new StartupHelper();
			JDialog initialDialog = SUPHelper.Initial();
			initialDialog.setVisible(true);
			onStart = false;
		}
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
