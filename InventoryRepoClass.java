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

}