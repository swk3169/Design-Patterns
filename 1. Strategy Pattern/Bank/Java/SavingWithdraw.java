package AccountStrategyPattern;

import java.util.Date;

public class SavingWithdraw implements Withdraw
{
	public void withdraw(Account account, int money)
	{
		Date date = new Date();
		System.out.println("��ݾ� : " + money);
		
		if(date.getDate() != account.expirationDate)
		{
			System.out.println("��� ��� �Ⱓ�� �ƴմϴ�!");
		}
		else
		{
			account.balance = account.balance - money;
		}
		
	}
}
