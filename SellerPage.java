import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class SellerPage extends UIPage
{
    public SellerPage()
    {
	super();		
        //setting frame specifics
        JButton productList = new JButton("View Prodjwfjejgijucts");
        JButton searchProducts = new JButton("Searchefjiejgie Products");
        JButton viewCategories = new JButton("View Categories");
        this.add(productList);
        this.add(searchProducts);
        this.add(viewCategories);
    }	
}