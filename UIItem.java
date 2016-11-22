import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UIItem extends JPanel
{
	//section headers
	public UIItem()
	{
		super();		
	    JLabel itemID = new JLabel("ItemID");
	    JLabel productName = new JLabel("Name");
	    JLabel category = new JLabel("Category");
	    JLabel description = new JLabel("Description");
	    JLabel price = new JLabel("Price");
	    JLabel quantity = new JLabel("Quantity");
	    JLabel sellerID = new JLabel("SellerID");
	    JLabel onSale = new JLabel("Sale?");
	    JLabel order = new JLabel("Order");
	    this.add(itemID);
	    this.add(productName);
	    this.add(category);
	    this.add(description);
	    this.add(price);
	    this.add(quantity);
	    this.add(onSale);
	    this.add(sellerID);
	    this.add(order);
	}
	
	//item
	//public UIItem(int _number, String _productName, String _category, String _sellerID, int _quantity)
	//int quantity, boolean onSale, String sellerID
	public UIItem(Item item)
	
	{
		super();		
	    JLabel itemID = new JLabel(item.getItemID());
	    JLabel productName = new JLabel(item.getName());
	    JLabel category = new JLabel(item.getCategory().toString());
	    JLabel description = new JLabel(item.getDescription());
	    JLabel price = new JLabel(Integer.toString(item.getPrice()));
	    JLabel quantity = new JLabel(Integer.toString(item.getQuantity()));
	    JLabel onSale = new JLabel(String.valueOf(item.getSale()));
	    JLabel sellerID = new JLabel(item.getSellerID());
	    JButton order = new JButton("Order");
	    this.add(itemID);
	    this.add(productName);
	    this.add(category);
	    this.add(description);
	    this.add(price);
	    this.add(quantity);
	    this.add(onSale);
	    this.add(sellerID);
	    this.add(order);
	}
}