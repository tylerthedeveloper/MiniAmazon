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
	
	public UIItem(int _number, String _productName, String _category, 
				String _sellerID, int _quantity)
	{
		super();		
	    JLabel number = new JLabel(Integer.toString(_number));
	    JLabel productName = new JLabel(_productName);
	    JLabel category = new JLabel(_category);
	    JLabel sellerID = new JLabel(_sellerID);
	    JLabel quantity = new JLabel(Integer.toString(_quantity));
	    JButton order = new JButton("Order");
	    this.add(number);
	    this.add(productName);
	    this.add(category);
	    this.add(sellerID);
	    this.add(quantity);
	    this.add(order);
	}
}