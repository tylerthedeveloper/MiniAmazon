import java.util.*;

public class ShoppingCart {

    private ArrayList<Item> cart;
    private int count;

    public ShoppingCart() {
		cart = new ArrayList<Item>();
    }

    public void addItem(Item item) {
		this.count++;
		this.cart.add(item);
    }
    
    public void removeItem(Item item) {
		this.count--;
		this.cart.remove(item);
    }

    public ArrayList<Item> viewItems() {
		return cart;
    }
    
    public int getCount() {
		return count;
    }

    public void update() {

    }

    public void checkout() {

    }

}