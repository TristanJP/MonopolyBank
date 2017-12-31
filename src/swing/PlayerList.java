package swing;

import java.awt.Dimension;

import javax.swing.*;

public class PlayerList extends JList {

	public PlayerList(DefaultListModel model) {
		super(model);
		Dimension size = getPreferredSize();
		size.width = 320;
		setPreferredSize(size);
		
		
		
	}

}
