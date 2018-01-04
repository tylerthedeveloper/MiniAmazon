package ui.views;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import ui.helpers.*;
import inventoryrepo.*;
import ui.renderers.*;

public class SellerUIItem extends JPanel
{
	static JLabel quantity;
	JDialog addDialog;
	UIItemHelper uHelper = new UIItemHelper();

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
				uHelper.deleteItem(_item);
				removeItem();
			}
		});

		JButton editItem = new JButton("Edit item");

	    if(!b) {
			editItem.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
			  	{

					//addDialog = new JDialog();
					JPanel jp = new JPanel();
					jp.add(enterItemInfoPanel(_item));
					jp.setSize(new Dimension(300, 400));
					jp.setLayout(new BoxLayout(jp, BoxLayout.Y_AXIS));
					JDialog sOdog = new UIDialog(jp, true);
					validate();
					revalidate();
					repaint();
				}
			});

			this.add(editItem);
			this.add(delete);

		}
	}

	JRadioButton elecButton;
	JRadioButton bookButton;
	JRadioButton softButton;
	JRadioButton yes;
	JRadioButton no;
	
	public JPanel enterItemInfoPanel(Item item)
	{

	    final Item _item = item;
        JPanel addPan = new JPanel();
		final JTextField itemID = new JTextField("ItemID");
		final JTextField name = new JTextField("Name");
		Integer value = new Integer(1);
		Integer min = new Integer(1);
		Integer max = new Integer(1000);
		Integer step = new Integer(10);
		SpinnerNumberModel numModel = new SpinnerNumberModel(value, min, max, step);
		final JSpinner price = new JSpinner(numModel);
		final JTextField description = new JTextField("Description");
		final JTextField sellerID = new JTextField("SellerID");
		SpinnerNumberModel numModel2 = new SpinnerNumberModel(value, min, max, step);
		final JSpinner quantSpin = new JSpinner(numModel2);
		final ButtonGroup catGroup = new ButtonGroup();
		elecButton = new JRadioButton("Electronics");
		elecButton.setSelected(true);
		softButton = new JRadioButton("Software");
		bookButton = new JRadioButton("Books");
    	catGroup.add(elecButton);
    	catGroup.add(softButton);
    	catGroup.add(bookButton);
    	final ButtonGroup saleGroup = new ButtonGroup();
		yes = new JRadioButton("Yes");
		yes.setSelected(true);
		no = new JRadioButton("No");
    	saleGroup.add(yes);
    	saleGroup.add(no);
		final JButton save = new JButton("Save");
		save.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
		  	{

		  		editInfo(_item, itemID.getText(), name.getText(),
								  	description.getText(),
								  	(Integer)price.getValue(),
								  	(Integer)quantSpin.getValue());
				addItem(_item);
				removeItem();
				//addDialog.dispose();
				JPanel thisPanel = (JPanel)save.getParent();
				((JDialog)thisPanel.getTopLevelAncestor()).dispose();
			}
		});

		addPan.add(itemID);
		addPan.add(name);
		addPan.add(new JLabel("Category"));
		addPan.add(elecButton);
		addPan.add(softButton);
		addPan.add(bookButton);
		addPan.add(new JLabel("Price"));
		addPan.add(price);
		addPan.add(new JLabel("Sale?"));
		addPan.add(yes);
		addPan.add(no);
		addPan.add(description);
		addPan.add(sellerID);
		addPan.add(new JLabel("Quantity"));
		addPan.add(quantSpin);
		addPan.add(save);
    	return addPan;
	}


	public void editInfo(Item _item, String _itemID, String _name,
    		String _description, int _price, int _quantity)
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

		boolean _onSale;

		if(yes.isSelected()) {
			_onSale = true;
		}

		else {
			_onSale = false;
		}


		_item.editItem(_itemID, _name, cat, _description, _price, _quantity,
						_onSale);
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
