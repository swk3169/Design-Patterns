package onlinebankingsystem;

public class Deposit extends AccountCommand
{
	private int account_number;
	private int amount;

	public Deposit(AccountDatabase accountDB, TransactionDatabase transactionDB, int account_number, int amount)
	{
		super.accountDB = accountDB;
		super.transactionDB = transactionDB;
		this.account_number = account_number;
		this.amount = amount;
	}

	public void execute()
	{
		// TODO Auto-generated method stub
		accountDB.credit(account_number, amount);
	}
}
