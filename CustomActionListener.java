import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class CustomActionListener implements ActionListener, MouseListener
{
	
	public void	actionPerformed(ActionEvent e)
	{
		String button = ((JButton)e.getSource()).getText();
		if(button.equals("View Products"))
		{
			if(App.User.getRole() == User.Role.Seller)
			{
((UIPage)((JButton)e.getSource()).getParent()).fillList(((Seller)App.User).seeMyInventory(	));	
			}

			else 
			{
((UIPage)((JButton)e.getSource()).getParent()).fillList(App.InvRepo.MarketItemList);
			}
			

		}
	}
	
	public void	mouseClicked(MouseEvent e) {
		//UIPage.viewProfile();
	}

	public void	mouseEntered(MouseEvent e) {}

	public void	mouseExited(MouseEvent e) {}

	public void	mousePressed(MouseEvent e) {}

	public void	mouseReleased(MouseEvent e) {}

}

