//package Userbase;
import java.util.*;

public class Buyer extends User
{
	public ShoppingCart ShoppingCart;
	
    public Buyer () {}
	
    public Buyer (String name, String pass, String email, Role role)
    {
		super(name, pass, email, role);
		ShoppingCart = new ShoppingCart();
    }

    public Item makePurchase(Item item) {
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