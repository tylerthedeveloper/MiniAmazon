package ui.views;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;


public class UIItem extends JPanel
{
	
	//item section headers
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
}