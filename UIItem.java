import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UIItem extends JPanel
{
	public UIItem()
	{
		super();		
	    JLabel number = new JLabel("Number");
	    JLabel productName = new JLabel("Name");
	    JLabel category = new JLabel("Category");
	    JLabel quantity = new JLabel("Quantity");
	    JLabel sellerID = new JLabel("SellerID");
	    JButton order = new JButton("Order");
	    this.add(number);
	    this.add(productName);
	    this.add(category);
	    this.add(sellerID);
	    this.add(quantity);
	    this.add(order);
	}	
}