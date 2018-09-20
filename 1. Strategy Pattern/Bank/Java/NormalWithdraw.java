package AccountStrategyPattern;

public class NormalWithdraw implements Withdraw
{
	public void withdraw(Account account, int money)
	{
		System.out.println("출금액 : " + money);
		
		if(account.balance - money < 0)
		{
			System.out.println("잔액이 부족합니다!");
		}
		else
		{
			account.balance = account.balance - money;
		}
	}
}
