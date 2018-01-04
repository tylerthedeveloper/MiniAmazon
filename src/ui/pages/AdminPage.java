package ui.pages;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import navigation.App;
import ui.renderers.UIDialog;
import ui.renderers.UIJPanel;

import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class AdminPage extends UIPage
{
    public AdminPage()
    {
		super();		
		pageSetup();
    }	
    
    public void pageSetup() 
    {
		//setting frame specifics
		jList = new JPanel();
		JButton productList = new JButton("View Products");
		productList.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
		  	{
			  	fillList(App.InvRepo.MarketItemList);		  	
			}
		});
		
		JButton searchUser = new JButton("View Users");	
		searchUser.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
		  	{
			  	fillList(App.UsrBase.UserList);		  	
			}
		});
		
		JButton searchTrans = new JButton("View Transactions");
		searchTrans.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
		  	{
			  	fillList(App.InvRepo.MarketTransactionList);		  	
			}
		});
		
		JButton reports = new JButton("View Reports");
		reports.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				generateReport();
			}
		});

		ImageIcon person = new ImageIcon("images/person.png");
        JLabel personIcon = new JLabel("profile", person, JLabel.CENTER);
        personIcon.addMouseListener(new MouseAdapter()   
        {   
			public void mouseClicked(MouseEvent e)  
		  	{
				viewProfile();
		  	}
		});
		
		this.add(productList);
		this.add(searchUser);
		this.add(searchTrans);
		this.add(reports);
		this.add(personIcon);
	}

	public void generateReport()
	{
		ArrayList<JComponent> arr = new ArrayList<JComponent>();
		arr.add(new JLabel("Number of transactions: "));
		arr.add(new JLabel(App.InvRepo.MarketTransactionList.size() + "."));
		arr.add(new JLabel("Number of items: "));
		arr.add(new JLabel(App.InvRepo.MarketItemList.size() + "."));
		arr.add(new JLabel("Number of users: "));
		arr.add(new JLabel(App.UsrBase.UserList.size() + "."));
		JDialog sOdog = new UIDialog(new UIJPanel(arr), true);
		
	}
}

