package swing;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import bank.Controller;
import interfaces.GUI;

public class PlayersFrame extends JFrame {
	
	private PlayerListPanel playerListPanel;
	private EditListPanel editListPanel;
	private Controller cont;
	private GUI gui;

	public PlayersFrame(String title, Controller cont, GUI gui) {
		super(title);
		this.cont = cont;
		this.gui = gui;
		
		//set layout manager
		setLayout(new BorderLayout());
		
		//create components
		playerListPanel = new PlayerListPanel(cont);
		editListPanel = new EditListPanel(cont, playerListPanel, gui);
		
		//JButton defaultPlayersButton = new JButton("Default");
		
		//Add components to content pane
		Container c = getContentPane();
		
		c.add(playerListPanel, BorderLayout.WEST);
		c.add(editListPanel, BorderLayout.EAST);
		
		
	}
}
