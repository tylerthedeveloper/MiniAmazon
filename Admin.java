//package Userbase;
//import Userbase.User;

public class Admin extends User
{
    public Admin () {}
	
    public Admin (String name, String pass, String email, Role role)
    {
	super(name, pass, email, role);
    }

    public void generateReport() 
    {

    }

    public ArrayList<Buyer> getBuyers() {
    
    }

    public ArrayList<Seller> getSellers() {

    }

    public boolean updateBuyer(Buyer buyer) {

    }

    public boolean updateSeller(Seller seller) {

    }

    public boolean updateItem(Item item) {

    }
    
}