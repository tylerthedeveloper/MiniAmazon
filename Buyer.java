//package Userbase;
import java.util.*;

public class Buyer extends User
{
	public ShoppingCart ShoppingCart;
	public ArrayList<Item> ItemList;
	public ArrayList<Transaction> TransactionList;
	
    public Buyer () {}
	
    public Buyer (String name, String pass, String email, Role role)
    {
		super(name, pass, email, role);
		ShoppingCart = new ShoppingCart();
		ItemList = new ArrayList<Item>();
		TransactionList = new ArrayList<Transaction>();
    }

    public Item makePurchase(Item item) {
    	//make new transaction
    	//
    	ItemList.add(item);
    	System.out.print(ItemList.get(0));
 		return new Item();
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