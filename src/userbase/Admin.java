package userbase;

import java.util.ArrayList;

import inventoryrepo.*;
import navigation.*;

public class Admin extends User
{
	public Admin () {}

	public Admin (String name, String pass, String email, Role role)
	{
		super(name, pass, email, role);
	}

	public ArrayList<Item> sellerItems(Seller s) {
	
		ArrayList<Item> sItems = new ArrayList<Item>();

		for (Item item : App.InvRepo.MarketItemList) {
	
			if (item.getSellerID().equals(s.getUserID())) {
				sItems.add(item);
			}
		}
	
		return sItems;
	}
}