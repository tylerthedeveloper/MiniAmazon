import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.ImageIcon;


public class BuyerPage extends UIPage
{

	public static int shopCount;
	public static JLabel shopCounter;
	
    public BuyerPage()
    {
		super();		
		//setting frame specifics
        JButton productList = new JButton("View Products");
        JButton searchProducts = new JButton("Search Products");
        JButton viewCategories = new JButton("View Categories");
        ImageIcon icon = new ImageIcon("cart.png");
        JLabel cartIcon = new JLabel("", icon, JLabel.CENTER);
        cartIcon.addMouseListener(new MouseAdapter()   
        {   
			public void mouseClicked(MouseEvent e)  
		  	{
				viewShoppingCart();
		  	}
		});
		ImageIcon person = new ImageIcon("person.png");
        JLabel personIcon = new JLabel("profile", person, JLabel.CENTER);
        personIcon.addMouseListener(new MouseAdapter()   
        {   
			public void mouseClicked(MouseEvent e)  
		  	{
				viewProfile();
		  	}
		});
        int cartCount = (int)((Buyer)App.User).ShoppingCart.getCount()+shopCount;
        shopCounter = new JLabel(String.valueOf(cartCount));
        UIItem itemSectionShort = new UIItem();
        //Item item = new Item("itemID", "name", Item.Category.Electronics, "description", 50, 50, true, "sellerID");
        UIItem item1 = new UIItem(new Item("itemID", "name", Item.Category.Electronics, "description", 50, 50, true, "sellerID"));
        UIItem item2 = new UIItem(new Item("itemID2", "name2", Item.Category.Electronics, "description2", 50, 50, true, "sellerID2"));
        this.add(productList);
        this.add(searchProducts);
        this.add(viewCategories);
        this.add(cartIcon);
        this.add(shopCounter);
        this.add(personIcon);
        this.add(itemSectionShort);
        this.add(item1);
        this.add(item2);
    }	
    
    
    public void viewShoppingCart() //Item item
	{
		UIItem itemSectionFull = new UIItem(true);
	    JDialog jd = new JDialog();
	    jd.setSize(new Dimension(500, 300));
        jd.setLocationRelativeTo(this);
        jd.setModal(true);
        JPanel jdPan = new JPanel(true);
        jdPan.add(itemSectionFull);
        for(Item item : ((Buyer)App.User).ShoppingCart.viewItems()) {
        	jdPan.add(new UIItem(item, true));
        }
	    jd.add(jdPan);
		jd.setVisible(true);
	}

	public void viewProfile()
	{
		JPanel jdPan = new JPanel(true);
	    JLabel userID = new JLabel("UserID");
	    JLabel name = new JLabel("Name");
	    JLabel email = new JLabel("Email");
	    JLabel role = new JLabel("Role");
	    jdPan.add(userID);
	    jdPan.add(name);
	    jdPan.add(email);	    
	    jdPan.add(role);
	    jdPan.add(App.User.showProfile());
	    JDialog jd = new JDialog();
	    jd.setSize(new Dimension(500, 300));
        jd.setModal(true);
	    jd.add(jdPan);
		//System.out.print(App.User.toString());
		//JPanel profile = App.User.showProfile();
		//jd.add(profile);
		jd.setLocationRelativeTo(this);
		jd.setVisible(true);
	}
	
	public static void updateCart()
	{
		shopCounter.setText(String.valueOf(((Buyer)App.User).ShoppingCart.getCount()));
	}
}