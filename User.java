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

        public String getPass() {
	        return _pass;
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
	  JLabel name = new JLabel(App.User.getName());
	  JLabel email = new JLabel(App.User.getEmail());
	  JLabel role = new JLabel(App.User.getRole().toString());
	  JButton edit = new JButton("Edit");
		edit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
		  	{

				//addItem();
				final JDialog editDialog = new JDialog();
				final JPanel userInfo = editUserInfo();
				JButton close = new JButton("Close");
				close.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent ev)
				  	{
				  		editDialog.dispose();
				  	}
				});
				userInfo.add(close);
				editDialog.add(userInfo);
				editDialog.setLocationRelativeTo(((JButton)e.getSource()).getParent());
				editDialog.setSize(new Dimension(500, 300));
				editDialog.setModal(true);
				editDialog.setVisible(true);
			}
		});
		jdPan.add(edit);
		return jdPan;
	}

		public JPanel editUserInfo()
		{
			JPanel editPan = new JPanel();
			final JTextField name = new JTextField(App.User.getName());
			final JTextField pass = new JTextField(App.User.getPass());
			final JTextField email = new JTextField(App.User.getEmail());
			final JLabel nameLabel = new JLabel("Name:");
			final JLabel passLabel = new JLabel("Password:");
			final JLabel emailLabel = new JLabel("Email");

			JButton save = new JButton("Save");
			save.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					App.User.setName(name.getText());
					App.User.setPass(pass.getText());
					App.User.setEmail(email.getText());

					App.Window.validate();
					App.Window.revalidate();
					App.Window.repaint();
				}
			});

			editPan.add(nameLabel);
			editPan.add(name);
			editPan.add(passLabel);
			editPan.add(pass);
			editPan.add(emailLabel);
			editPan.add(email);
			editPan.add(save);
			return editPan;
		}



	public String toString() {
		return "UserID: " + getUserID() + "\n" +
				"Name: " + getName() + "\n" +
				"Email: " + getEmail() + "\n" +
				"Role: " + getRole() + "\n";
	}

}
