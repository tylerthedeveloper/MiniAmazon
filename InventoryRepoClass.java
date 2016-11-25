//package src.InventoryRepo;
import java.util.ArrayList;

public class InventoryRepoClass
{
	public static ArrayList<Item> MarketItemList;
	public static ArrayList<Transaction> MarketTransactionList;
	
	public InventoryRepoClass() {
		MarketItemList = new ArrayList<Item>();
		MarketTransactionList = new ArrayList<Transaction>();
	}
		
	public void processOrder(Item item)
	{
		this.removeMarketItem(item);
		Transaction _trans = this.makeTransaction(item);
		this.addTransaction(_trans);
		((Buyer)App.User).makePurchase(item, _trans);	
	}
	
	public void removeMarketItem(Item item)
	{
		this.MarketItemList.remove(item);		
	}
	
	public Transaction makeTransaction(Item item)
	{
		return new Transaction(item);
	}
	
	public void addTransaction(Transaction transaction)
	{
		this.MarketTransactionList.add(transaction);		
	}
}