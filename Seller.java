//package Userbase;

public class Seller extends User
{
    public Seller () {}
		
    public Seller(String name, String pass, String email, Role role)
    {
	super(name, pass, email, role);
    }

    public boolean updateItem(Item item) {

    }

    public ArrayList<Item> seeInventory() {

    }

    public boolean shipItem(Item item, Buyer buyer) {

    }

    public boolean notifyUser(Buyer buyer, String message) {

    }
    
}