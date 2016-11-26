//package Userbase;
import java.util.ArrayList;

public class Seller extends User //implements InventoryInterface
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

    public boolean updateItem(Item item) {
		throw new UnsupportedOperationException();
    }

    public ArrayList<Item> seeMyInventory() {
		return this._items;
	}

    public boolean shipItem(Item item, Buyer buyer) {
		throw new UnsupportedOperationException();
    }

    public boolean notifyUser(Buyer buyer, String message) {
		throw new UnsupportedOperationException();
    }

    /*
    public Item viewItem(Item item) {
		return item;
    }

	/*
    public void editItem(Item item, String _itemID, String _name, Category _category, 
    					String _description, int _price, int _quantity, boolean _onSale) {
	
	for (int i = 0; i < _items.size(); i++) {
	    if (_items.get(i).equals(item)) {
		
		if (_itemID != null) {	
		    item.setItemId(_itemID);
		}

		if (_name != null) {
		    item.setName(_name);
		}

		if (_category != null) {
                    item.setCategory(_category);
                }

		if (_description != null) {
                    item.setDescription(_description);
                }

		if (_price != null) {
                    item.setPrice(_price);
                }

		if (_quantity != null) {
                    item.setQuantity(_quantity);
                }

		if (_onSale != null) {
                    item.setOnSale(_onSale);
                }
	    }

	    break;

		}

    }
	*/

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
    
   
}