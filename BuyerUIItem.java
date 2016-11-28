import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class BuyerUIItem extends JPanel
{
	static SpinnerNumberModel numModel; 
	static JButton order;
	static JLabel quantity;

	public BuyerUIItem(Item item, boolean b)
	{
		super();
		if(item.getItemID() == null) 
		{
			//this.add(new JLabel("Test"));
			UIItemHelper.itemNotFound();
		}
		
		else {
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
						UIItemHelper.itemSelected(_item);
					}
				});
				JButton add2Cart = new JButton("Add2Cart");
				add2Cart.addActionListener(new ActionListener() 
				{
					public void actionPerformed(ActionEvent e)
					{
						UIItemHelper.add2Cart(_item);
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
						JButton thisButton = (JButton)e.getSource();
						BuyerUIItem thisUIItem = (BuyerUIItem)thisButton.getParent();
						int amountDesired = (int)spinner.getValue();
						if(_item.getQuantity() >= amountDesired && _item.inStock()) {
							UIItemHelper.orderItem(thisUIItem, _item, amountDesired);
						} else if(_item.inStock()) {
							UIItemHelper.underStock(_item);
						} else {
							UIItemHelper.stockOut(_item);
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
	}
}