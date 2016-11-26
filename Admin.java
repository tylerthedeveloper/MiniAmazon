//package Userbase;
//import Userbase.User;
import java.util.ArrayList;

public class Admin extends User implements InventoryInterface
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

    public boolean updateBuyer(Buyer buyer) {
	    throw new UnsupportedOperationException();
    }

    public boolean updateSeller(Seller seller) {
	    throw new UnsupportedOperationException();
    }

    public boolean updateItem(Item item) {
	    throw new UnsupportedOperationException();
    }
    

    public Item viewItem() {

    }

    public void editItem() {

    }

    public void addItem() {

    }

    public void deleteItem() {

    }
}