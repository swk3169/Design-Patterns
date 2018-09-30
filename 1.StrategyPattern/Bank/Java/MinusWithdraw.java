package AccountStrategyPattern;

public class MinusWithdraw implements Withdraw
{
	public void withdraw(Account account, int money)
	{
		System.out.println("출금액 : " + money);
		
		if(account.balance - money < account.creditLimit)
		{
			System.out.println("한도 초과!");
		}
		else
		{
			account.balance = account.balance - money;
		}
	}
}
