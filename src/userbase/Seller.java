package userbase;

import java.util.ArrayList;

import inventoryrepo.Item;

public class Seller extends User
{

    private ArrayList<Item> _items;

    public Seller () {}
		
    public Seller(String name, String pass, String email, Role role)
    {
		super(name, pass, email, role);
		_items = new ArrayList<Item>();
		addItem(new Item("itemID", "name", Item.Category.Electronics, "description", 50, 50, true, "sellerID"));
        addItem(new Item("seller", "seller", Item.Category.Electronics, "description2", 50, 50, true, "sellerID2"));

    }

    public ArrayList<Item> seeMyInventory() {
		return this._items;
	}

    public void addItem(Item item) {
		this._items.add(item);
    }

    public void deleteItem(Item item) {
		for (int i = 0; i < _items.size(); i++) {
			if (_items.get(i).equals(item)) {
				_items.remove(item);
				break;
			}
    		}
	}
	
	public boolean exists(Item item) {
		return _items.contains(item);
	}
    
   
}
