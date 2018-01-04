package navigation;

import javax.swing.*;

public class Window extends JFrame
{

	//class member instance variables
	public final int FRAME_WIDTH = 650;
	public final int FRAME_HEIGHT = 650;	
	
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