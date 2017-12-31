package swing;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;

import javax.swing.*;

import bank.Controller;
import bank.Player;

public class PlayerTablePanel extends JPanel{

	private Controller cont;
	public JTable playerTable;
	String[][] data = {
			{" ", " "},
			{" ", " "},
			{" ", " "},
			{" ", " "},
			{" ", " "},
			{" ", " "},
			{" ", " "},
			{" ", " "}
	};


	public PlayerTablePanel(Controller cont) {
		this.cont = cont;


		Dimension size = getPreferredSize();
		size.width = 320;
		setPreferredSize(size);

		//LAYOUT
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();

		String[] columnNames = {"Player Name", "Money"};
		
		playerTable = new JTable(data, columnNames);
		JButton goButton = new JButton("GO!");


		gc.weighty = 0.8;
		gc.gridy = 0;

		add(playerTable, gc);

		gc.weighty = 0.2;
		gc.gridy = 1;

		add(goButton, gc);

		goButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = playerTable.getSelectedRow();
				cont.getPlayers().get(index).addMoneyToAccount(200);
				updateTable();
			}
		});

		
	}
	
	public void updateTable() {
		int count = 0;
		for (Player player : cont.getPlayers()) {
			data[count][0] = player.getName();
			String money = Integer.toString(player.getMoneyInAccount());
			data[count][1] = money;
			count++;
		}
		playerTable.repaint();
	}

}
