//package src.InventoryRepo;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class InventoryRepoClass
{
	public ArrayList<Item> MarketItemList;
	public ArrayList<Transaction> MarketTransactionList;
	
	public InventoryRepoClass() {
		MarketItemList = new ArrayList<Item>();
		MarketTransactionList = new ArrayList<Transaction>();
		//MarketTransactionList.add(new Transaction(MarketItemList.get(0)));
	}
		
	public void processOrder(Item item, int amountOrdered)
	{
		item.updateQuantity(amountOrdered);
		System.out.print(App.InvRepo.MarketTransactionList.size());
		Transaction _trans = this.makeTransaction(item);
		this.addTransaction(_trans);
		System.out.print(App.InvRepo.MarketTransactionList.size());
		((Buyer)App.User).makePurchase(item, _trans);	
	}
	/*
	public void removeMarketItem(Item item)
	{
		this.MarketItemList.remove(item);		
	}
	*/
	
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
		
		if(category.equals("Electronics")) {			
			for(Item item : this.MarketItemList) {
				if(item.getCategory() == Item.Category.Electronics)
					_items.add(item);
			} 
		}
			
		else if(category.equals("Software")) {
			for(Item item : this.MarketItemList) {
				if(item.getCategory() == Item.Category.Software)
					_items.add(item);
			} 
		} 
		else {
			for(Item item : this.MarketItemList) {
				if(item.getCategory() == Item.Category.Books)
					_items.add(item);
			} 
		}
			
		return _items;
	}

}