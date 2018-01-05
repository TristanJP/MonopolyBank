package interfaces;

import javax.swing.*;

import bank.Controller;
import swing.MenuFrame;
import swing.PlayFrame;
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
	public MenuFrame menuFrame;
	public PlayFrame playFrame;

	//CHANGE BACK TO PRIVATE AFTER TESTING
	public GUI() {

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
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					g.menuFrame = new MenuFrame(cont, getGUI());
					g.menuFrame.setTitle("Monopoly Bank");
					g.menuFrame.setVisible(true);
					g.playFrame = new PlayFrame(cont, getGUI());
					g.playFrame.setTitle("Monopoly Bank");
					g.playFrame.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
