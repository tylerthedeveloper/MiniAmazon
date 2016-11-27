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
			add(new UIItem(item, true)); 
		}};
		JDialog jd = new UIDialog(new UIJPanel(arr));
	}
		
	public static void add2Cart(Item item)
	{
		if(App.User instanceof Buyer) {
			((Buyer)App.User).addToCart(item);
			BuyerPage.updateCart();
		}
	}
	
	
	public void orderItem(UIItem uitem, Item item, int amountToOrder)
	{
		App.InvRepo.processOrder(item, amountToOrder);
		uitem.quantity.setText(String.valueOf(item.getQuantity()));
		uitem.numModel.setValue(0);
		if(!item.inStock()) uitem.order.setText("Out-of-stock");
	}
	
	
	public static void underStock(Item item)
	{
		ArrayList<JComponent> arr = new ArrayList<JComponent>() {{
			add(new JLabel("Understock for item named:  "));
			add(new JLabel(item.getName() + ". "));
			add(new JLabel("We are sorry, but we do not have that many in stock"));
	    }};
	    JDialog uSdog = new UIDialog(new UIJPanel(arr));
	}

	
	public static void stockOut(Item item)
	{
	    ArrayList<JComponent> arr = new ArrayList<JComponent>() {{
			add(new JLabel("Stockout for item named: "));
			add(new JLabel(item.getName() + ". "));
			add(new JLabel("we are sorry, but that item is out of stock. "));
			add(new JLabel("We will notify you when it returns "));
	    }};
	    JDialog sOdog = new UIDialog(new UIJPanel(arr));
	}	
}