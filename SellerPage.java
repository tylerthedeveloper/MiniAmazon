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
<<<<<<< HEAD
		super();	
		JPanel panel = new JPanel();
		
        //setting frame specifics
        JButton productList = new JButton("View Products");
        JButton searchProducts = new JButton("Search Products");
        JButton viewCategories = new JButton("View Categories");
        
        this.add(productList);
        this.add(searchProducts);
        this.add(viewCategories);
        
        productList.addActionListener(new ActionListener() 
        {
        	public void actionPerformed(ActionEvent e) {
        		viewInventory();
        		//panel.add(new JLabel("Hello"));
        		//System.out.println("the button was clicked");
        	}
        });
	}

		public void viewInventory()
		{
			this.panel.add(new JLabel("Hello"));
		}
		
}	
=======
		super();		
		//setting frame specifics
        JButton productList = new JButton("View Products");
        jList = new JPanel();
		productList.addActionListener(new ActionListener() 
		{		
			public void actionPerformed(ActionEvent e)
		  	{
				fillList(((Seller)App.User).seeMyInventory());		  	
			}
		});        
        JButton searchProducts = new JButton("Search Products");
        JButton viewCategories = new JButton("View Categories");
        ImageIcon icon = new ImageIcon("cart.png");
        JLabel cartIcon = new JLabel("", icon, JLabel.CENTER);
        cartIcon.addMouseListener(new MouseAdapter()   
        {   
			public void mouseClicked(MouseEvent e)  
		  	{
				//viewShoppingCart();
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
        UIItem itemSectionShort = new UIItem(false);
        this.add(productList);
        this.add(searchProducts);
        this.add(viewCategories);
        this.add(cartIcon);
        this.add(shopCounter);
        this.add(personIcon);
        this.add(itemSectionShort);
    }
        
}
>>>>>>> 345df57b6571ce0ed0198d6556cb4c1839448adc
