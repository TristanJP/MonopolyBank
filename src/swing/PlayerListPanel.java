package swing;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import bank.Controller;

public class PlayerListPanel extends JPanel{
	private Controller cont;
	public DefaultListModel model;
	
	
	public PlayerListPanel(Controller cont) {
		this.cont = cont;
		Dimension size = getPreferredSize();
		size.width = 320;
		setPreferredSize(size);
		
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		//CREATE
		
		model = new DefaultListModel();
		JList playerList = new JList(model);
		
		JButton removePlayerButton = new JButton("Remove");
		
		//LAYOUT 
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		
		//PLACE
		
		gc.gridx = 0;
		gc.gridy = 0;
		gc.weightx = 1;
		gc.weighty = 0.8;
		//gc.fill = GridBagConstraints.BOTH;
		
		add(playerList, gc);
		
		gc.gridx = 0;
		gc.gridy = 1;
		gc.weighty = 0.2;
		//gc.fill = GridBagConstraints.HORIZONTAL;
		
		add(removePlayerButton, gc);
		
		removePlayerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selected = (String) playerList.getSelectedValue();
				int index = playerList.getSelectedIndex();
				cont.removePlayerFromGame(index);
				model.removeElement(selected);
			}
		});
		
		
		
		
		
		
	}

}
