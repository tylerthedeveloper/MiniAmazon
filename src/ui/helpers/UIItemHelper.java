package ui.helpers;


import java.awt.*;


import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

import inventoryrepo.*;
import inventoryrepo.Item;
import ui.renderers.*;
import ui.views.*;
import ui.pages.*;
import navigation.*;
import userbase.*;
import navigation.*;

public class UIItemHelper
{
	
	public static void itemSelected(Item item) 
	{
		ArrayList<JComponent> arr = new ArrayList<JComponent>();
		arr.add(new UIItem(true));
		arr.add(new BuyerUIItem(item, true)); 
		JDialog jd = new UIDialog(new UIJPanel(arr), true);
	}
		
	public void add2Cart(Item item)
	{
		if (!((Buyer)App.User).ShoppingCart.contains(item)) {
			((Buyer)App.User).addToCart(item);
			BuyerPage.updateCart();
		}
	}

    public void deleteItem(Item item) {
		App.InvRepo.MarketItemList.remove(item);
		if(App.User instanceof Seller) {
			((Seller)App.User).deleteItem(item);
		}
    }

    public static void editItem(Item item) 
    {
		ArrayList<JComponent> arr = new ArrayList<JComponent>();
		arr.add(new UIItem(true));
		arr.add(new SellerUIItem(item,true));
		JDialog jd = new UIDialog(new UIJPanel(arr),true);     
    }
	
	
	public void orderItem(BuyerUIItem buitem, Item item, int amountToOrder)
	{
		App.InvRepo.processOrder(item, amountToOrder);
		((Buyer)App.User).ShoppingCart.updateTotal(item.getPrice(), amountToOrder);
//		System.out.print(((Buyer)App.User).ShoppingCart.cartTotal);
		if(!item.inStock()) buitem.order.setText("Out-of-stock");
	}
	
	
	public static void underStock(Item item)
	{
		ArrayList<JComponent> arr = new ArrayList<JComponent>();
		arr.add(new JLabel("Understock for item named:  "));
		arr.add(new JLabel(item.getName() + ". "));
		arr.add(new JLabel("We are sorry, but we do not have that many in stock"));
	    JDialog uSdog = new UIDialog(new UIJPanel(arr), true);
	}
	
	public static void stockOut(Item item)
	{
	    ArrayList<JComponent> arr = new ArrayList<JComponent>();
	    arr.add(new JLabel("Stockout for item named: "));
		arr.add(new JLabel(item.getName() + ". "));
		arr.add(new JLabel("we are sorry, but that item is out of stock. "));
		arr.add(new JLabel("We will notify you when it returns "));
	    JDialog sOdog = new UIDialog(new UIJPanel(arr), true);
	}	
	
	public static void itemNotFound() {
	    ArrayList<JComponent> arr = new ArrayList<JComponent>();
		arr.add(new JLabel("Sorry, but we could not find the item matching your input."));
		arr.add(new JLabel("Please try another search"));
	    JDialog sOdog = new UIDialog(new UIJPanel(arr), true);	
	}
}