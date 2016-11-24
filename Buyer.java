//package Userbase;
import java.util.*;

public class Buyer extends User
{
	ShoppingCart _shoppingCart;
	
    public Buyer () {}
	
    public Buyer (String name, String pass, String email, Role role)
    {
		super(name, pass, email, role);
		_shoppingCart = new ShoppingCart();
    }

    public Item makePurchase(Item item) {
 		return new Item();
    }
    
    public void addToCart(Item item) {
 		this._shoppingCart.addItem(item);
    }
    
    public void removeFromCart(Item item) {
 		this._shoppingCart.removeItem(item);
    }

    public ArrayList<Item> searchItem(String name, String cat, int num) {
		return new ArrayList<Item>();
    }

    public ArrayList<Item> getOnSale(String cat) {
		return new ArrayList<Item>();
    }
}