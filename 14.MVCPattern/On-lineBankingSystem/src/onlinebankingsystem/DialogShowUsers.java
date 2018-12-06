package onlinebankingsystem;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

public class DialogShowUsers extends JDialog
{

	private final JPanel contentPanel = new JPanel();
	private JTable tableClients;
	private ClientDatabase clientDB;
	private DefaultTableModel model;
	private JTextField txtQuery;
	private int querySelection = 0;

	/**
	 * Launch the application.
	 */

	/*
	 * depreciated public static void main(String[] args) { try {
	 * DialogShowUsers dialog = new DialogShowUsers();
	 * dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	 * dialog.setVisible(true); } catch (Exception e) { e.printStackTrace(); } }
	 */

	/**
	 * Create the dialog.
	 */
	public DialogShowUsers(ClientDatabase clientDB)
	{
		init();

		this.clientDB = clientDB;

		showUsers();
	}

	private void init()
	{
		setBounds(100, 100, 700, 500);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			tableClients = new JTable();
			tableClients.setBounds(12, 40, 660, 411);
			contentPanel.add(tableClients);
		}

		txtQuery = new JTextField();
		txtQuery.setBounds(453, 9, 116, 21);
		contentPanel.add(txtQuery);
		txtQuery.setColumns(10);

		JButton btnSearch = new JButton("ShowUser");
		btnSearch.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				String query = txtQuery.getText();

				ArrayList<Client> clientList = null;
				if (query.equals(""))
				{
					clientList = clientDB.getClientList();
				} else
				{
					switch (querySelection)
					{
					case 0:
						clientList = clientDB.findClientByID(Integer.parseInt(query));
						break;
					case 1:
						clientList = clientDB.findClientByName(query);
						break;
					case 2:
						clientList = clientDB.findClientByAddress(query);
						break;
					}
				}

				if (clientList != null)
				{
					updateUser(clientList);
				}
			}
		});
		btnSearch.setBounds(575, 8, 97, 23);
		contentPanel.add(btnSearch);

		JRadioButton rdbtnId = new JRadioButton("ID");
		rdbtnId.setSelected(true);
		rdbtnId.setBounds(277, 8, 37, 23);
		rdbtnId.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				System.out.println("Today Radio Button Clicked!");
				querySelection = 0;
			}
		});

		contentPanel.add(rdbtnId);

		JRadioButton rdbtnName = new JRadioButton("Name");
		rdbtnName.setBounds(314, 8, 59, 23);
		rdbtnName.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				System.out.println("Today Radio Button Clicked!");
				querySelection = 1;
			}
		});

		contentPanel.add(rdbtnName);

		JRadioButton rdbtnAddress = new JRadioButton("Address");
		rdbtnAddress.setBounds(369, 8, 79, 23);
		rdbtnAddress.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				System.out.println("Today Radio Button Clicked!");
				querySelection = 2;
			}
		});

		contentPanel.add(rdbtnAddress);

		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnId);
		group.add(rdbtnName);
		group.add(rdbtnAddress);
	}

	private void showUsers()
	{
		model = new DefaultTableModel(0, 0);

		ArrayList<Client> clientList = clientDB.getClientList();

		String columnNames[] =
		{ "ID", "이름", "주민등록번호", "이메일", "주소" };

		model.setColumnIdentifiers(columnNames);
		tableClients.setModel(model);

		model.addRow(new Object[]
		{ "ID", "이름", "주민등록번호", "이메일", "주소" });

		int size = clientList.size();
		for (int i = 0; i < size; ++i)
		{
			Client c = clientList.get(i);
			model.addRow(new Object[]
			{ c.getId(), c.getName(), c.getBirth(), c.getEMail(), c.getAddress() });
		}
	}

	private void updateUser(ArrayList<Client> clientList)
	{
		model = new DefaultTableModel(0, 0);

		String columnNames[] =
		{ "ID", "이름", "주민등록번호", "이메일", "주소" };

		model.setColumnIdentifiers(columnNames);
		tableClients.setModel(model);

		model.addRow(new Object[]
		{ "ID", "이름", "주민등록번호", "이메일", "주소" });

		int size = clientList.size();
		for (int i = 0; i < size; ++i)
		{
			Client c = clientList.get(i);
			model.addRow(new Object[]
			{ c.getId(), c.getName(), c.getBirth(), c.getEMail(), c.getAddress() });
		}
	}
}
