import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class UIUser extends JPanel
{

	public UIUser(User user)
	{
		super();
	  final User _user = user;
		this.add(new JLabel(_user.getUserID()));
		this.add(new JLabel(_user.getName()));
		this.add(new JLabel(_user.getPass()));
		this.add(new JLabel(_user.getEmail()));
		this.add(new JLabel(_user.getRole().toString()));

		JButton edit = new JButton("edit");
		edit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				editUserInfo(_user);
				App.Window.validate();
				App.Window.revalidate();
				App.Window.repaint();
			}
		});

	}

	public JPanel editUserInfo(User user)
	{
		final User _user = user;
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
}
