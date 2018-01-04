package ui.pages;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.ImageIcon;

import inventoryrepo.Item;
import navigation.App;
import ui.renderers.UIDialog;
import ui.renderers.UIJPanel;
import ui.views.BuyerUIItem;
import ui.views.UIItem;

import java.util.ArrayList;


public class BuyerPage extends UIPage
{

	public static int shopCount;
	public static JLabel shopCounter;
	
    public BuyerPage()
    {
		super();	
		pageSetup();
	}
	
	public void pageSetup() 
	{
		//setting frame specifics
        JButton productList = new JButton("View Products");
        jList = new JPanel();
		productList.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
		  	{
				fillList(App.InvRepo.MarketItemList);		  	
			}
		});  
        JButton searchProducts = new JButton("Search Products");
        searchProducts.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
		  	{
		  		itemSearch();
		  	}
		});
        JButton viewCategories = new JButton("View Categories");
        viewCategories.addActionListener(new ActionListener() 
        {
			public void actionPerformed(ActionEvent e)
		  	{
		  		categorySearch();
		  	}
		});
        ImageIcon icon = new ImageIcon("./images/cart.png");
        JLabel cartIcon = new JLabel("", icon, JLabel.CENTER);
        cartIcon.addMouseListener(new MouseAdapter()
        {   
			public void mouseClicked(MouseEvent e)  
		  	{
				viewShoppingCart();
		  	}
		});
        ImageIcon person = new ImageIcon("images/person.png");
        JLabel personIcon = new JLabel("profile", person, JLabel.CENTER);
        personIcon.addMouseListener(new MouseAdapter()   
        {   
			public void mouseClicked(MouseEvent e)  
		  	{
				viewProfile();
		  	}
		});
        int cartCount = (int)((userbase.Buyer)App.User).ShoppingCart.getCount()+shopCount;
        shopCounter = new JLabel(String.valueOf(cartCount));
        UIItem itemSectionShort = new UIItem(false);
        this.add(productList);
        this.add(searchProducts);
        this.add(viewCategories);
        this.add(cartIcon);
        this.add(shopCounter);
        this.add(personIcon);
        this.add(itemSectionShort);
    }
    
    public void viewShoppingCart() //Item item
	{
		ArrayList<JComponent> arr = new ArrayList<JComponent>();
        arr.add(new UIItem(true));		
        for(Item item : ((userbase.Buyer)App.User).ShoppingCart.viewItems()) {
        	arr.add(new BuyerUIItem(item, true));
        }
        
        JButton checkout = new JButton("Checkout");
        checkout.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				checkOut();
			}
		});
        arr.add(checkout);		
		JDialog jd = new UIDialog(new UIJPanel(arr), true);
	}
	
	public static void updateCart()
	{
		shopCounter.setText(String.valueOf(((userbase.Buyer)App.User).ShoppingCart.getCount()));
	}

	public void itemSearch() 
	{
		final ButtonGroup searchGroup = new ButtonGroup();
		final JRadioButton itemID = new JRadioButton("ItemID");
		final JRadioButton itemName = new JRadioButton("ItemName");
		final JRadioButton itemCategory = new JRadioButton("Category");		
		itemID.setSelected(true);
		searchGroup.add(itemID); searchGroup.add(itemName);
        final JTextField searchBox = new JTextField("searchbar");
        final JButton searchButton = new JButton("Search");
		searchButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
		  	{
			  	jList.removeAll();
			  	
			  	String textSearch = searchBox.getText();
		  		if(itemID.isSelected()) {
			  		jList.add(new BuyerUIItem(App.InvRepo.searchForItem("ID", textSearch), true)); 
			  	} else {  
				  	jList.add(new BuyerUIItem(App.InvRepo.searchForItem("Name", textSearch), 			true)); 
				}
				
				JButton thisButton = (JButton)e.getSource();
				JComponent thisPanel = (UIJPanel)thisButton.getParent();										
				((JDialog)thisPanel.getTopLevelAncestor()).dispose();
				add(jList);
				App.Window.revalidate();
		       	App.Window.repaint();
			}
		});  
        	
		ArrayList<JComponent> arr = new ArrayList<JComponent>();
		arr.add(itemID); arr.add(itemName); arr.add(searchBox); arr.add(searchButton);
		JDialog jd = new UIDialog(new UIJPanel(arr), true);

	}
	
	public void categorySearch() 
	{
		final ButtonGroup searchGroup = new ButtonGroup();
		final JRadioButton eTron = new JRadioButton("Electronics");
		final JRadioButton sWare = new JRadioButton("Software");
		final JRadioButton books = new JRadioButton("Books");		
		eTron.setSelected(true);
		searchGroup.add(eTron); searchGroup.add(sWare); searchGroup.add(books);
        final JButton searchButton = new JButton("Search"); 
		searchButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
		  	{
		  		ArrayList<Item> itemList; 
		  		
		  				  		
		  		if(eTron.isSelected()) {
			  		itemList = App.InvRepo.catSearch("Electronics");
			  	} else if(sWare.isSelected()) { 
				  	itemList = App.InvRepo.catSearch("Software");
				} else { 
					itemList = App.InvRepo.catSearch("Books");
				}
				
				fillList(itemList);		  	
			}
		}); 
		ArrayList<JComponent> arr = new ArrayList<JComponent>();
		arr.add(eTron); arr.add(sWare); arr.add(books); arr.add(searchButton);
		JDialog jd = new UIDialog(new UIJPanel(arr), true);
	}
	
	public void checkOut()
	{
		//int n = ((Buyer)App.User).ShoppingCart.cartTotal;
		//System.out.print(n);
		ArrayList<JComponent> arr = new ArrayList<JComponent>();
		JPanel jp = new JPanel();
		jp.add(new JLabel("Your total is: " ));
		jp.add(new JLabel(String.valueOf(((userbase.Buyer)App.User).ShoppingCart.cartTotal)));
		JDialog jd = new UIDialog(jp, true);
		((userbase.Buyer)App.User).ShoppingCart.emptyCart();
		updateCart();
	}
}