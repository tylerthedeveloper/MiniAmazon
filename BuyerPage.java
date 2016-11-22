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
	    Item item = new Item("itemID", "name", Item.Category.Electronics, "description", 50, 50, true, "sellerID");
	    //UIItem itemSection = new UIItem(10, "name", "category", "sellerID", 50);
	    UIItem item1 = new UIItem(item);
	    this.add(productList);
	    this.add(searchProducts);
	    this.add(viewCategories);
	    this.add(itemSection);
	    this.add(item1);
	    System.out.println(App.UsrBase.UserList.get(0).toString());
	}	
}