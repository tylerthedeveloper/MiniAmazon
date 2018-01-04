//package InventoryRepo;
//package UserBase;
//package Navigation;

import navigation.App;
import navigation.*;

public class Main
{
	public static void main(String[] args)
	{
		App App = new App();
		StartupHelper.loadItems();
		StartupHelper.loadUsers();
	}

}
