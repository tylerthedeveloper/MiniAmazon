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
	    
        JPanel addPan = new JPanel();
		final JTextField itemID = new JTextField("ItemID");
		final JTextField name = new JTextField("Name");
		final JLabel category = new JLabel("Category");
		final JLabel priceLab = new JLabel("Price");
		Integer value = new Integer(1);
		Integer min = new Integer(1);
		Integer max = new Integer(1000);
		Integer step = new Integer(10);
		SpinnerNumberModel numModel = new SpinnerNumberModel(value, min, max, step);
		final JSpinner price = new JSpinner(numModel);		
		final JTextField description = new JTextField("Description");
		//final JTextField sellerID = new JTextField("SellerID");
		final JLabel quantity = new JLabel("Quantity");
		SpinnerNumberModel numModel2 = new SpinnerNumberModel(value, min, max, step);
		final JSpinner quantSpin = new JSpinner(numModel2);		
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
		JButton save = new JButton("Save");
		save.addActionListener(new ActionListener() 
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
								  	(Integer)price.getValue(), 							
								  	(Integer)quantSpin.getValue(), onSale, 
								  	App.User.getUserID());
								  
				if(App.User.getRole() == User.Role.Seller)
				{
					((Seller)App.User).addItem(item);
				}
				
				App.InvRepo.MarketItemList.add(item);
				
				add(new SellerUIItem(item, false));
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
		//addPan.add(sellerID);
		addPan.add(quantity);
		addPan.add(save);
    	return addPan;
	}
}
