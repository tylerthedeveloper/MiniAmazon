import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.ImageIcon;
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class SellerPage extends UIPage
{
    public SellerPage()
    {
		//super(new String[]{"View Products"});
		super();
		pageSetup();
	}
	
	public void pageSetup() 
	{
        jList = new JPanel();
        JButton productList = new JButton("View Products");
		productList.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
		  	{
				fillList(((Seller)App.User).seeMyInventory());
			}
		});
        //JButton searchProducts = new JButton("Search Products");
    JButton addItem = new JButton("Add item");
		addItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
		  	{

				//addItem();
				final JDialog addDialog = new JDialog();
				final JPanel itemInfo = enterItemInfo();
				JButton close = new JButton("Close");
				close.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
				  	{
				  		addDialog.dispose();
				  	}
				});
				itemInfo.add(close);
				addDialog.add(itemInfo);
				addDialog.setLocationRelativeTo(((JButton)e.getSource()).getParent());
				addDialog.setSize(new Dimension(500, 300));
				addDialog.setModal(true);
				addDialog.setVisible(true);
			}
		});

		JButton upload = new JButton("Upload Items");
		upload.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					final JDialog uploadDialog = new JDialog();
					final JPanel fileInfo = uploadFile();
					JButton close = new JButton("Close");
					close.addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent e)
						{
							uploadDialog.dispose();
						}
					});
					fileInfo.add(close);
					uploadDialog.add(fileInfo);
					uploadDialog.setLocationRelativeTo(((JButton)e.getSource()).getParent());
					uploadDialog.setSize(new Dimension(300, 300));
					uploadDialog.setVisible(true);
				}
			});

		ImageIcon person = new ImageIcon("person.png");
        JLabel personIcon = new JLabel("profile", person, JLabel.CENTER);
        personIcon.addMouseListener(new MouseAdapter()
        {
			public void mouseClicked(MouseEvent e)
		  	{
				viewProfile();
		  	}
		});
        UIItem itemSectionShort = new UIItem(false);
        this.add(productList);
        this.add(addItem);
        this.add(upload);
        //this.add(viewCategories);
        this.add(personIcon);
        this.add(itemSectionShort);
    }


	public JPanel uploadFile()
	{
		JPanel addPan = new JPanel();
		final JTextField file = new JTextField("filename");
		final JButton upload = new JButton("Upload");
		upload.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String filename = file.getText();
				try
				{
					Scanner scan = new Scanner(new File(System.getProperty("user.dir")+"/"+filename));

					while (scan.hasNextLine())
					{
						String line = scan.nextLine();
						ArrayList<String> row = new ArrayList<String>();
						String[] items = line.split(",");
						for (String col : items) {
							if (col != "") {
								row.add(col);
							}
						}

						Item.Category category;
						String cat = row.get(2);
						if (cat == "Electronics") {
							category = Item.Category.Electronics;
						} else if (cat == "Software") {
							category = Item.Category.Software;
						} else {
							category = Item.Category.Books;
						}

						Boolean b;
						if (row.get(6) == "TRUE") {
							b = true;
						} else {
							b = false;
						}

						Item item =
							new Item(row.get(0),row.get(1),category,row.get(3),
							Integer.parseInt(row.get(4)),Integer.parseInt(row.get(5)),
							b,App.User.getUserID());

						Seller s = (Seller)App.User;

						if (!s.exists(item)) {

							App.InvRepo.MarketItemList.add(item);
							((Seller)App.User).addItem(item);

							add(new SellerUIItem(item, false));
							App.Window.validate();
							App.Window.revalidate();
							App.Window.repaint();
						}
					}
				}

				catch (FileNotFoundException exc)
				{
					exc.printStackTrace();
				}
			}
		});
		addPan.add(file);
		addPan.add(upload);
		return addPan;
	}

	public JPanel enterItemInfo()
	{

    JPanel addPan = new JPanel();
		final JTextField itemID = new JTextField("ItemID");
		final JTextField name = new JTextField("Name");
		final JLabel category = new JLabel("Category");
		final JLabel priceLab = new JLabel("Price");
		Integer value = new Integer(1);
		Integer min = new Integer(1);
		Integer max = new Integer(1000);
		Integer step = new Integer(10);
		SpinnerNumberModel numModel = new SpinnerNumberModel(value, min, max, step);
		final JSpinner price = new JSpinner(numModel);
		final JTextField description = new JTextField("Description");
		//final JTextField sellerID = new JTextField("SellerID");
		final JLabel quantity = new JLabel("Quantity");
		SpinnerNumberModel numModel2 = new SpinnerNumberModel(value, min, max, step);
		final JSpinner quantSpin = new JSpinner(numModel2);
		final ButtonGroup catGroup = new ButtonGroup();
		final JRadioButton elecButton = new JRadioButton("Electronics");
		elecButton.setSelected(true);
		final JRadioButton softButton = new JRadioButton("Software");
		final JRadioButton bookButton = new JRadioButton("Books");
    catGroup.add(elecButton);
    catGroup.add(softButton);
    catGroup.add(bookButton);
    final JLabel sale = new JLabel("Sale?");
    final ButtonGroup saleGroup = new ButtonGroup();
		final JRadioButton yes = new JRadioButton("Yes");
		yes.setSelected(true);
		final JRadioButton no = new JRadioButton("No");
    saleGroup.add(yes);
    saleGroup.add(no);
		JButton save = new JButton("Save");
		save.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
		  	{
		  		Item.Category cat;

				if(elecButton.isSelected()) {
			  		cat = Item.Category.Electronics;
			  	}

			  	else if(softButton.isSelected()) {
			  		cat = Item.Category.Software;
			  	}

		  		else {
			  		cat = Item.Category.Books;
			  	}


				boolean onSale;

				if(yes.isSelected()) {
			  		onSale = true;
			  	}

			  	else {
			  		onSale = false;
			  	}

		  		Item item = new Item(itemID.getText(), name.getText(),
								  	cat, description.getText(),
								  	(Integer)price.getValue(),
								  	(Integer)quantSpin.getValue(), onSale,
								  	App.User.getUserID());

				if(App.User.getRole() == User.Role.Seller)
				{
					((Seller)App.User).addItem(item);
				}

				App.InvRepo.MarketItemList.add(item);
				add(new SellerUIItem(item, false));
				App.Window.validate();
				App.Window.revalidate();
				App.Window.repaint();
			}
		});
		addPan.add(itemID);
		addPan.add(name);
		addPan.add(category);
		addPan.add(elecButton);
		addPan.add(softButton);
		addPan.add(bookButton);
		addPan.add(price);
		addPan.add(sale);
		addPan.add(yes);
		addPan.add(no);
		addPan.add(description);
		//addPan.add(sellerID);
		addPan.add(quantity);
		addPan.add(save);
    	return addPan;
	}
}
