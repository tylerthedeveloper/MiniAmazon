import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class UIItemHelper
{
	
	public static void itemSelected(Item item) 
	{
		ArrayList<JComponent> arr = new ArrayList<JComponent>() {{
			add(new UIItem(true));
			add(new BuyerUIItem(item, true)); 
		}};
		JDialog jd = new UIDialog(new UIJPanel(arr), true);
	}
		
	public static void add2Cart(Item item)
	{
		if(App.User instanceof Buyer) {
			((Buyer)App.User).addToCart(item);
			BuyerPage.updateCart();
		}
	}

    public static void deleteItem(Item item) {
	App.InvRepo.MarketItemList.remove(item);
    }

    public static void editItem(Item item) {
	ArrayList<JComponent> arr = new ArrayList<JComponent>() {{
		add(new UIItem(true));
		add(new UIItem(item,true));
		}};
		JDialog jd = new UIDialog(new UIJPanel(arr),true);     
    }
	
	
	public static void orderItem(UIItem uitem, Item item, int amountToOrder)
	{
		App.InvRepo.processOrder(item, amountToOrder);
		uitem.quantity.setText(String.valueOf(item.getQuantity()));
		uitem.numModel.setValue(0);
		if(!item.inStock()) uitem.order.setText("Out-of-stock");
	}
	
	
	public static void underStock(Item item)
	{
		final JDialog uSdog;
		ArrayList<JComponent> arr = new ArrayList<JComponent>() {{
			add(new JLabel("Understock for item named:  "));
			add(new JLabel(item.getName() + ". "));
			add(new JLabel("We are sorry, but we do not have that many in stock"));
	    }};
	    uSdog = new UIDialog(new UIJPanel(arr), true);
	}
	
	public static void closeDialog(ActionEvent e) {
		JButton thisButton = (JButton)e.getSource();
		UIJPanel thisPanel = (UIJPanel)thisButton.getParent();		
		((JDialog)thisPanel.getTopLevelAncestor()).dispose();
	}

	
	public static void stockOut(Item item)
	{
	    ArrayList<JComponent> arr = new ArrayList<JComponent>() {{
			add(new JLabel("Stockout for item named: "));
			add(new JLabel(item.getName() + ". "));
			add(new JLabel("we are sorry, but that item is out of stock. "));
			add(new JLabel("We will notify you when it returns "));
	    }};
	    JDialog sOdog = new UIDialog(new UIJPanel(arr), true);
	}	
	
	public static void itemNotFound() {
	    ArrayList<JComponent> arr = new ArrayList<JComponent>() {{
			add(new JLabel("Sorry, but we could not find the item matching your input."));
			add(new JLabel("Please try another search"));
	    }};
	    JDialog sOdog = new UIDialog(new UIJPanel(arr), true);	
	}
}