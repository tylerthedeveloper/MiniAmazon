import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UIElementHelper extends JDialog
{

	//constructor
	public UIElementHelper() {}
	
	public JDialog Initial()
	{
        JDialog dialog = new JDialog(this);
        dialog.setTitle("Hello and Welcome");
        JPanel pan = new JPanel();
        JLabel question = new JLabel("Would you like to Login or Register");
		JButton login = new JButton("Login");
		JButton register = new JButton("Register");
		pan.add(question);
		pan.add(login);
		pan.add(register);
        dialog.setSize(new Dimension(400, 100));
        dialog.setModal(true);
        login.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
		  	{
		  		dispose();
		  		loginButtonClicked();
		  	}
		});
		
		register.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
		  	{
		  		dispose();
			  	registerButtonClicked();
		  	}
		});

		dialog.add(pan);        
		dialog.setLocationRelativeTo(this);
		
		return dialog;
	}
	
	public void loginButtonClicked()
	{		
	    JDialog loginDialog = new JDialog(this);
        loginDialog.setTitle("Login");
        JPanel logPan = new JPanel();
		JLabel labName = new JLabel("name");
		JLabel labPass = new JLabel("password");
		JTextField name = new JTextField("");
		JTextField password = new JTextField("");
		logPan.add(labName);
		logPan.add(name);
		logPan.add(labPass);
		logPan.add(password);
		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
		  	{
		  		dispose();
		  		//System.out.print(App.User);
		  		App.Window.add(new BuyerPage());
				App.Window.setVisible(true);
		  	}
		});
		logPan.add(loginButton);
        loginDialog.setSize(new Dimension(400, 100));
        loginDialog.setLocationRelativeTo(this);
        loginDialog.setModal(true);
        loginDialog.add(logPan);
		loginDialog.setVisible(true);
	}
	
	public void registerButtonClicked()
	{		
	    JDialog loginDialog = new JDialog(this);
        loginDialog.setTitle("Register");
        JPanel logPan = new JPanel();
		final JTextField name = new JTextField("name");
		final JTextField password = new JTextField("password");
		final JTextField email = new JTextField("email");
		final JTextField role = new JTextField("role");
		JButton register = new JButton("Register");
		register.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
		  	{
		  		dispose();
		  		App.User = UserBaseClass.register(name.getText(), password.getText(), 
								  		email.getText(), User.Role.Buyer);
				//System.out.print(App.User.getRole());
				App.Window.add(getUserPage(User.Role.Seller));
				//App.Window.setVisible(true);
		  	}
		});
		logPan.add(name);
		logPan.add(password);
		logPan.add(email);
		logPan.add(role);
		logPan.add(register);
        loginDialog.setSize(new Dimension(400, 100));
        loginDialog.setLocationRelativeTo(this);
        loginDialog.setModal(true);
        loginDialog.add(logPan);
		loginDialog.setVisible(true);
	}
	
	public UIPage getUserPage(User.Role role) 
	{
		App.Window.setVisible(true);
		
		if(role == User.Role.Buyer) {
			return new BuyerPage();
		}	
		
		else if(role == User.Role.Seller) {
			return new SellerPage();
		}	

		else { 
			return new AdminPage();
		}

		
	}
}