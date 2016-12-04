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
	    JLabel userID = new JLabel(App.User.getUserID());
	    JLabel name = new JLabel(App.User.getName());
	    JLabel email = new JLabel(App.User.getEmail());
	    JLabel role = new JLabel(App.User.getRole().toString());
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
<<<<<<< HEAD
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
=======
		if(list.size() > 0 ) {		
			JPanel tempJP = new JPanel();
			for(Object obj : list) {
			
				if(obj instanceof Item) {
					Item _item = (Item)obj;
			
					if (App.User.getRole() == User.Role.Buyer) {
						tempJP.add(new BuyerUIItem(_item, false));
					}
			
					else {
						tempJP.add(new SellerUIItem(_item,false));
					}
				}
			
				else if(obj instanceof Transaction) {
					Transaction _transaction = (Transaction)obj;
					tempJP.add(new UITransaction(_transaction));
				}
				
				/*
				else if(obj instanceof User) {
					User _user = (User)obj;
					tempJP.add(new UIUser(_user));
				}
				*/
			}
		
			
			this.remove(jList);
			jList = tempJP;
			this.add(tempJP);
			App.Window.revalidate();
			App.Window.repaint();
		}    
>>>>>>> ddc41dff360c6d04b35de952f6190f3e79be54b7
    }
}
