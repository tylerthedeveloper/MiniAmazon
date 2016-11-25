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
	    JLabel price = new JLabel("Price");
	    JLabel onSale = new JLabel("Sale?");
	    JLabel view = new JLabel("View");
	    this.add(itemID);
	    this.add(productName);
	    this.add(category);
	    this.add(price);
	    this.add(onSale);
	    this.add(view);
	}
	
	public UIItem(boolean b)
	{
		super();		
	    JLabel itemID = new JLabel("ItemID");
	    JLabel productName = new JLabel("Name");
	    JLabel category = new JLabel("Category");
	    JLabel description = new JLabel("Description");
	    JLabel price = new JLabel("Price");
	    JLabel quantity = new JLabel("Quantity");
	    JLabel onSale = new JLabel("Sale?");
	    JLabel sellerID = new JLabel("SellerID");
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
	
	//item in list
	public UIItem(Item item)
	{
		super();		
	    final Item _item = item;
	    JLabel itemID = new JLabel(item.getItemID());
	    JLabel productName = new JLabel(item.getName());
	    JLabel category = new JLabel(item.getCategory().toString());
	    JLabel price = new JLabel(Integer.toString(item.getPrice()));
	    JLabel onSale = new JLabel(String.valueOf(item.getSale()));
	    JButton view = new JButton("View");
	    view.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
		  	{
				itemSelected(_item);
		  	}
		});
	    JButton add2Cart = new JButton("Add2Cart");
	    add2Cart.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
		  	{
				add2Cart(_item);
		  	}
		});
	    this.add(itemID);
	    this.add(productName);
	    this.add(category);
	    this.add(price);
	    this.add(onSale);
	    this.add(view);
	    this.add(add2Cart);
	}
	
	public UIItem(Item item, boolean b)
	{
		super();
		final Item _item = item;
	    JLabel itemID = new JLabel(item.getItemID());
	    JLabel productName = new JLabel(item.getName());
	    JLabel category = new JLabel(item.getCategory().toString());
	    JLabel description = new JLabel(item.getDescription());
	    JLabel price = new JLabel(Integer.toString(item.getPrice()));
		JLabel quantity = new JLabel(Integer.toString(item.getQuantity()));
	    JLabel onSale = new JLabel(String.valueOf(item.getSale()));
	    JLabel sellerID = new JLabel(item.getSellerID());
	    JButton order = new JButton("Order");
	    order.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
		  	{
				orderItem(_item);
		  	}
		});
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
	
	public void itemSelected(Item item) //Item item
	{
		UIItem itemSectionFull = new UIItem(true);
		Item _item = item;
	    JDialog jd = new JDialog();
	    jd.setSize(new Dimension(500, 300));
        jd.setLocationRelativeTo(this);
        jd.setModal(true);
	    JPanel jdPan = new JPanel(true);
	    jdPan.add(itemSectionFull);
	    jdPan.add(new UIItem(_item, true));
	    jd.add(jdPan);
		jd.setVisible(true);
	}
		
	public void add2Cart(Item item) //Item item
	{
		if(App.User instanceof Buyer) {
			((Buyer)App.User).addToCart(item);
			BuyerPage.updateCart();
		}
	}
	
	public void orderItem(Item item)
	{
		App.InvRepo.processOrder(item);		
	}
		
}