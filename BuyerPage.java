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
	    UIItem itemSection = new UIItem();
	    this.add(productList);
	    this.add(searchProducts);
	    this.add(viewCategories);
	    this.add(textArea);
	    this.add(itemSection);	    
	}	
}