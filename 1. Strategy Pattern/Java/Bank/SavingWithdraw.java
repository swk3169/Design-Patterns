package AccountStrategyPattern;

import java.util.Date;

public class SavingWithdraw implements Withdraw
{
	public void withdraw(Account account, int money)
	{
		Date date = new Date();
		System.out.println("출금액 : " + money);
		
		if(date.getDate() != account.expirationDate)
		{
			System.out.println("출금 허용 기간이 아닙니다!");
		}
		else
		{
			account.balance = account.balance - money;
		}
		
	}
}
