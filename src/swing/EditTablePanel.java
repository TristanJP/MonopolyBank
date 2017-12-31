package swing;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import bank.Controller;
import bank.Player;

public class EditTablePanel extends JPanel{

	private Controller cont;
	private PlayerTablePanel pTP;
	private JComboBox transferToPlayerBox ;
	private String[] comboStrings = {
			"Default",
			" ",
			" ",
			" ",
			" ",
			" ",
			" ",
			" "
	};

	public EditTablePanel(Controller cont, PlayerTablePanel pTP) {
		this.cont = cont;
		this.pTP = pTP;

		Dimension size = getPreferredSize();
		size.width = 320;
		setPreferredSize(size);

		//LAYOUT
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		JTextField amountOfMoneyField = new JTextField("100");
		JButton addMoneyButton = new JButton("Add");
		JButton removeMoneyButton = new JButton("Remove");
		JButton transferButton = new JButton("Transfer");
		
		transferToPlayerBox = new JComboBox(comboStrings);
		
		gc.gridx = 0;
		gc.gridy = 0;
		gc.gridwidth = 3;
		gc.weighty = 0.25;
		
		add(amountOfMoneyField, gc);
		
		gc.gridwidth = 1;
		gc.gridy = 1;
		
		add(addMoneyButton, gc);
		
		gc.gridx = 3;
		add(removeMoneyButton, gc);
		
		gc.gridx = 2;
		gc.gridy = 2;
		add(transferToPlayerBox,gc);
		
		gc.gridy = 3;
		add(transferButton, gc);
		
		addMoneyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int amount = Integer.parseInt(amountOfMoneyField.getText());
				cont.addMoneyToAccount(pTP.playerTable.getSelectedRow(),amount);
				pTP.updateTable();
			}
		});
		
		removeMoneyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int amount = Integer.parseInt(amountOfMoneyField.getText());
				cont.removeMoneyFromAccount(pTP.playerTable.getSelectedRow(),amount);
				pTP.updateTable();
			}
		});
		
		transferButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int amount = Integer.parseInt(amountOfMoneyField.getText());
				cont.transferMoney(transferToPlayerBox.getSelectedIndex(), pTP.playerTable.getSelectedRow(), amount);
				pTP.updateTable();
			}
		});
	}
	
	public void updateComboBox() {
		int count = 0;
		for (Player player : cont.getPlayers()) {
			comboStrings[count] = player.getName();
			count++;
		}
		DefaultComboBoxModel model = new DefaultComboBoxModel(comboStrings);
		transferToPlayerBox.setModel( model );
	}

}