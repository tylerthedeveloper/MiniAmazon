package ui.views;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import inventoryrepo.*;

public class UITransaction extends JPanel
{	
	public UITransaction(Transaction _trans)
	{
		super();
		this.add(new JLabel(_trans.getTransactionID()));
		this.add(new JLabel(_trans.getName()));
		this.add(new JLabel(_trans.getItemID()));
		this.add(new JLabel(_trans.getCategory().toString()));
		this.add(new JLabel(String.valueOf(_trans.getPrice())));			
		this.add(new JLabel(String.valueOf(_trans.getOnSale())));
		this.add(new JLabel(_trans.getDescription()));
		this.add(new JLabel(_trans.getSellerID()));
		this.add(new JLabel(String.valueOf(_trans.getQuantity())));			
	}
	
}