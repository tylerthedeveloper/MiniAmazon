import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class BuyerPage extends UIPage
{
    public BuyerPage()
    {
	super();		
	//setting frame specifics
        JButton productList = new JButton("View Products");
        JButton searchProducts = new JButton("Search Products");
        JButton viewCategories = new JButton("View Categories");
        JButton shoppingCart = new JButton("Shopping Cart");
        shoppingCart.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
		  	{
				viewShoppingCart();
		  	}
		});
        UIItem itemSectionShort = new UIItem();
        Item item = new Item("itemID", "name", Item.Category.Electronics, "description", 50, 50, true, "sellerID");
        UIItem item1 = new UIItem(item);
        this.add(productList);
        this.add(searchProducts);
        this.add(viewCategories);
        this.add(shoppingCart);
        this.add(itemSectionShort);
        this.add(item1);
    }	
    
    
    public void viewShoppingCart() //Item item
	{
		//System.out.print(item.getPrice());
		UIItem itemSectionFull = new UIItem(true);
	    JDialog jd = new JDialog();
	    jd.setSize(new Dimension(400, 100));
        jd.setLocationRelativeTo(this);
        jd.setModal(true);
	    JPanel jdPan = new JPanel(true);
	    jdPan.add(itemSectionFull);
	    jd.add(jdPan);
		jd.setVisible(true);
	}

}