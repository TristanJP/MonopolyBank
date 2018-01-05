package swing;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Insets;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;

import bank.Controller;
import interfaces.GUI;

public class MenuFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private Controller cont;
	public DefaultListModel model;

	/**
	 * Create the frame.
	 */
	public MenuFrame(Controller cont, GUI gui) {
		this.cont = cont;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setResizable(false);
		ImageIcon img = new ImageIcon("C:\\Users\\trisp\\tp\\Programming\\workspace\\MonopolyBank\\resources\\MonopolyLogo.png");
		setIconImage(img.getImage());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{212, 212, 0, 0};
		gbl_contentPane.rowHeights = new int[]{251, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);

		JPanel panelPlayerList = new JPanel();
		GridBagConstraints gbc_panelPlayerList = new GridBagConstraints();
		gbc_panelPlayerList.fill = GridBagConstraints.BOTH;
		gbc_panelPlayerList.insets = new Insets(0, 5, 0, 5);
		gbc_panelPlayerList.gridx = 0;
		gbc_panelPlayerList.gridy = 0;
		contentPane.add(panelPlayerList, gbc_panelPlayerList);
		GridBagLayout gbl_panelPlayerList = new GridBagLayout();
		gbl_panelPlayerList.columnWidths = new int[]{87, 1, 0};
		gbl_panelPlayerList.rowHeights = new int[]{1, 0, 0, 0, 0, 0, 0};
		gbl_panelPlayerList.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_panelPlayerList.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelPlayerList.setLayout(gbl_panelPlayerList);

		model = new DefaultListModel();
		JList list = new JList(model);
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.gridwidth = 2;
		gbc_list.gridheight = 4;
		gbc_list.insets = new Insets(0, 0, 5, 0);
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 0;
		gbc_list.gridy = 1;
		panelPlayerList.add(list, gbc_list);

		JButton btnRemovePlayer = new JButton("Remove");
		GridBagConstraints gbc_btnRemovePlayer = new GridBagConstraints();
		gbc_btnRemovePlayer.insets = new Insets(0, 0, 0, 5);
		gbc_btnRemovePlayer.gridx = 0;
		gbc_btnRemovePlayer.gridy = 5;
		panelPlayerList.add(btnRemovePlayer, gbc_btnRemovePlayer);

		JLabel lblPlayerList = new JLabel("Player List:");
		GridBagConstraints gbc_lblPlayerList = new GridBagConstraints();
		gbc_lblPlayerList.anchor = GridBagConstraints.WEST;
		gbc_lblPlayerList.gridx = 0;
		gbc_lblPlayerList.gridy = 0;
		panelPlayerList.add(lblPlayerList, gbc_lblPlayerList);
		btnRemovePlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});

		JPanel panelAddPlayer = new JPanel();
		GridBagConstraints gbc_panelAddPlayer = new GridBagConstraints();
		gbc_panelAddPlayer.insets = new Insets(0, 5, 0, 0);
		gbc_panelAddPlayer.fill = GridBagConstraints.BOTH;
		gbc_panelAddPlayer.gridx = 1;
		gbc_panelAddPlayer.gridy = 0;
		contentPane.add(panelAddPlayer, gbc_panelAddPlayer);
		GridBagLayout gbl_panelAddPlayer = new GridBagLayout();
		gbl_panelAddPlayer.columnWidths = new int[]{0, 0, 0};
		gbl_panelAddPlayer.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelAddPlayer.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_panelAddPlayer.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		panelAddPlayer.setLayout(gbl_panelAddPlayer);

		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 1;
		panelAddPlayer.add(textField, gbc_textField);
		textField.setColumns(2);

		JLabel lblAddPlayer = new JLabel("Add Player:");
		GridBagConstraints gbc_lblAddPlayer = new GridBagConstraints();
		gbc_lblAddPlayer.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblAddPlayer.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddPlayer.gridx = 0;
		gbc_lblAddPlayer.gridy = 0;
		panelAddPlayer.add(lblAddPlayer, gbc_lblAddPlayer);

		JButton btnAddPlayer = new JButton("Add");
		GridBagConstraints gbc_btnAddPlayer = new GridBagConstraints();
		gbc_btnAddPlayer.insets = new Insets(0, 0, 5, 5);
		gbc_btnAddPlayer.gridx = 0;
		gbc_btnAddPlayer.gridy = 2;
		panelAddPlayer.add(btnAddPlayer, gbc_btnAddPlayer);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 4;
		panelAddPlayer.add(panel, gbc_panel);

		JButton btnAddDefault = new JButton("Add Default");
		GridBagConstraints gbc_btnAddDefault = new GridBagConstraints();
		gbc_btnAddDefault.insets = new Insets(0, 0, 5, 5);
		gbc_btnAddDefault.gridx = 0;
		gbc_btnAddDefault.gridy = 5;
		panelAddPlayer.add(btnAddDefault, gbc_btnAddDefault);

		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 6;
		panelAddPlayer.add(panel_1, gbc_panel_1);

		JButton btnPlay = new JButton("PLAY");
		GridBagConstraints gbc_btnPlay = new GridBagConstraints();
		gbc_btnPlay.gridheight = 2;
		gbc_btnPlay.fill = GridBagConstraints.BOTH;
		gbc_btnPlay.insets = new Insets(0, 0, 0, 5);
		gbc_btnPlay.gridx = 0;
		gbc_btnPlay.gridy = 7;
		panelAddPlayer.add(btnPlay, gbc_btnPlay);

		btnRemovePlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selected = (String) list.getSelectedValue();
				int index = list.getSelectedIndex();
				cont.removePlayerFromGame(index);
				model.removeElement(selected);
			}
		});

		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cont.getNumberOfPlayers() >= 1) {
					gui.menuFrame.setVisible(false);
					gui.playFrame.setVisible(true);
				}
			}
		});

		btnAddPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String playerNameToAdd = textField.getText();
				if (cont.checkIfPlayerNameValid(playerNameToAdd) == null) {
					if (checkTextField()) {
						if (cont.getNumberOfPlayers() <= 7) {
							cont.addPlayerToGame(playerNameToAdd);
							model.addElement(playerNameToAdd);
						}
					}
				}
			}
		});

		btnAddDefault.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (cont.checkIfPlayerNameValid("Tristan") == null) {
					if (cont.getNumberOfPlayers() <= 7) {
						cont.addPlayerToGame("Tristan");
						model.addElement("Tristan");
					}
				}
				if (cont.checkIfPlayerNameValid("Franky") == null) {
					if (cont.getNumberOfPlayers() <= 7) {
						cont.addPlayerToGame("Franky");
						model.addElement("Franky");
					}
				}
				if (cont.checkIfPlayerNameValid("Mum") == null) {
					if (cont.getNumberOfPlayers() <= 7) {
						cont.addPlayerToGame("Mum");
						model.addElement("Mum");
					}
				}
				if (cont.checkIfPlayerNameValid("Dad") == null) {
					if (cont.getNumberOfPlayers() <= 7) {
						cont.addPlayerToGame("Dad");
						model.addElement("Dad");
					}
				}
			}
		});
	}

	private boolean checkTextField() {
		if (textField.getText().isEmpty()) {
			return false;
		}
		else {
			return true;
		}
	}

}
