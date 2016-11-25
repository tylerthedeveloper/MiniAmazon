import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

abstract class UIPage extends JPanel 
{

	public UIPage() {}
	
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
}
