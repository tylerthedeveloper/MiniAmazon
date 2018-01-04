package navigation;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;

import inventoryrepo.Item;
import ui.pages.AdminPage;
import ui.pages.BuyerPage;
import ui.pages.SellerPage;
import userbase.Admin;
import userbase.Buyer;
import userbase.Seller;
import userbase.User;
import userbase.UserBaseClass;
import ui.pages.UIPage;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;

public class StartupHelper extends JDialog //implements IStartupHelper
{

	public Boolean valid = false;
	//constructor
	public StartupHelper() {}

	public JDialog Initial()
	{
        JDialog dialog = new JDialog(this);
        dialog.setTitle("Hello and Welcome");
        JPanel pan = new JPanel();
        JLabel question = new JLabel("Would you like to Login or Register");
		JButton login = new JButton("Login");
		JButton register = new JButton("Register");
		pan.add(question);
		pan.add(login);
		pan.add(register);
        dialog.setSize(new Dimension(400, 100));
        dialog.setModal(true);
        login.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
		  	{
		  		dispose();
		  		loginButtonClicked();
		  	}
		});

		register.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
		  	{
		  		dispose();
			  	registerButtonClicked();
		  	}
		});

		dialog.add(pan);
		dialog.setLocationRelativeTo(this);

		return dialog;
	}

	public void loginButtonClicked()
	{

		while (!valid) {

		    final JDialog loginDialog = new JDialog(this);
	        loginDialog.setTitle("Login");
	        JPanel logPan = new JPanel();
			JLabel labName = new JLabel("name");
			JLabel labPass = new JLabel("password");
			final JTextField name = new JTextField("UserName");
			final JTextField password = new JTextField("Password");
			logPan.add(labName);
			logPan.add(name);
			logPan.add(labPass);
			logPan.add(password);
			JButton loginButton = new JButton("Login");
			loginButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
			  	{
					String nameEntered = name.getText();
					String passEntered = password.getText();
					for (int i = 0; i < UserBaseClass.UserList.size(); i++)
					{
						User current = UserBaseClass.UserList.get(i);
						if (nameEntered.equals(current.getName()))
						{
							//System.out.println("Name matched");
							//System.out.println(User.hashPass(passEntered));
							if (passEntered.equals(current.getPass()))
							{
								//System.out.println(User.hashPass(passEntered));
								//System.out.println("Password Matched");
								//System.out.println(current.getUserID());
								if (current.getRole() == User.Role.Seller)
								{
									for (int j = 0; j < App.InvRepo.MarketItemList.size(); j++)
									{
										Item item = App.InvRepo.MarketItemList.get(j);
										if (item.getSellerID() == current.getUserID())
										{
											((userbase.Seller)App.User).addItem(item);
										}
									}
									dispose();
									App.User = current;
									//App.Window.add(getUserPage(role));
									App.Window.add(new SellerPage());
									App.Window.setVisible(true);
									valid = true;
								}
								else if (current.getRole() == User.Role.Buyer)
								{
									dispose();
									App.User = current;
									//App.Window.add(getUserPage(role));
									App.Window.add(new BuyerPage());
									App.Window.setVisible(true);
									valid = true;
								}
								else if (current.getRole() == User.Role.Admin)
								{
									dispose();
									App.User = current;
									//App.Window.add(getUserPage(role));
									App.Window.add(new AdminPage());
									App.Window.setVisible(true);
									valid = true;
								}
							}
							else
							{
								loginDialog.add(new JLabel("Could not match"));
							}
						}
			  		//dispose();
			  		//System.out.print(App.User);
			  		//App.Window.add(new BuyerPage());
					//App.Window.setVisible(true);
					}
			  	}
			});

			logPan.add(loginButton);
	        loginDialog.setSize(new Dimension(500, 300));
	        loginDialog.setLocationRelativeTo(this);
	        loginDialog.setModal(true);
	        loginDialog.add(logPan);
			loginDialog.setVisible(true);
		}

		//loginDialog.dispose();
	}

	public void registerButtonClicked()
	{
	    JDialog loginDialog = new JDialog(this);
        loginDialog.setTitle("Register");
        JPanel logPan = new JPanel();
		final JTextField name = new JTextField("name");
		final JTextField password = new JTextField("password");
		final JTextField email = new JTextField("email");
		final ButtonGroup roleGroup = new ButtonGroup();
		final JRadioButton buyerButton = new JRadioButton("Buyer");
		buyerButton.setSelected(true);
		final JRadioButton sellerButton = new JRadioButton("Seller");
		final JRadioButton adminButton = new JRadioButton("Admin");
	    //buyerButton.setMnemonic(KeyEvent.VK_D);
    	roleGroup.add(buyerButton);
    	roleGroup.add(sellerButton);
    	roleGroup.add(adminButton);
		final JTextField role = new JTextField("role");
		JButton register = new JButton("Register");
		register.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
		  	{
		  		dispose();
		  		User.Role role;

		  		if(buyerButton.isSelected()) {
			  		role = User.Role.Buyer;
			  	}

			  	else if(sellerButton.isSelected()) {
			  		role = User.Role.Seller;
			  	}

		  		else {
			  		role = User.Role.Admin;
			  	}

		  		App.User = UserBaseClass.register(name.getText(), password.getText(),
								  					email.getText(), role);
				App.Window.add(getUserPage(role));
		  	}
		});

		logPan.add(name);
		logPan.add(password);
		logPan.add(email);
		logPan.add(role);
		logPan.add(register);
		logPan.add(buyerButton);
    	logPan.add(sellerButton);
    	logPan.add(adminButton);
        loginDialog.setSize(new Dimension(500, 300));
        loginDialog.setLocationRelativeTo(this);
        loginDialog.setModal(true);
        loginDialog.add(logPan);
		loginDialog.setVisible(true);
	}

	public UIPage getUserPage(User.Role role)
	{
		App.Window.setVisible(true);

		if(role == User.Role.Buyer) {
			return new BuyerPage();
		}

		else if(role == User.Role.Seller) {
			return new SellerPage();
		}

		else {
			return new AdminPage();
		}
	}
	
	
	public static void loadItems()
	{
		try
		{
			Scanner scan = new Scanner(new File("files/items.csv"));

			while (scan.hasNextLine())
			{
				String line = scan.nextLine();
				ArrayList<String> row = new ArrayList<String>();
				String[] items = line.split(",");
				for (String col : items) {
					if (col != "") {
						row.add(col);
					}
				}

				Item.Category category;
				String cat = row.get(2);
				if (cat == "Electronics") {
					category = Item.Category.Electronics;
				} else if (cat == "Software") {
					category = Item.Category.Software;
				} else {
					category = Item.Category.Books;
				}

				Boolean b;
				if (row.get(6) == "TRUE") {
					b = true;
				} else {
					b = false;
				}

				Item item =
					new Item(row.get(0),row.get(1),category,row.get(3),
					Integer.parseInt(row.get(4)),Integer.parseInt(row.get(5)),
					b,row.get(7));

				App.InvRepo.MarketItemList.add(item);
				//System.out.println(App.InvRepo.MarketItemList.size());

			}
			
			scan.close();
		}

		catch (FileNotFoundException exc)
		{
			exc.printStackTrace();
		}
	}

	public static void loadUsers()
	{
		try
		{
			Scanner scan = new Scanner(new File("files/users.csv"));
			while (scan.hasNextLine())
			{
				String line = scan.nextLine();
				ArrayList<String> row = new ArrayList<String>();
				String[] items = line.split(",");
				for (String col : items) {
					if (col != "") {
						row.add(col);
					}
				}

				User.Role role;

				if (row.get(4).equals("Buyer")) {
					//System.out.println("Found a Buyer");
					role = User.Role.Buyer;
					UserBaseClass.addUser(new Buyer(row.get(1),row.get(2),row.get(3),role));
					//System.out.println(App.UsrBase.UserList.size());
				}
				else if (row.get(4).equals("Seller")) {
					role = User.Role.Seller;
					UserBaseClass.addUser(new Seller(row.get(1),row.get(2),row.get(3),role));
					//System.out.println(App.UsrBase.UserList.size());
				}
				else if (row.get(4).equals("Admin")) {
					role = User.Role.Admin;
					UserBaseClass.addUser(new Admin(row.get(1),row.get(2),row.get(3),role));
					//System.out.println(App.UsrBase.UserList.size());
				}
				
			
			}
			
			scan.close();
		}

		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
