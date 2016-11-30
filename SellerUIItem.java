import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class SellerUIItem extends JPanel
{
	static JLabel quantity;
	JDialog addDialog;
	
	public SellerUIItem(Item item, boolean b)
	{
		super();
	    final Item _item = item;
		this.add(new JLabel(item.getItemID()));
		this.add(new JLabel(item.getName()));
		this.add(new JLabel(item.getCategory().toString()));
		this.add(new JLabel(Integer.toString(item.getPrice())));
		this.add(new JLabel(String.valueOf(item.getOnSale())));
		this.add(new JLabel(item.getDescription()));
		quantity = new JLabel(Integer.toString(item.getQuantity()));
		this.add(new JLabel(item.getSellerID()));
		this.add(quantity);
			
		
		JButton delete = new JButton("delete");
		delete.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				UIItemHelper.deleteItem(_item);
				removeItem();
				App.Window.validate();
				App.Window.revalidate();
				App.Window.repaint();	
			}
		});
				
		JButton editItem = new JButton("Edit item");
		
	    if(!b) {					
			editItem.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e)
			  	{
			
					addDialog = new JDialog();
					final JPanel itemPanel = new JPanel();
					JButton close = new JButton("Close");
					SellerUIItem sellerItem = new SellerUIItem(_item, true);
					close.addActionListener(new ActionListener() 
					{
						public void actionPerformed(ActionEvent e)
						{
							addDialog.dispose();
							App.Window.validate();
							App.Window.revalidate();
							App.Window.repaint();
						}
					});
								
					
					JPanel itemInfo = enterItemInfo(_item);
					itemPanel.add(sellerItem);
					itemPanel.add(itemInfo);
					itemPanel.add(close);
					addDialog.add(itemPanel);
					addDialog.setLocationRelativeTo(((JButton)e.getSource()));
					addDialog.setSize(new Dimension(700, 600));
					addDialog.setModal(true);
					addDialog.setVisible(true);
					add(sellerItem);
					validate();
					revalidate();
					repaint();
				}
			});     
			
			this.add(editItem);
			this.add(delete);
			
			}

			
	}
	
	public JPanel enterItemInfo(Item item) 
	{
		
	    final Item _item = item;
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
		final JTextField sellerID = new JTextField("SellerID");
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
			  	
		  		_item.editItem(_item, itemID.getText(), name.getText(), 
								  	cat, description.getText(), 	
								  	(Integer)price.getValue(), 							
								  	(Integer)quantSpin.getValue(), onSale);
				
				addItem(_item);
				removeItem();
				addDialog.dispose();
			}
		});
		addPan.add(itemID);
		addPan.add(name);
		addPan.add(category);
		addPan.add(elecButton);
		addPan.add(softButton);
		addPan.add(bookButton);
		addPan.add(priceLab);
		addPan.add(price);
		addPan.add(sale);
		addPan.add(yes);
		addPan.add(no);
		addPan.add(description);
		addPan.add(sellerID);
		addPan.add(quantity);
		addPan.add(quantSpin);
		addPan.add(save);
    	return addPan;
	}
	
	public void removeItem()
	{
		Container parent = getParent();
		parent.remove(this);
		parent.validate();
		parent.revalidate();
		parent.repaint();	
	}
	
	public void addItem(Item item)
	{
		Container parent = getParent();
		parent.add(new SellerUIItem(item, false));
		parent.validate();
		parent.revalidate();
		parent.repaint();		
	}
}