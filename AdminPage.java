import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class AdminPage extends UIPage
{
    public AdminPage()
    {
	super();		
	//setting frame specifics
	JButton productList = new JButton("View Products");
	JButton searchProducts = new JButton("Search Products");
	JButton viewCategories = new JButton("View Categories");
	this.add(productList);
	this.add(searchProducts);
	this.add(viewCategories);
    }	
}