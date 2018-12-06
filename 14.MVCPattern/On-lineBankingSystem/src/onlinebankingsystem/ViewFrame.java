package onlinebankingsystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ViewFrame implements ActionListener, Observer
{
	ClientCommand clientCommand;
	AccountCommand accountCommand;
	ClientDatabase clientDB;
	AccountDatabase accountDB;
	TransactionDatabase transactionDB;

	public ViewFrame(ClientCommand clientCommand, AccountCommand accountCommand, ClientDatabase clientDB,
			AccountDatabase accountDB, TransactionDatabase transactionDB)
	{
		this.clientCommand = clientCommand;
		this.accountCommand = accountCommand;
		this.clientDB = clientDB;
		this.accountDB = accountDB;
		this.transactionDB = transactionDB;
	}

	public void init()
	{

	}

	private void run()
	{

	}

	public void actionPerformed(ActionEvent e)
	{

	}

	public void update(Object object)
	{
		if (object instanceof ClientDatabase)
		{
			updateClientDatabase();
		} else if (object instanceof AccountDatabase)
		{
			updateAccountDatabase();
		} else if (object instanceof TransactionDatabase)
		{
			updateTransactionDatabase();
		}
	}

	private void updateClientDatabase()
	{

	}

	private void updateAccountDatabase()
	{

	}

	private void updateTransactionDatabase()
	{

	}
}
