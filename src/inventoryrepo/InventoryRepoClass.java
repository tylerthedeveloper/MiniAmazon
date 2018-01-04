package inventoryrepo;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import userbase.*;
import navigation.*;

public class InventoryRepoClass
{
	public ArrayList<Item> MarketItemList;
	public ArrayList<Transaction> MarketTransactionList;
	
	public InventoryRepoClass() {
		MarketItemList = new ArrayList<Item>();
		MarketTransactionList = new ArrayList<Transaction>();
	}
		
	public void processOrder(Item item, int amountOrdered)
	{
		item.updateQuantity(amountOrdered);
		Transaction _trans = this.makeTransaction(item);
		this.addTransaction(_trans);
		((Buyer)App.User).makePurchase(item, _trans);	
	}
	
	public Transaction makeTransaction(Item item)
	{
		return new Transaction(item);
	}
	
	public void addTransaction(Transaction transaction)
	{
		this.MarketTransactionList.add(transaction);		
	}
	
	public Item searchForItem(String searchType, String textSearch)
	{
		Item _item = new Item();
		
		if(searchType.equals("ID")) {			
			for(Item item : this.MarketItemList) {
				if(textSearch.equals(item.getItemID())) {
					_item = item;
				} 
			}
		} else { 
			for(Item item : this.MarketItemList) {
				if(textSearch.equals(item.getName())) {
					_item = item;
				} 
			}		
		}
			
		return _item;
	}

	public ArrayList<Item> catSearch(String category)
	{
		ArrayList<Item> _items = new ArrayList<Item>();
		
		switch(category) {
			case("Electronics"):
				for(Item item : this.MarketItemList) {
					if(item.getCategory().toString().equals(category))
						_items.add(item);
				}
				break;
			
			case("Software"):
				for(Item item : this.MarketItemList) {
				if(item.getCategory().toString().equals(category))
					_items.add(item);
				}
				break;
			
			case("Books"):
				for(Item item : this.MarketItemList) {
				if(item.getCategory().toString().equals(category))
					_items.add(item);
				}
				break;
		}
			
		

		return _items;
	}

}