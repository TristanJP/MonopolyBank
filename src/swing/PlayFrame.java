package swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bank.Controller;
import bank.Player;
import interfaces.GUI;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;

public class PlayFrame extends JFrame {

	private Controller cont;
	private GUI gui;
	private JPanel contentPane;
	private DefaultTableModel model;
	private JPanel panel;
	private JLabel lblPlayerTable;
	private JTable table;
	private JButton btnGo;
	private JLabel lblEditTable;
	private JTextField textField;
	private JButton btnAddMoney;
	private JButton btnRemoveMoney;
	private JPanel panel_2;
	private JComboBox<Object> comboBox;
	private JButton btnTransferMoney;
	private JPanel panel_3;
	private String[][] data = {
			{" ", " "},
			{" ", " "},
			{" ", " "},
			{" ", " "},
			{" ", " "},
			{" ", " "},
			{" ", " "},
			{" ", " "}
	};
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
	private JScrollPane scrollPane;
	private JLabel lblTransferMoney;


	/**
	 * Create the frame.
	 */
	public PlayFrame(Controller cont, GUI gui) {
		this.cont = cont;
		this.gui = gui;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setResizable(false);
		ImageIcon img = new ImageIcon("C:\\Users\\trisp\\tp\\Programming\\workspace\\MonopolyBank\\resources\\MonopolyLogo.png");
		setIconImage(img.getImage());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, -171, 0};
		gbl_contentPane.rowHeights = new int[]{248, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);

		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 5, 0, 0);
		gbc_panel_1.weighty = 1.0;
		gbc_panel_1.weightx = 0.1;
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 0;
		contentPane.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);

		lblEditTable = new JLabel("Add/Remove Money:");
		GridBagConstraints gbc_lblEditTable = new GridBagConstraints();
		gbc_lblEditTable.anchor = GridBagConstraints.WEST;
		gbc_lblEditTable.insets = new Insets(0, 0, 5, 5);
		gbc_lblEditTable.gridx = 0;
		gbc_lblEditTable.gridy = 0;
		panel_1.add(lblEditTable, gbc_lblEditTable);
		
		lblTransferMoney = new JLabel("Transfer Money To:");
		GridBagConstraints gbc_lblTransferMoney = new GridBagConstraints();
		gbc_lblTransferMoney.anchor = GridBagConstraints.WEST;
		gbc_lblTransferMoney.insets = new Insets(0, 0, 5, 0);
		gbc_lblTransferMoney.gridx = 0;
		gbc_lblTransferMoney.gridy = 5;
		panel_1.add(lblTransferMoney, gbc_lblTransferMoney);

		panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 5, 0);
		gbc_panel_3.gridwidth = 2;
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 1;
		panel_1.add(panel_3, gbc_panel_3);

		btnTransferMoney = new JButton("Transfer");
		GridBagConstraints gbc_btnTransferMoney = new GridBagConstraints();
		gbc_btnTransferMoney.anchor = GridBagConstraints.NORTH;
		gbc_btnTransferMoney.gridwidth = 2;
		gbc_btnTransferMoney.gridx = 0;
		gbc_btnTransferMoney.gridy = 7;
		panel_1.add(btnTransferMoney, gbc_btnTransferMoney);

		comboBox = new JComboBox<Object>(comboStrings);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.gridwidth = 2;
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 0;
		gbc_comboBox.gridy = 6;
		panel_1.add(comboBox, gbc_comboBox);

		panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(20, 0, 5, 0);
		gbc_panel_2.gridwidth = 2;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 4;
		panel_1.add(panel_2, gbc_panel_2);

		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 2;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 2;
		panel_1.add(textField, gbc_textField);
		textField.setColumns(10);

		btnAddMoney = new JButton("Add");
		GridBagConstraints gbc_btnAddMoney = new GridBagConstraints();
		gbc_btnAddMoney.insets = new Insets(0, 0, 5, 10);
		gbc_btnAddMoney.weightx = 1.0;
		gbc_btnAddMoney.gridx = 0;
		gbc_btnAddMoney.gridy = 3;
		panel_1.add(btnAddMoney, gbc_btnAddMoney);

		btnRemoveMoney = new JButton("Remove");
		GridBagConstraints gbc_btnRemoveMoney = new GridBagConstraints();
		gbc_btnRemoveMoney.anchor = GridBagConstraints.WEST;
		gbc_btnRemoveMoney.insets = new Insets(0, 0, 5, 15);
		gbc_btnRemoveMoney.weightx = 1.0;
		gbc_btnRemoveMoney.gridx = 1;
		gbc_btnRemoveMoney.gridy = 3;
		panel_1.add(btnRemoveMoney, gbc_btnRemoveMoney);

		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.weightx = 1.0;
		gbc_panel.weighty = 1.0;
		gbc_panel.insets = new Insets(0, 5, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);

		lblPlayerTable = new JLabel("Player Table:");
		GridBagConstraints gbc_lblPlayerTable = new GridBagConstraints();
		gbc_lblPlayerTable.anchor = GridBagConstraints.WEST;
		gbc_lblPlayerTable.insets = new Insets(0, 0, 5, 0);
		gbc_lblPlayerTable.gridx = 0;
		gbc_lblPlayerTable.gridy = 0;
		panel.add(lblPlayerTable, gbc_lblPlayerTable);

		String[] columnNames = {"Player Name", "Money"};

		btnGo = new JButton("GO!");
		GridBagConstraints gbc_btnGo = new GridBagConstraints();
		gbc_btnGo.insets = new Insets(0, 0, 5, 0);
		gbc_btnGo.gridx = 0;
		gbc_btnGo.gridy = 2;
		panel.add(btnGo, gbc_btnGo);

		scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(null);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 3, 0);
		gbc_scrollPane.weighty = 1.0;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		panel.add(scrollPane, gbc_scrollPane);
		table = new JTable(data, columnNames);
		table.setRowHeight(22);
		scrollPane.setViewportView(table);


		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = table.getSelectedRow();
				if (index < cont.getNumberOfPlayers()) {
					cont.addMoneyToAccount(table.getSelectedRow(),200);
					updateTable();
				}
			}
		});

		btnAddMoney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkTextField()) {
					if (textTextFieldValue()) {
						int amount = Integer.parseInt(textField.getText());
						cont.addMoneyToAccount(table.getSelectedRow(),amount);
						updateTable();
					}
				}
			}
		});

		btnRemoveMoney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkTextField()) {
					if (textTextFieldValue()) {
						int amount = Integer.parseInt(textField.getText());
						cont.removeMoneyFromAccount(table.getSelectedRow(),amount);
						updateTable();
					}
				}
			}
		});

		btnTransferMoney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkTextField()) {
					if (textTextFieldValue()) {
						int amount = Integer.parseInt(textField.getText());
						cont.transferMoney(comboBox.getSelectedIndex(), table.getSelectedRow(), amount);
						updateTable();
					}
				}
			}
		});


		addComponentListener(new ComponentAdapter() {
			public void componentHidden(ComponentEvent e) 
			{
				/* code run when component hidden*/
			}
			public void componentShown(ComponentEvent e) {
				updateTable();
				updateComboBox();
			}
		});

	}

	private void updateComboBox() {
		int count = 0;
		for (Player player : cont.getPlayers()) {
			comboStrings[count] = player.getName();
			count++;
		}
		DefaultComboBoxModel model = (DefaultComboBoxModel) comboBox.getModel();
		model.removeAllElements();
		for (Player player : cont.getPlayers()) {
            model.addElement(player.getName());
        }
		comboBox.setModel(model);
	}

	private void updateTable() {
		int count = 0;
		for (Player player : cont.getPlayers()) {
			data[count][0] = player.getName();
			String money = Integer.toString(player.getMoneyInAccount());
			data[count][1] = money;
			count++;
		}
		table.repaint();
	}

	private boolean checkTextField() {
		if (textField.getText().isEmpty()) {
			return false;
		}
		else {
			return true;
		}
	}

	private boolean textTextFieldValue() {
		try
		{
			int i = Integer.parseInt(textField.getText().trim());

			return true;
		}
		catch (NumberFormatException nfe)
		{
			return false;
		}
	}

}
