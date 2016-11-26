import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class SellerPage extends UIPage
{
    public SellerPage()
    {
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
