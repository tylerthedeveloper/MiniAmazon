import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Window extends JFrame
{

	//class member instance variables
	public final int FRAME_WIDTH = 800;
	public final int FRAME_HEIGHT = 800;	
	
	//constructor
	public Window() 
	{
		//call to super to initialize the JFrame
	    super();
	        
	    //setting frame specifics
	    this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		this.setTitle("Marketplace");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(this);
	}
}



/*
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
        dialog.setLocationRelativeTo(this);
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
		  		//this.dispose();
			  	registerButtonClicked();
		  	}
		});
		
		//register
		dialog.add(pan);        
		//dialog.setVisible(true);
		
		
		
		
		
		
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
			  	add(new UserPage());
			  	setVisible(true);
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
        loginDialog.setTitle("Logiaan");
        JPanel logPan = new JPanel();
		JTextField name = new JTextField("name");
		JTextField password = new JTextField("password");
		JButton login = new JButton("Login");
		logPan.add(name);
		logPan.add(password);
		logPan.add(login);
        loginDialog.setSize(new Dimension(400, 100));
        loginDialog.setLocationRelativeTo(this);
        loginDialog.setModal(true);
        loginDialog.add(logPan);
		loginDialog.setVisible(true);
	}		
	
	*/
	