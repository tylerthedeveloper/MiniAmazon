package navigation;

import javax.swing.*;

import inventoryrepo.*;
import userbase.*;

public class App
{
	//member instance variables
	public static InventoryRepoClass InvRepo;
	public static UserBaseClass UsrBase;
	public static User User;
	public static JFrame Window;

	static boolean onStart = true;

	public App()
	{
		//initialize App classes
		InvRepo = new InventoryRepoClass();
		InvRepo.MarketItemList.add(new Item("itemID", "name", Item.Category.Electronics, "description", 50, 50, true, "sellerID"));

        InvRepo.MarketItemList.add(new Item("itemID2", "name2", Item.Category.Electronics, "description2", 50, 50, true, "sellerID2"));
        InvRepo.MarketTransactionList.add(InvRepo.makeTransaction(new Item("itemID2", "name2", Item.Category.Electronics, "description2", 50, 50, true, "sellerID2"))); 
		UsrBase = new UserBaseClass();
    InvRepo.MarketItemList.add(new Item("itemID2", "name2", Item.Category.Software, "description2", 50, 50, true, "sellerID2"));
		UsrBase = new UserBaseClass();
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

}
