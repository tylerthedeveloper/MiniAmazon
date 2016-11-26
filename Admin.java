//package Userbase;
//import Userbase.User;
import java.util.ArrayList;

public class Admin extends User
{
    public Admin () {}
	
    public Admin (String name, String pass, String email, Role role)
    {
	super(name, pass, email, role);
    }

    public void generateReport() 
    {
	    throw new UnsupportedOperationException();
    }

    public ArrayList<Buyer> getBuyers() {
	    throw new UnsupportedOperationException();
    }

    public ArrayList<Seller> getSellers() {
	    throw new UnsupportedOperationException();
    }


	public ArrayList<Item> sellerItems(Seller s) {
		
		ArrayList<Item> sItems = new ArrayList<Item>();
	
		for (Item item : App.InventoryRepoClass.MarketItemList) {
		
			if (item.getSellerID.equals(s.getUserID)) {
				sItems.add(item);
			}
		}
		
		return sItems;
	}

    public boolean updateItem(Item item) {
	    throw new UnsupportedOperationException();
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
    
    public void editBuyer(Buyer b, String name, String pass, String email) {
    	for (User user: App.UserBaseClass) {
    	
    		if (user istanceof Buyer) {
    			current = ((Buyer)user);
    			if(current.equals(b)) {
    				
    				if (name != null) {
    					user.setName(name);
    				}
    				
    				if (pass != null) {
    					user.setPass(pass);
    				}
    				
    				if (email != null) {
    					user.setEmail(email);	
    				}
    				break;
    			}
    		}
    	}
    }
    	
    public void editSeller(Seller s, String name, String pass, String email) {
    	for (User user: App.UserBaseClass.UserList) {
    	
    		if (user istanceof Seller) {
    			current = ((Seller)user);
    			if(current.equals(s)) {
    				
    				if (name != null) {
    					user.setName(name);
    				}
    				
    				if (pass != null) {
    					user.setPass(pass);
    				}
    				
    				if (email != null) {
    					user.setEmail(email);	
    				}
    				break;
    			}
    		}
    	}
    }
	
}