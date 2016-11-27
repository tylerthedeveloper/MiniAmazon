import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;

public class UIDialog extends JDialog
{
	
	public UIDialog (JPanel jp)
	{
        JDialog uiDialog = new JDialog(this);
		uiDialog.setSize(new Dimension(500, 300));
        uiDialog.setModal(true);
		uiDialog.setLocationRelativeTo(App.Window);		
		uiDialog.add(jp);
		uiDialog.setVisible(true);
	}
}