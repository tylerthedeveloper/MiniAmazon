import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class UserPage extends JPanel
{
	public UserPage()
	{
		super();
		
		// display/center the jdialog when the button is pressed
        //JDialog d = new JDialog(this, "Hello", true);
        //d.setLocationRelativeTo(this);

	    //setting frame specifics
	    JButton login = new JButton("Login");
	    this.add(login);
		//this.add(new JButton("Login"))
		/*
		login.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
			// display/center the jdialog when the button is pressed
			JDialog d = new JDialog(frame, "Hello", true);
			d.setLocationRelativeTo(frame);
			d.setVisible(true);
		  }
		});
		*/
		
		
		this.add(new JButton("Register"));
	}	
}