package onlinebankingsystem;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class DialogShowTransactions extends JDialog
{

	private final JPanel contentPanel = new JPanel();
	private JTable tableTransactions;

	private int acc_number;
	private TransactionDatabase transactionDB;
	private DefaultTableModel model;
	private JTextField txtMonth;

	/**
	 * Launch the application.
	 */
	/*
	 * depreciated public static void main(String[] args) { try {
	 * DialogShowTransactions dialog = new DialogShowTransactions();
	 * dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	 * dialog.setVisible(true); } catch (Exception e) { e.printStackTrace(); } }
	 */

	/**
	 * Create the dialog.
	 */
	public DialogShowTransactions(int acc_number, TransactionDatabase transactionDB)
	{
		init();

		this.acc_number = acc_number;
		this.transactionDB = transactionDB;

		showTransactions();
	}

	private void init()
	{
		setTitle("ShowTransaction");
		setBounds(100, 100, 450, 327);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			tableTransactions = new JTable();
			tableTransactions.setBounds(12, 37, 410, 241);
			contentPanel.add(tableTransactions);
		}

		JRadioButton rdbtnTotal = new JRadioButton("Total");
		rdbtnTotal.setSelected(true);
		rdbtnTotal.setBounds(8, 8, 121, 23);
		rdbtnTotal.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				System.out.println("Total Radio Button Clicked!");
				ArrayList<Transaction> transactionList = transactionDB.getTransactionList();
				updateTransaction(transactionList);
			}
		});

		contentPanel.add(rdbtnTotal);

		JRadioButton rdbtnToday = new JRadioButton("Today");
		rdbtnToday.setBounds(133, 8, 121, 23);
		rdbtnToday.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				System.out.println("Today Radio Button Clicked!");
				ArrayList<Transaction> transactionList = transactionDB.getTransactionListInDuration(acc_number, 1);
				updateTransaction(transactionList);
			}
		});

		contentPanel.add(rdbtnToday);

		txtMonth = new JTextField();
		txtMonth.setText("1");
		txtMonth.setBounds(325, 9, 31, 21);
		contentPanel.add(txtMonth);
		txtMonth.setColumns(10);

		JRadioButton rdbtnMonth = new JRadioButton("Month");
		rdbtnMonth.setBounds(258, 8, 61, 23);
		rdbtnMonth.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				System.out.println("Month Radio Button Clicked!");
				String strMonth = txtMonth.getText();
				int month = Integer.parseInt(strMonth);

				ArrayList<Transaction> transactionList = transactionDB.getTransactionListInDuration(acc_number,
						month * 30);
				updateTransaction(transactionList);
			}
		});

		ButtonGroup group = new ButtonGroup();

		group.add(rdbtnTotal);
		group.add(rdbtnToday);
		group.add(rdbtnMonth);

		contentPanel.add(rdbtnMonth);
	}

	private void showTransactions()
	{
		model = new DefaultTableModel(0, 0);

		ArrayList<Transaction> transactionList = transactionDB.getTransactionList(acc_number);

		String columnNames[] =
		{ "시간", "금액", "거래종류", "비고" };

		model.setColumnIdentifiers(columnNames);
		tableTransactions.setModel(model);

		model.addRow(new Object[]
		{ "시간", "금액", "거래종류", "비고" });

		int size = transactionList.size();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");

		for (int i = 0; i < size; ++i)
		{
			Transaction transaction = transactionList.get(i);
			model.addRow(new Object[]
			{ format.format(transaction.getDate()), transaction.getAmount(), transaction.getTransactionInfo(),
					transaction.getRemarks() });
		}
	}

	private void updateTransaction(ArrayList<Transaction> transactionList)
	{
		model = new DefaultTableModel(0, 0);

		String columnNames[] =
		{ "시간", "금액", "거래종류", "비고" };

		model.setColumnIdentifiers(columnNames);
		tableTransactions.setModel(model);

		model.addRow(new Object[]
		{ "시간", "금액", "거래종류", "비고" });

		int size = transactionList.size();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");

		for (int i = 0; i < size; ++i)
		{
			Transaction transaction = transactionList.get(i);
			model.addRow(new Object[]
			{ format.format(transaction.getDate()), transaction.getAmount(), transaction.getTransactionInfo(),
					transaction.getRemarks() });
		}
	}
}
