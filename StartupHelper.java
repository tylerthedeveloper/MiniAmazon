import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;

public class StartupHelper extends JDialog implements IStartupHelper
{
	//constructor
	public StartupHelper() {}
	
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
        loginDialog.setSize(new Dimension(500, 300));
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
		final ButtonGroup roleGroup = new ButtonGroup();
		final JRadioButton buyerButton = new JRadioButton("Buyer");
		buyerButton.setSelected(true);
		final JRadioButton sellerButton = new JRadioButton("Seller");
		final JRadioButton adminButton = new JRadioButton("Admin");
	    //buyerButton.setMnemonic(KeyEvent.VK_D);
    	roleGroup.add(buyerButton);
    	roleGroup.add(sellerButton);
    	roleGroup.add(adminButton);
		final JTextField role = new JTextField("role");
		JButton register = new JButton("Register");
		register.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
		  	{
		  		dispose();
		  		User.Role role;

		  		if(buyerButton.isSelected()) {
			  		role = User.Role.Buyer;
			  	}
			  		
			  	else if(sellerButton.isSelected()) {
			  		role = User.Role.Seller;
			  	}
			  		
		  		else {
			  		role = User.Role.Admin;		  		
			  	}
		  		
		  		App.User = UserBaseClass.register(name.getText(), password.getText(), 
								  					email.getText(), role);
				App.Window.add(getUserPage(role));
		  	}
		});
		
		logPan.add(name);
		logPan.add(password);
		logPan.add(email);
		logPan.add(role);
		logPan.add(register);
		logPan.add(buyerButton);
    	logPan.add(sellerButton);
    	logPan.add(adminButton);
    	
        loginDialog.setSize(new Dimension(500, 300));
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