import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.ImageIcon;

public class SellerPage extends UIPage
{

	public static int shopCount;
	public static JLabel shopCounter;
	
    public SellerPage()
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
        int cartCount = 1;
        shopCounter = new JLabel(String.valueOf(cartCount));
        UIItem itemSectionShort = new UIItem();
        this.add(productList);
        this.add(searchProducts);
        this.add(viewCategories);
        this.add(cartIcon);
        this.add(shopCounter);
        this.add(personIcon);
        this.add(itemSectionShort);
    	for(Item item : ((Seller)App.User).seeMyInventory()) {
        	this.add(new UIItem(item));
        }
    }
    
}
public class SellerPage extends UIPage
{

	public static int shopCount;
	public static JLabel shopCounter;
	
    public SellerPage()
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
        int cartCount = 1;
        shopCounter = new JLabel(String.valueOf(cartCount));
        UIItem itemSectionShort = new UIItem();
        this.add(productList);
        this.add(searchProducts);
        this.add(viewCategories);
        this.add(cartIcon);
        this.add(shopCounter);
        this.add(personIcon);
        this.add(itemSectionShort);
    	for(Item item : ((Seller)App.User).seeMyInventory()) {
        	this.add(new UIItem(item));
        }
    }
    
}