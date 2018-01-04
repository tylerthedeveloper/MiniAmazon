package ui.renderers;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.util.ArrayList;

public class UIJPanel extends JPanel
{	
	public UIJPanel (ArrayList<JComponent> elements)
	{
		this.add(elements.get(0));
		for(JComponent jcomp : elements) {
			this.add(jcomp);
		}
	}
}