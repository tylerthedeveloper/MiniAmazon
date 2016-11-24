import java.util.*;

public class ShoppingCart {

    private ArrayList<Item> cart;

    public ShoppingCart() {
		cart = new ArrayList<Item>();
    }

    public void addItem(Item item) {
		this.cart.add(item);
    }
    
    public void removeItem(Item item) {
		this.cart.remove(item);
    }

    public void view() {

    }

    public void update() {

    }

    public void checkout() {

    }

}