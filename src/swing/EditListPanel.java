package swing;

import javax.swing.*;

import bank.Controller;
import interfaces.GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditListPanel extends JPanel {

	private Controller cont;
	private PlayerListPanel pLP;
	private GUI gui;

	public EditListPanel(Controller cont, PlayerListPanel pLP, GUI gui) {
		this.gui = gui;
		this.cont = cont;
		this.pLP = pLP;
		Dimension size = getPreferredSize();
		size.width = 320;
		setPreferredSize(size);

		setBorder(BorderFactory.createLineBorder(Color.BLACK));

		//CREATE
		JButton addPlayerButton = new JButton("Add");
		JButton defaultButton = new JButton("Default Players");
		JButton playGameButton = new JButton("PLAY");
		JTextField playerAddField = new JTextField();

		//LAYOUT
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();

		//PLACE

		gc.gridx = 0;
		gc.gridy = 1;
		gc.ipadx = 30;
		gc.weightx = 1;
		gc.weighty = 0.2;
		playerAddField.setText("Player Name");
		add(playerAddField);

		gc.ipadx = 10;
		gc.gridy = 2;
		add(addPlayerButton, gc);

		gc.gridy = 3;
		add(defaultButton, gc);

		gc.gridy = 4;
		add(playGameButton, gc);

		playGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cont.getNumberOfPlayers() >= 1) {
					gui.playersFrame.setVisible(false);
					gui.gameFrame.setVisible(true);
				}
			}
		});

		addPlayerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String playerNameToAdd = playerAddField.getText();
				if (cont.checkIfPlayerNameValid(playerNameToAdd) == null) {
					if (cont.getNumberOfPlayers() <= 7) {
						cont.addPlayerToGame(playerNameToAdd);
						pLP.model.addElement(playerNameToAdd);
					}
				}
			}
		});

		defaultButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (cont.checkIfPlayerNameValid("Tristan") == null) {
					if (cont.getNumberOfPlayers() <= 7) {
						cont.addPlayerToGame("Tristan");
						pLP.model.addElement("Tristan");
					}
				}
				if (cont.checkIfPlayerNameValid("Franky") == null) {
					if (cont.getNumberOfPlayers() <= 7) {
						cont.addPlayerToGame("Franky");
						pLP.model.addElement("Franky");
					}
				}
				if (cont.checkIfPlayerNameValid("Mum") == null) {
					if (cont.getNumberOfPlayers() <= 7) {
						cont.addPlayerToGame("Mum");
						pLP.model.addElement("Mum");
					}
				}
				if (cont.checkIfPlayerNameValid("Dad") == null) {
					if (cont.getNumberOfPlayers() <= 7) {
						cont.addPlayerToGame("Dad");
						pLP.model.addElement("Dad");
					}
				}
			}
		});
	}

}
