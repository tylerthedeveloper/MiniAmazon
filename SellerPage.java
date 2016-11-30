import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.ImageIcon;

public class SellerPage extends UIPage
{	
    public SellerPage()
    {
		//super(new String[]{"View Products"});	
		super();
        jList = new JPanel();
        JButton productList = new JButton("View Products");
		productList.addActionListener(new ActionListener() 
		{		
			public void actionPerformed(ActionEvent e)
		  	{
				fillList(((Seller)App.User).seeMyInventory());		  	
			}
		});        
        //JButton searchProducts = new JButton("Search Products");
        JButton viewCategories = new JButton("View Categories");
		ImageIcon person = new ImageIcon("person.png");
        JLabel personIcon = new JLabel("profile", person, JLabel.CENTER);
        personIcon.addMouseListener(new MouseAdapter()   
        {   
			public void mouseClicked(MouseEvent e)  
		  	{
				viewProfile();
		  	}
		});
        UIItem itemSectionShort = new UIItem(false);
        this.add(productList);
        //this.add(searchProducts);
        this.add(viewCategories);
        this.add(personIcon);
        this.add(itemSectionShort);
    }
        
}
