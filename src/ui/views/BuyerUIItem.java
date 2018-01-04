package ui.views;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

import inventoryrepo.*;
import ui.helpers.*;

public class BuyerUIItem extends JPanel
{
	SpinnerNumberModel numModel; 
	public JButton order;
	JLabel quantity;

	public BuyerUIItem(Item item, boolean b)
	{
		super();
		final UIItemHelper itemHelper = new UIItemHelper();
		if(item.getItemID() == null) 
		{
			UIItemHelper.itemNotFound();
		}
		
		else {
			final Item _item = item;
			this.add(new JLabel(item.getItemID()));
			this.add(new JLabel(item.getName()));
			this.add(new JLabel(item.getCategory().toString()));
			this.add(new JLabel(Integer.toString(item.getPrice())));
			this.add(new JLabel(String.valueOf(item.getOnSale())));
			Integer value = new Integer(1);
			Integer min = new Integer(1);
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
						itemHelper.itemSelected(_item);
					}
				});
				JButton add2Cart = new JButton("Add2Cart");
				add2Cart.addActionListener(new ActionListener() 
				{
					public void actionPerformed(ActionEvent e)
					{
						itemHelper.add2Cart(_item);
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
				
				quantity = new JLabel(Integer.toString(_item.getQuantity()));
				
				order.addActionListener(new ActionListener() 
				{		
					public void actionPerformed(ActionEvent e)
					{
						//JButton thisButton = (JButton)e.getSource();
						BuyerUIItem thisUIItem = (BuyerUIItem)order.getParent();
						int amountDesired = (int)spinner.getValue();
						if(_item.getQuantity() >= amountDesired && _item.inStock()) {
							itemHelper.orderItem(thisUIItem, _item, amountDesired);
							quantity.setText(String.valueOf(_item.getQuantity()));
							numModel.setValue(1);							
						} else if(_item.inStock()) {
							itemHelper.underStock(_item);
						} else {
							itemHelper.stockOut(_item);
						}
					}
				});
				
				this.add(new JLabel(item.getSellerID()));
				this.add(quantity);
				this.add(spinner);
				this.add(order);
			}
		}
	}
}