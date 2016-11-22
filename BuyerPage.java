import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class BuyerPage extends UIPage
{
	public BuyerPage()
	{
		super();		
		//System.out.print(App.User.name);
	    //setting frame specifics
	    JButton productList = new JButton("View Products");
	    JButton searchProducts = new JButton("Search Products");
	    JButton viewCategories = new JButton("View Categories");
	    this.add(productList);
	    this.add(searchProducts);
	    this.add(viewCategories);
	}	
}