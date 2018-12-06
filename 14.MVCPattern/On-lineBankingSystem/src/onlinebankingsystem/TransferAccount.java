package onlinebankingsystem;

public class TransferAccount extends AccountCommand
{
	private int account_number;

	public TransferAccount(AccountDatabase accountDB, TransactionDatabase transactionDB, int account_number)
	{
		super.accountDB = accountDB;
		this.account_number = account_number;
	}

	public void execute()
	{
		// TODO Auto-generated method stub

	}
}
