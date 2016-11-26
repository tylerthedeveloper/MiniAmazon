import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;


public class UIItem extends JPanel
{

	/*
	JLabel itemID; // = new JLabel("ItemID");
	JLabel productName; // = new JLabel("Name");
	JLabel category; // = new JLabel("Category");
	JLabel description; // = new JLabel("Description");
	JLabel price; // = new JLabel("Price");
	JLabel quantity; // = new JLabel("Quantity");
	JLabel onSale; // = new JLabel("Sale?");
	JLabel sellerID; // = new JLabel("SellerID");
	JLabel view; //
	JLabel orderLabel; // = new JLabel("Order");

	//section headers
	
	public UIItem()
	{
		super();		
	    /*
	    itemID = new JLabel("ItemID");
	 	productName = new JLabel("Name");
	    category = new JLabel("Category");
	    price = new JLabel("Price");
	    onSale = new JLabel("Sale?");
	    view = new JLabel("View");
	    this.add(itemID);
	    this.add(productName);
	    this.add(category);
	    this.add(price);
	    this.add(onSale);
	    
	    this.add(new JLabel("ItemID"));
	    this.add(new JLabel("Name"));
	    this.add(new JLabel("Category"));
	    this.add(new JLabel("Price"));
	    this.add(new JLabel("Sale?"));
	    this.add(new JLabel("View"));
	}
			/*
	    JLabel itemID = new JLabel("ItemID");
	    JLabel productName = new JLabel("Name");
	    JLabel category = new JLabel("Category");
	    JLabel description = new JLabel("Description");
	    JLabel price = new JLabel("Price");
	    JLabel quantity = new JLabel("Quantity");
	    JLabel onSale = new JLabel("Sale?");
	    JLabel sellerID = new JLabel("SellerID");
		JLabel orderLabel = new JLabel("Order");
	    this.add(itemID);
	    this.add(productName);
	    this.add(category);
	    this.add(description);
	    this.add(price);
	    this.add(quantity);
	    this.add(onSale);
	    this.add(sellerID);
	    this.add(orderLabel);
	
	
			/*
		final Item _item = item;
	    JLabel itemID = new JLabel(item.getItemID());
	    JLabel productName = new JLabel(item.getName());
	    JLabel category = new JLabel(item.getCategory().toString());
	    JLabel description = new JLabel(item.getDescription());
	    JLabel price = new JLabel(Integer.toString(item.getPrice()));
		quantity = new JLabel(Integer.toString(item.getQuantity()));
	    JLabel onSale = new JLabel(String.valueOf(item.getSale()));
	    JLabel sellerID = new JLabel(item.getSellerID());
	    
	    Integer value = new Integer(item.getQuantity());
		Integer min = new Integer(0);
		Integer max = new Integer(item.getQuantity());
		Integer step = new Integer(1);
		//final SpinnerNumberModel numModel = new SpinnerNumberModel(value, min, max, step);
		numModel = new SpinnerNumberModel(value, min, max, step);
		final JSpinner spinner = new JSpinner(numModel);
		if(inStock(_item))
			order = new JButton("Order");
		else
			order = new JButton("Out-Of-Stock");
	    order.addActionListener(new ActionListener() 
		{		
			public void actionPerformed(ActionEvent e)
		  	{
			  	int amountDesired = (int)spinner.getValue();
				if(_item.getQuantity() >= amountDesired && inStock(_item)) {
					orderItem(_item, amountDesired);
				} else if(inStock(_item)) {
					underStock(_item);
				} else {
					stockOut(_item);
				}
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
	    this.add(spinner);
	    this.add(order);
	
	
	    
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
	*/
	
	public UIItem(boolean b)
	{
		super();		
		this.add(new JLabel("ItemID"));
		this.add(new JLabel("Name"));
		this.add(new JLabel("Category"));
		this.add(new JLabel("Price"));
		this.add(new JLabel("Sale?"));

	    if(!b) {			
			this.add(new JLabel("View"));
		}
		else {
			this.add(new JLabel("Description"));
			this.add(new JLabel("SellerID"));
			this.add(new JLabel("Quantity"));
			this.add(new JLabel("Order"));
		}

	}
	
	static SpinnerNumberModel numModel; 
	static JButton order;
	static JLabel quantity;
	
	public UIItem(Item item, boolean b)
	{
		super();
	    final Item _item = item;
		this.add(new JLabel(item.getItemID()));
		this.add(new JLabel(item.getName()));
		this.add(new JLabel(item.getCategory().toString()));
		this.add(new JLabel(Integer.toString(item.getPrice())));
		this.add(new JLabel(String.valueOf(item.getSale())));
		Integer value = new Integer(item.getQuantity());
		Integer min = new Integer(0);
		Integer max = new Integer(item.getQuantity());
		Integer step = new Integer(1);
		numModel = new SpinnerNumberModel(value, min, max, step);
		final JSpinner spinner = new JSpinner(numModel);
		
	    if(!b) {			
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
			this.add(view);
			this.add(add2Cart);
		}
		else {
			this.add(new JLabel(item.getDescription()));
			if(_item.inStock()) { 
					order = new JButton("Order");
			} else {
				order = new JButton("Out-Of-Stock");
			}
			order.addActionListener(new ActionListener() 
			{		
				public void actionPerformed(ActionEvent e)
				{
					int amountDesired = (int)spinner.getValue();
					if(_item.getQuantity() >= amountDesired && _item.inStock()) {
						orderItem(_item, amountDesired);
					} else if(_item.inStock()) {
						underStock(_item);
					} else {
						stockOut(_item);
					}
				}
			});
			quantity = new JLabel(Integer.toString(item.getQuantity()));
			this.add(new JLabel(item.getSellerID()));
			this.add(quantity);
			this.add(spinner);
			this.add(order);
		}
	}
	
	public void itemSelected(Item item) 
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
	

	public void orderItem(Item item, int amountToOrder)
	{
		System.out.println("in order");
		App.InvRepo.processOrder(item, amountToOrder);
		updateItemCount(item);
		if(!item.inStock()) order.setText("Out-of-stock");
	}


	public void updateItemCount(Item item)
	{
		quantity.setText(String.valueOf(item.getQuantity()));
		numModel.setValue(0);
	}
	
	public void underStock(Item item)
	{
		ArrayList<JComponent> arr = new ArrayList<JComponent>();
	    arr.add(new JLabel("Stockout for: "));
	    arr.add(new JLabel(item.getName() + ". "));
	    arr.add(new JLabel("We are sorry, but we do not have that many in stock"));
	    JPanel uiPan = new UIJPanel(arr);
	    JDialog jd = new JDialog();
	    jd.setSize(new Dimension(500, 300));
        jd.setModal(true);
	    jd.add(uiPan);
		jd.setLocationRelativeTo(this);		
		jd.setVisible(true);
	}

	
	public void stockOut(Item item)
	{
		//order.setText("Out-of-stock");
	    ArrayList<JComponent> arr = new ArrayList<JComponent>();
	    arr.add(new JLabel("Understock for: "));
	    arr.add(new JLabel(item.getName() + ". "));
	    arr.add(new JLabel("we are sorry, but that item is out of stock. "));
	    arr.add(new JLabel("We will notify you when it returns "));	    					
	    JPanel uiPan = new UIJPanel(arr);
	    JDialog jd = new JDialog();
	    jd.setSize(new Dimension(500, 300));
        jd.setLocationRelativeTo(this);
        jd.setModal(true);
	    jd.add(uiPan);
		jd.setVisible(true);
	}
	
	
}