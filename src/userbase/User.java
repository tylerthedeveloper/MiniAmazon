package userbase;

import java.awt.*;
import java.awt.event.*;
import java.io.UnsupportedEncodingException;

import javax.swing.*;
import javax.xml.bind.DatatypeConverter;

import java.util.ArrayList;

import ui.renderers.*;
import navigation.*;

public abstract class User
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
	this.setUserID(createNewUserGUID(name, email, role.toString()));
	this.setName(name);
	this.setPass(pass);
	this.setEmail(email);
	this.setRole(role);
	}

	public String createNewUserGUID(String name, String email, String role) {
	return role.substring(0,2)+name.substring(0,3)+email.substring(0,3);
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

	public static String hashPass(String pass) {
		//return Base64.getEncoder().encodeToString(pass.getBytes());
		//byte[] message = "hello world".getBytes(StandardCharsets.UTF_8);
		//String encoded = Base64.getEncoder().encodeToString(pass);
		//byte[] decoded = Base64.getDecoder().decode(pass);
	//return Base64.encodeBase64(pass.getBytes());
		byte[] prepass = null;
		try {
			prepass = "hello world".getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return DatatypeConverter.printBase64Binary(prepass);
		//byte[] decoded = DatatypeConverter.parseBase64Binary(encoded);
	}

    public static String decodePass(String hash) {
            String str = new String(hash);
            return str;
	}

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
				ArrayList<JComponent> arr = new ArrayList<JComponent>();
				arr.add(editUserInfo());
				JDialog sOdog = new UIDialog(new UIJPanel(arr), true);
			}
		});

		jdPan.add(edit);
		return jdPan;
	}

	public void editInfo(String name, String pass, String email)
	{
		this.setName(name);
		this.setPass(pass);
		this.setEmail(email);
	}

	public JPanel editUserInfo()
	{
			final JPanel editPan = new JPanel();
			final JTextField name = new JTextField(App.User.getName());
			final JTextField pass = new JTextField(App.User.getPass());
			final JTextField email = new JTextField(App.User.getEmail());

			final JButton save = new JButton("Save");
			save.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					JPanel thisPanel = (JPanel)save.getParent();
					((JDialog)thisPanel.getTopLevelAncestor()).dispose();
					App.User.setName(name.getText());
					App.User.setPass(pass.getText());
					App.User.setEmail(email.getText());
					editPan.validate();
					editPan.revalidate();
					editPan.repaint();
					Container parent = editPan.getParent();
					parent.validate();
					parent.revalidate();
					parent.repaint();
				}
			});

			editPan.add(new JLabel("Name:" ));
			editPan.add(name);
			editPan.add(new JLabel("Password: "));
			editPan.add(pass);
			editPan.add(new JLabel("Email: "));
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
