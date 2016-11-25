//package Userbase;
import java.util.ArrayList;

public class Seller extends User implements InventoryInterface
{

    private ArrayList<Item> items;

    public Seller () {}
		
    public Seller(String name, String pass, String email, Role role)
    {
		super(name, pass, email, role);
		items = new ArrayList<Item>();

    }

    public boolean updateItem(Item item) {
		throw new UnsupportedOperationException();
    }

    public ArrayList<Item> seeInventory() {
		throw new UnsupportedOperationException();
    }

    public boolean shipItem(Item item, Buyer buyer) {
		throw new UnsupportedOperationException();
    }

    public boolean notifyUser(Buyer buyer, String message) {
		throw new UnsupportedOperationException();
    }


    public Item viewItem(Item item) {
	return item;
    }

    public void editItem(Item item, String _itemID, String _name, Category _category, String _description, int _price, int _quantity, boolean _onSale) {
	
	for (int i = 0; i < items.size(); i++) {
	    if (items.get(i).equals(item)) {
		
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

    public void addItem(Item item) {
	this.items.add(item);
    }

    public void deleteItem(Item item) {
	for (int i = 0; i < items.size(); i++) {
	    if (items.get(i).equals(item)) {
		items.remove(item);
		break;
	}
    }
    
}