import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Window extends JFrame
{

	//class member instance variables
	public final int FRAME_WIDTH = 600;
	public final int FRAME_HEIGHT = 600;	

	//constructor
	public Window() 
	{
		//call to super to initialize the JFrame
	    super();
	    //setting frame specifics
	    this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		this.setTitle("Marketplace");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(new UserPage());
        
        JDialog dialog = new JDialog(this);
        dialog.setTitle("Hello and Welcome");
        JPanel pan=new JPanel();
		JButton login = new JButton("Login");
		JButton register = new JButton("Register");
		login.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
		  	{
			  	//Window.setVisible(true);
				//System.out.println("som");
				
		  	}
		});
		
		//register
		
		pan.add(login);
		pan.add(register);
		
        dialog.setSize(new Dimension(400, 100));
        dialog.setLocationRelativeTo(this);
        dialog.setModal(true);
		dialog.add(pan);        
		dialog.setVisible(true);
	}


	//		//this.setVisible(true);

}