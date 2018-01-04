package ui.views;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import ui.renderers.UIDialog;
import userbase.User;

import java.util.ArrayList;

public class UIUser extends JPanel
{

	public UIUser()
	{
		super();		
		this.add(new JLabel("ID"));
		this.add(new JLabel("Name"));
		this.add(new JLabel("Email"));
		this.add(new JLabel("Role"));		
	}	

	public UIUser(User user)
	{
		super();
		final User _user = user;
		this.add(new JLabel(_user.getUserID()));
		this.add(new JLabel(_user.getName()));
		this.add(new JLabel(_user.getPass()));
		this.add(new JLabel(_user.getEmail()));
		this.add(new JLabel(_user.getRole().toString()));

		JButton editButton = new JButton("edit");
		editButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				editUserInfo(_user);
			}
		});

		this.add(editButton);
		

	}

	public void editUserInfo(User user)
	{
		final User _user = user;
		JPanel editPan = new JPanel();
		final JTextField name = new JTextField(_user.getName());
		final JTextField pass = new JTextField(_user.getPass());
		final JTextField email = new JTextField(_user.getEmail());
		JButton save = new JButton("Save");
		save.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				_user.editInfo(name.getText(), pass.getText(), email.getText());
				addUser(_user);
				removeUser();
			}
		});
		editPan.add(new JLabel("Name:"));
		editPan.add(name);
		editPan.add(new JLabel("Password:"));
		editPan.add(pass);
		editPan.add(new JLabel("Email"));
		editPan.add(email);
		editPan.add(save);
		JDialog jdLog = new UIDialog(editPan, true);

	}

	public void addUser(User user)
	{
		Container parent = getParent();
		parent.add(new UIUser(user));
		parent.validate();
		parent.revalidate();
		parent.repaint();
	}

	public void removeUser()
	{
		Container parent = getParent();
		parent.remove(this);
		parent.validate();
		parent.revalidate();
		parent.repaint();
	}
}