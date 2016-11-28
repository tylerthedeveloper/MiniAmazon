import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.ImageIcon;
import java.util.ArrayList;


public class BuyerPage extends UIPage
{

	public static int shopCount;
	public static JLabel shopCounter;
	
    public BuyerPage()
    {
		super();		
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
		  		searchWindow();
		  		//String textSearch = searchBox.getText();
		  		//System.out.print(textSearch);
		  	}
		});
        JButton viewCategories = new JButton("View Categories");
        ImageIcon icon = new ImageIcon("cart.png");
        JLabel cartIcon = new JLabel("", icon, JLabel.CENTER);
        cartIcon.addMouseListener(new MouseAdapter()
        {   
			public void mouseClicked(MouseEvent e)  
		  	{
				viewShoppingCart();
		  	}
		});
		ImageIcon person = new ImageIcon("person.png");
        JLabel personIcon = new JLabel("profile", person, JLabel.CENTER);
        personIcon.addMouseListener(new MouseAdapter()   
        {   
			public void mouseClicked(MouseEvent e)  
		  	{
				viewProfile();
		  	}
		});
        int cartCount = (int)((Buyer)App.User).ShoppingCart.getCount()+shopCount;
        shopCounter = new JLabel(String.valueOf(cartCount));
        UIItem itemSectionShort = new UIItem(false);
        this.add(productList);
        //this.add(itemID);
        //this.add(itemName);
        //this.add(itemCategory);
        //this.add(searchBox);
        this.add(searchProducts);
        this.add(viewCategories);
        this.add(cartIcon);
        this.add(shopCounter);
        this.add(personIcon);
        this.add(itemSectionShort);
    }
    
    public void viewShoppingCart() //Item item
	{
		UIItem itemSectionFull = new UIItem(true);
	    JDialog jd = new JDialog();
	    jd.setSize(new Dimension(500, 300));
        jd.setLocationRelativeTo(this);
        jd.setModal(true);
        JPanel jdPan = new JPanel(true);
        jdPan.add(itemSectionFull);
        for(Item item : ((Buyer)App.User).ShoppingCart.viewItems()) {
        	jdPan.add(new BuyerUIItem(item, true));
        }
	    jd.add(jdPan);
		jd.setVisible(true);
	}
	
	public static void updateCart()
	{
		shopCounter.setText(String.valueOf(((Buyer)App.User).ShoppingCart.getCount()));
	}

	public void searchWindow() 
	{
		final ButtonGroup searchGroup = new ButtonGroup();
		final JRadioButton itemID = new JRadioButton("ItemID");
		final JRadioButton itemName = new JRadioButton("ItemName");
		final JRadioButton itemCategory = new JRadioButton("Category");		
		itemID.setSelected(true);
		searchGroup.add(itemID);
		searchGroup.add(itemName);
//		searchGroup.add(itemCategory);
        final JTextField searchBox = new JTextField("searchbar");
        final JButton searchButton = new JButton("Search");
        final JDialog jd = new JDialog();
		searchButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
		  	{
			  	String textSearch = searchBox.getText();
		  		if(itemID.isSelected()) {
			  		add(new BuyerUIItem(App.InvRepo.searchForItem("ID", textSearch), true)); 
			  	} else {  
				  	add(new BuyerUIItem(App.InvRepo.searchForItem("Name", textSearch), true)); 
				}
				
  		       	App.Window.revalidate();
		       	App.Window.repaint();
				jd.dispose();
			}
		});  
        
        JPanel jdPan = new JPanel(true);
        jdPan.add(itemID);
        jdPan.add(itemName);
//        jdPan.add(itemCategory);
        jdPan.add(searchBox);
        jdPan.add(searchButton);
	    jd.setSize(new Dimension(500, 300));
        jd.setModal(true);
	    jd.add(jdPan);
		jd.setLocationRelativeTo(this);
		jd.setVisible(true);
	}
}