//package Userbase;

public class Buyer extends User
{

    public Buyer () {}
	
    public Buyer (String name, String pass, String email, Role role)
    {
	super(name, pass, email, role);
    }

    public Item makePurchase(Item item) {
 
    }

    public ArrayList<Item> searchItem(String name, String cat, int num) {

    }

    public ArrayList<Item> getOnSale(String cat) {

    }
}