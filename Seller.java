//package Userbase;
import java.util.ArrayList;

public class Seller extends User
{
    public Seller () {}
		
    public Seller(String name, String pass, String email, Role role)
    {
		super(name, pass, email, role);
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
    
}