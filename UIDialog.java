import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;

public class UIDialog extends JDialog
{	
	public UIDialog (JPanel jp, boolean close)
	{
        JDialog uiDialog = new JDialog(this);
		uiDialog.setSize(new Dimension(500, 300));
        uiDialog.setModal(true);
		uiDialog.setLocationRelativeTo(App.Window);		
		if(close) {
			jp.add(new JButton("close") 
			{{ 
				addActionListener(new ActionListener() 
				{
					public void actionPerformed(ActionEvent e)
					{
						UIItemHelper.closeDialog(e);
					}
				});
			}});
		}
		uiDialog.add(jp);
		uiDialog.setVisible(true);
	}
}