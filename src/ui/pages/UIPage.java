package ui.pages;

import java.awt.event.*;
import javax.swing.*;

import inventoryrepo.Item;
import inventoryrepo.Transaction;
import navigation.App;
import ui.renderers.UIDialog;
import ui.renderers.UIJPanel;
import ui.views.BuyerUIItem;
import ui.views.SellerUIItem;
import ui.views.UIItem;
import ui.views.UITransaction;
import ui.views.UIUser;
import userbase.User;
import userbase.UserBaseClass;

import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public abstract class UIPage extends JPanel //implements CustomActionListener
{
	public JPanel jList;
	
	public UIPage() {
		
	}

	public void viewProfile()
	{
	    JPanel jdPan = new JPanel(true);
	    jdPan.add(new JLabel(App.User.getUserID()));
	    jdPan.add(new JLabel(App.User.getName()));
	    jdPan.add(new JLabel(App.User.getEmail()));
	    jdPan.add(new JLabel(App.User.getRole().toString()));
	    jdPan.add(App.User.showProfile());
	    JButton logout = new JButton("logout");
		logout.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				logout(e);
			}
		});
		jdPan.add(logout);
	    JDialog jd = new UIDialog(jdPan, true);
	}

	public void fillList(ArrayList<?> list)
	{
		if(list.size() > 0 )
		{			
			jList.removeAll();
			
			jList.setLayout(new BoxLayout(jList, BoxLayout.Y_AXIS));
			
			for(Object obj : list) {

				if(obj instanceof Item) {
					Item _item = (Item)obj;

					if (App.User.getRole() == User.Role.Buyer) {
						jList.add(new BuyerUIItem(_item, false));
					}

					else {
						jList.add(new SellerUIItem(_item,false));
					}
				}

				else if(obj instanceof Transaction) {
					Transaction _transaction = (Transaction)obj;
					jList.add(new UITransaction(_transaction));
				}


				else if(obj instanceof User) {
					User _user = (User)obj;
					jList.add(new UIUser(_user));
				}
			}
			
			this.add(jList);
			App.Window.revalidate();
			App.Window.repaint();
		}
	}
	
	public void logout(ActionEvent e)
    {
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

		try
		{
			PrintWriter users = new PrintWriter("files/users.csv");
			for (int i = 0; i < UserBaseClass.UserList.size(); i++)
			{
				User usr = UserBaseClass.UserList.get(i);
				users.println(usr.getUserID() + "," + usr.getName() + "," + usr.getPass() + "," + usr.getEmail() + "," + usr.getRole().toString());
			}
			
			//users.println(App.User.getUserID() + "," + App.User.getName() + "," + App.User.getPass() + "," + App.User.getEmail() + "," + App.User.getRole().toString());
		
			users.close();
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
