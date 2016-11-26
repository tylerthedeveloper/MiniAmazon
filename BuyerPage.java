import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.ImageIcon;
import java.util.ArrayList;


public class BuyerPage extends UIPage
{

	public static int shopCount;
	public static JLabel shopCounter;
	
    public BuyerPage()
    {
		super();		
		//setting frame specifics
        JButton productList = new JButton("View Products");
        jList = new JPanel();
		productList.addActionListener(new ActionListener() 
		{		
			public void actionPerformed(ActionEvent e)
		  	{
				fillList(App.InvRepo.MarketItemList);		  	
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
        UIItem itemSectionShort = new UIItem(false);
        this.add(productList);
        this.add(searchProducts);
        this.add(viewCategories);
        this.add(cartIcon);
        this.add(shopCounter);
        this.add(personIcon);
        this.add(itemSectionShort);
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
	
	public static void updateCart()
	{
		shopCounter.setText(String.valueOf(((Buyer)App.User).ShoppingCart.getCount()));
	}

}