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

    public Item makePurchase(Item item) {
    	//make new transaction
    	//
    	MyItemList.add(item);
    	System.out.print(MyItemList.get(0));
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