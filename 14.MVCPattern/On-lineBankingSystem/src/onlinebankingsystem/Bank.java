package onlinebankingsystem;

import java.awt.EventQueue;

// Main
public class Bank
{
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					ClientDatabase clientDB = new ClientDatabase();
					AccountDatabase accountDB = new AccountDatabase();
					TransactionDatabase transactionDB = new TransactionDatabase();

					ClientFileManager cfm = new ClientFileManager();
					AccountFileManager afm = new AccountFileManager();
					TransactionFileManager tfm = new TransactionFileManager();

					cfm.load(clientDB);
					afm.load(accountDB);
					tfm.load(transactionDB);

					AdminApp frame = new AdminApp(clientDB, accountDB, transactionDB);

					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}
}