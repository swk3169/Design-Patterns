package onlinebankingsystem;

// depreciated
public class BalanceInquiry extends AccountCommand
{
	private int account_number;
	
	public BalanceInquiry(AccountDatabase accountDB, int account_number)
	{
		super.accountDB = accountDB;
		this.account_number = account_number;
	}

	public void excute() {
		// TODO Auto-generated method stub
		
	}
}