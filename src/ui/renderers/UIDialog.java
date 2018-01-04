package ui.renderers;



import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import inventoryrepo.Item;
import navigation.App;
import ui.views.UIItem;
import userbase.User;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;



public class UIDialog extends JDialog
{	
	public UIDialog (JPanel jp, boolean close)
	{
	    JDialog uiDialog = new JDialog(this);
		uiDialog.setSize(new Dimension(700, 300));
		uiDialog.setModal(true);
		uiDialog.setLocationRelativeTo(App.Window);
		JButton closer = new JButton("close");
		if(close) {				
			closer.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e)
				{
					closeDialog(e);
				}
			});
			jp.add(closer);
		}
		uiDialog.add(jp);
		uiDialog.setVisible(true);
	}
	
	public void closeDialog(ActionEvent e) 
	{
		JButton thisButton = (JButton)e.getSource();
		JComponent thisPanel;
		
		if(thisButton.getParent() instanceof UIJPanel) {
			thisPanel = (UIJPanel)thisButton.getParent();		
		}
		
		else if (thisButton.getParent() instanceof UIItem) { 
			thisPanel = (UIItem)thisButton.getParent();		
		}			
		
		else { 
			thisPanel = (JPanel)thisButton.getParent();		
		}
		
		((JDialog)thisPanel.getTopLevelAncestor()).dispose();
	}

    public void logout(ActionEvent e)
    {
	
	try
	{
	    PrintWriter users = new PrintWriter("files/users.csv");
	    for (int i = 0; i < App.UsrBase.UserList.size(); i++)
	    {
	    	User usr = App.UsrBase.UserList.get(i);
	    	users.println(usr.getUserID() + "," + usr.getName() + "," + usr.getPass() + "," + usr.getEmail() + "," + usr.getRole().toString());
	    }
		users.println(App.User.getUserID() + "," + App.User.getName() + "," + App.User.getPass() + "," + App.User.getEmail() + "," + App.User.getRole().toString());
	    
	    users.close();
	}

	catch (FileNotFoundException f)
	{
	    f.printStackTrace();
	}
	
	try 
	{
	    PrintWriter items = new PrintWriter("files/items.csv");
	    for (int i = 0; i < App.InvRepo.MarketItemList.size(); i++)
	    {
		Item currentItem = App.InvRepo.MarketItemList.get(i);
		items.println(currentItem.getItemID() + "," + currentItem.getName() + "," + currentItem.getCategory().toString() + "," + 
			    currentItem.getDescription() + "," + Integer.toString(currentItem.getPrice()) + "," + 
			    Integer.toString(currentItem.getQuantity()) + "," + String.valueOf(currentItem.getOnSale()) + "," + currentItem.getSellerID());
	    }
	    items.close();
	}

	catch (FileNotFoundException f)
	{
	    f.printStackTrace();
	}
	
	JButton thisButton = (JButton)e.getSource();
	JComponent thisPanel;

	if(thisButton.getParent() instanceof UIJPanel) {
	    thisPanel = (UIJPanel)thisButton.getParent();
	}

	else if (thisButton.getParent() instanceof UIItem) {
	    thisPanel = (UIItem)thisButton.getParent();
	}

	else {
	    thisPanel = (JPanel)thisButton.getParent();
	}

	((JDialog)thisPanel.getTopLevelAncestor()).dispose();
	App.Window.dispose();
	System.exit(0);

    }
}