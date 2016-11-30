import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

abstract class UIPage extends JPanel //implements CustomActionListener
{
	JPanel jList;	
	
	public UIPage() {}
	
	public UIPage(String[] buttons) 
	{
		//System.out.print(s);
		ActionListener aListener  = new CustomActionListener();
		for(String text : buttons)
		{
			JButton jb = new JButton(text);
			jb.addActionListener(aListener);
			this.add(jb);		
		}
	}
	
	public void viewProfile()
	{
		JPanel jdPan = new JPanel(true);
	    JLabel userID = new JLabel("UserID");
	    JLabel name = new JLabel("Name");
	    JLabel email = new JLabel("Email");
	    JLabel role = new JLabel("Role");
	    jdPan.add(userID);
	    jdPan.add(name);
	    jdPan.add(email);	    
	    jdPan.add(role);
	    jdPan.add(App.User.showProfile());
	    JDialog jd = new JDialog();
	    jd.setSize(new Dimension(500, 300));
        jd.setModal(true);
	    jd.add(jdPan);
		jd.setLocationRelativeTo(this);
		jd.setVisible(true);
	}
	
	public void fillList(ArrayList<?> list) 
	{
		JPanel tempJP = new JPanel();
    	for(Object item : list) {
    		if((Item)item instanceof Item) {
	    		Item _item = (Item)item;
			
			if (App.User.getRole() == User.Role.Buyer) {
			    tempJP.add(new BuyerUIItem(_item, false));
			}
			else {
			    tempJP.add(new SellerUIItem(_item,false));
				}
	        }
        }
        
		this.remove(jList);
	    jList = tempJP;
        this.add(tempJP);
        App.Window.revalidate();
        App.Window.repaint();
    }    
}

