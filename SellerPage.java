import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.ImageIcon;

public class SellerPage extends UIPage
{	
    public SellerPage()
    {
		//super(new String[]{"View Products"});	
		super();
        jList = new JPanel();
        JButton productList = new JButton("View Products");
		productList.addActionListener(new ActionListener() 
		{		
			public void actionPerformed(ActionEvent e)
		  	{
				fillList(((Seller)App.User).seeMyInventory());		  	
			}
		});        
        //JButton searchProducts = new JButton("Search Products");
        JButton addItem = new JButton("Add item");
		addItem.addActionListener(new ActionListener() 
		{		
			public void actionPerformed(ActionEvent e)
		  	{
				//addItem();
				final JDialog addDialog = new JDialog();
				final JPanel itemInfo = enterItemInfo();
				JButton close = new JButton("Close");
				close.addActionListener(new ActionListener() 
				{
					public void actionPerformed(ActionEvent e)
				  	{
				  		addDialog.dispose();
				  	}
				});
				itemInfo.add(close);
				addDialog.add(itemInfo);
				addDialog.setSize(new Dimension(500, 300));
				addDialog.setModal(true);
				addDialog.setVisible(true);
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
        UIItem itemSectionShort = new UIItem(false);
        this.add(productList);
        this.add(addItem);
        //this.add(viewCategories);
        this.add(personIcon);
        this.add(itemSectionShort);
    }

	public JPanel enterItemInfo() 
	{
		//UIItem uiitem = new UIItem(true, true);	
	    //UIDialog sOdog = new UIDialog(uiitem, true);
	    
        JPanel addPan = new JPanel();
		final JTextField itemID = new JTextField("ItemID");
		final JTextField name = new JTextField("Name");
		final JLabel category = new JLabel("Category");
		final JTextField price = new JTextField("Price");
		final JTextField description = new JTextField("Description");
		final JTextField sellerID = new JTextField("SellerID");
		final JTextField quantity = new JTextField("Quantity");
		final ButtonGroup catGroup = new ButtonGroup();
		final JRadioButton elecButton = new JRadioButton("Electronics");
		elecButton.setSelected(true);
		final JRadioButton softButton = new JRadioButton("Software");
		final JRadioButton bookButton = new JRadioButton("Books");
    	catGroup.add(elecButton);
    	catGroup.add(softButton);
    	catGroup.add(bookButton);
    	final JLabel sale = new JLabel("Sale?");
    	final ButtonGroup saleGroup = new ButtonGroup();
		final JRadioButton yes = new JRadioButton("Yes");
		yes.setSelected(true);
		final JRadioButton no = new JRadioButton("No");
    	saleGroup.add(yes);
    	saleGroup.add(no);
		JButton addItemButton = new JButton("Add Item");
		addItemButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
		  	{
		  		Item.Category cat;
		  		
				if(elecButton.isSelected()) {
			  		cat = Item.Category.Electronics;
			  	}
			  		
			  	else if(softButton.isSelected()) {
			  		cat = Item.Category.Software;
			  	}
			  		
		  		else {
			  		cat = Item.Category.Books;		  		
			  	}
				
				
				boolean onSale;
		  		
				if(yes.isSelected()) {
			  		onSale = true;
			  	}
			  		
			  	else {
			  		onSale = false;
			  	}
			  	
		  		Item item = new Item(itemID.getText(), name.getText(), 
								  	cat, description.getText(), 	
								  	Integer.parseInt(price.getText()), 							
								  	Integer.parseInt(quantity.getText()), onSale,
								  	sellerID.getText());
								  
				if(App.User.getRole() == User.Role.Seller)
				{
					((Seller)App.User).addItem(item);
				}
				
				App.InvRepo.MarketItemList.add(item);
				
				add(new SellerUIItem(item, true));
				App.Window.validate();
				App.Window.revalidate();
				App.Window.repaint();
			}
		});
		addPan.add(itemID);
		addPan.add(name);
		addPan.add(category);
		addPan.add(elecButton);
		addPan.add(softButton);
		addPan.add(bookButton);
		addPan.add(price);
		addPan.add(sale);
		addPan.add(yes);
		addPan.add(no);
		addPan.add(description);
		addPan.add(sellerID);
		addPan.add(quantity);
		addPan.add(addItemButton);
    	return addPan;
	}
}
