package swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.*;

import bank.Controller;
import interfaces.GUI;

public class GameFrame extends JFrame {

	private Controller cont;
	private GUI gui;

	public PlayerTablePanel playerTablePanel;
	private EditTablePanel editTablePanel;

	public GameFrame(String title, Controller cont, GUI gui) {
		super(title);
		this.cont = cont;
		this.gui = gui;

		//set layout manager
		setLayout(new BorderLayout());

		//create components
		playerTablePanel = new PlayerTablePanel(cont);
		editTablePanel = new EditTablePanel(cont, playerTablePanel);

		Container c = getContentPane();

		c.add(playerTablePanel, BorderLayout.WEST);
		c.add(editTablePanel, BorderLayout.EAST);
		
		addComponentListener(new ComponentAdapter() {
			public void componentHidden(ComponentEvent e) 
			{
				/* code run when component hidden*/
			}
			public void componentShown(ComponentEvent e) {
				playerTablePanel.updateTable();
				editTablePanel.updateComboBox();
			}
		});
	}


}
