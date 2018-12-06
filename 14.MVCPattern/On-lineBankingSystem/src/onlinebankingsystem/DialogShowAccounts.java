package onlinebankingsystem;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class DialogShowAccounts extends JDialog
{

	private final JPanel contentPanel = new JPanel();
	private JTable tableAccounts;
	private AccountDatabase accountDB;
	private DefaultTableModel model;
	private JTextField txtID;

	/**
	 * Launch the application.
	 */

	/*
	 * depreciated public static void main(String[] args) { try {
	 * DialogShowAccounts dialog = new DialogShowAccounts();
	 * dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	 * dialog.setVisible(true); } catch (Exception e) { e.printStackTrace(); } }
	 */

	/**
	 * Create the dialog.
	 */
	public DialogShowAccounts(AccountDatabase accountDB)
	{
		setTitle("ShowAccount");
		init();

		this.accountDB = accountDB;

		showAccounts();
	}

	public void init()
	{
		setBounds(100, 100, 700, 500);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		tableAccounts = new JTable();
		tableAccounts.setBounds(12, 40, 660, 411);
		contentPanel.add(tableAccounts);

		txtID = new JTextField();
		txtID.setBounds(452, 9, 116, 21);
		contentPanel.add(txtID);
		txtID.setColumns(10);

		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				String strID = txtID.getText();
				ArrayList<Account> accountList;

				if (strID.equals(""))
				{
					accountList = accountDB.getAccountList();
				} else
				{
					int id = Integer.parseInt(strID);
					accountList = accountDB.getAccountListByClientID(id);
				}

				updateAccounts(accountList);
			}
		});
		btnSearch.setBounds(575, 8, 97, 23);
		contentPanel.add(btnSearch);

		JLabel lblClientId = new JLabel("Client ID:");
		lblClientId.setBounds(387, 12, 57, 15);
		contentPanel.add(lblClientId);
	}

	private void showAccounts()
	{
		model = new DefaultTableModel(0, 0);

		ArrayList<Account> accountList = accountDB.getAccountList();

		String columnNames[] =
		{ "°í°´ID", "°èÁÂ¹øÈ£", "°èÁÂÁ¾·ù", "±Ý¾×" };

		model.setColumnIdentifiers(columnNames);
		tableAccounts.setModel(model);

		model.addRow(new Object[]
		{ "°í°´ID", "°èÁÂ¹øÈ£", "°èÁÂÁ¾·ù", "±Ý¾×" });

		int size = accountList.size();
		for (int i = 0; i < size; ++i)
		{
			Account acc = accountList.get(i);
			model.addRow(new Object[]
			{ acc.getClientId(), acc.getAccountNumber(), acc.toString(), acc.getBalance() });
		}
	}

	private void updateAccounts(ArrayList<Account> accountList)
	{
		model = new DefaultTableModel(0, 0);

		String columnNames[] =
		{ "°í°´ID", "°èÁÂ¹øÈ£", "°èÁÂÁ¾·ù", "±Ý¾×" };

		model.setColumnIdentifiers(columnNames);
		tableAccounts.setModel(model);

		model.addRow(new Object[]
		{ "°í°´ID", "°èÁÂ¹øÈ£", "°èÁÂÁ¾·ù", "±Ý¾×" });

		int size = accountList.size();
		for (int i = 0; i < size; ++i)
		{
			Account acc = accountList.get(i);
			model.addRow(new Object[]
			{ acc.getClientId(), acc.getAccountNumber(), acc.toString(), acc.getBalance() });
		}
	}
}
