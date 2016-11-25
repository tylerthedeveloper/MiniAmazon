//package Userbase;
import java.util.*;

public class Buyer extends User
{
	public ShoppingCart ShoppingCart;
	public ArrayList<Item> MyItemList;
	public ArrayList<Transaction> MyTransactionList;
	
    public Buyer () {}
	
    public Buyer (String name, String pass, String email, Role role)
    {
		super(name, pass, email, role);
		ShoppingCart = new ShoppingCart();
		MyItemList = new ArrayList<Item>();
		MyTransactionList = new ArrayList<Transaction>();
    }

    public HashMap<Item, Transaction> makePurchase(Item item, Transaction transaction) {
    	//make new transaction
    	MyItemList.add(item);
    	MyTransactionList.add(transaction);
 		return new HashMap<Item, Transaction>();
    }
    
    public void addToCart(Item item) {
 		this.ShoppingCart.addItem(item);
    }
    
    public void removeFromCart(Item item) {
 		this.ShoppingCart.removeItem(item);
    }

    public ArrayList<Item> searchItem(String name, String cat, int num) {
		return new ArrayList<Item>();
    }

    public ArrayList<Item> getOnSale(String cat) {
		return new ArrayList<Item>();
    }
}