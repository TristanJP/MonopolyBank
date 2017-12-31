package interfaces;

import javax.swing.*;

import bank.Controller;
import swing.GameFrame;
import swing.PlayersFrame;

import java.awt.*;
import java.awt.event.*;

/**
 * GUI interface for the Monopoly Bank
 * @author trisp
 * @version 1.0
 * 
 * Changelog:
 * 1.0 - Create first iteration of GUI with adding and removing players
 *
 */

public class GUI {

	//FIELDS
	private static GUI g = null;
	public JFrame playersFrame, gameFrame;

	private GUI() {

	}

	public static GUI getGUI() {
		if (g == null) {
			g = new GUI();
		}
		return g;
	}

	public static void main(String[] args) {

		getGUI();
		
		Controller cont = new Controller();

		g.playersFrame = new PlayersFrame("Monopoly Bank", cont, getGUI());
		g.playersFrame.setSize(640, 420);
		g.playersFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		g.playersFrame.setResizable(false);
		g.playersFrame.setVisible(true);
		
		g.gameFrame = new GameFrame("Monopoly Bank", cont, getGUI());
		g.gameFrame.setSize(640, 420);
		g.gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		g.gameFrame.setResizable(false);
		g.gameFrame.setVisible(false);

	}


	static class Action implements ActionListener{
		public void actionPerformed (ActionEvent e) {

		}
	}

}
