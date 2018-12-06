package onlinebankingsystem;

public class Withdraw extends AccountCommand
{
	private int account_number;
	private int amount;

	public Withdraw(AccountDatabase accountDB, TransactionDatabase transactionDB, int account_number, int amount)
	{
		super.accountDB = accountDB;
		super.transactionDB = transactionDB;
		this.account_number = account_number;
		this.amount = amount;
	}

	public void execute()
	{
		// TODO Auto-generated method stub
		long balance;

		balance = accountDB.getBalance(account_number);
		if (amount <= balance)
		{
			accountDB.debit(account_number, amount);
		} else
		{
			// screen.displayMsgLine(""\n잔고가 부족합니다.");
		}
	}
}
