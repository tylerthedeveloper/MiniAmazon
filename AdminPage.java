import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class AdminPage extends UIPage
{
  public AdminPage()
  {
  //super(new String[]{"View Products"});
      super();
      jList = new JPanel();
      JButton productList = new JButton("View Products");
      productList.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          fillList(App.InvRepo.MarketItemList);
        }
    });

      JButton users = new JButton("View Users");
      users.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          final JDialog userDialog = new JDialog();
          
        }
      });


      UIItem itemSectionShort = new UIItem(false);
      this.add(productList);
      this.add(users);
      //this.add(viewCategories);
      this.add(personIcon);
      this.add(itemSectionShort);



  }

}
