//package src.Userbase;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

abstract class User
{
	String _userID;
	String _name;
	String _pass;
	String _email;
	Role _role;
	
	public static enum Role 
	{
		Buyer,
		Seller,
		Admin
	};
	
	
	public User () {}
	
	public User (String name, String pass, String email, Role role) 
	{
		this.setUserID(createNewUserGUID());
		this.setName(name);
		this.setPass(pass);
		this.setEmail(email);
		this.setRole(role);
	}
	
	public String createNewUserGUID() {
		return "new GUID";
	}
	
	public void setUserID(String userID){
		_userID = userID;
	}
	
	public String getUserID(){
		return _userID;
	}
	
	public void setName(String name) {
		_name = name;
	}
	
	public String getName() {
		return _name;
	}

	public void setPass(String pass){
		_pass = pass;
	}
	
	public void setEmail(String email){
		_email = email;
	}

	public String getEmail() {
		return _email;
	}
	
	public void setRole(Role role) {
		_role = role;
	}
	
	public Role getRole() {
		return _role;
	}
	
	public void hashPass(){}
	
	public JPanel showProfile()
	{
		JPanel jdPan = new JPanel(true);
	    JLabel userID = new JLabel(this.getUserID());
	    JLabel name = new JLabel(this.getName());
	    JLabel email = new JLabel(this.getEmail());
	    JLabel role = new JLabel(this.getRole().toString());
	    JButton edit = new JButton("Edit");
	    edit.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
		  	{
				System.out.println("edit profile");	
		  	}
		});
	    jdPan.add(userID);
	    jdPan.add(name);
	    jdPan.add(email);	    
	    jdPan.add(role);
	    jdPan.add(edit);
	 	/*
	 	JDialog jd = new JDialog();
	    jd.setSize(new Dimension(500, 300));
        jd.setModal(true);
	    jd.add(jdPan);
	    */
		return jdPan;
	}
	
	public String toString() {
		return "UserID: " + getUserID() + "\n" +
				"Name: " + getName() + "\n" +
				"Email: " + getEmail() + "\n" +
				"Role: " + getRole() + "\n";
	}

}