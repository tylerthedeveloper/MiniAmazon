package inventoryrepo;

import java.util.*;

public class ShoppingCart {

    private ArrayList<Item> cart;
    private int count;
	public int cartTotal = 0;
	
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
    
    public int cartTotal() {
		
		int sum = 0;
		
		for(Item item : cart) {
			sum += item.getPrice();	
		}

		return sum;
    }
    
    public void updateTotal(int price, int quant) {
    	cartTotal+= (price * quant);
    }
    
    public void emptyCart() {
		cart.clear();
		count = 0;
		cartTotal = 0;
    }
    
    public boolean contains(Item item) {
		return cart.contains(item);
    }
}