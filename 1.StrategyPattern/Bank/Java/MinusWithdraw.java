package AccountStrategyPattern;

public class MinusWithdraw implements Withdraw
{
	public void withdraw(Account account, int money)
	{
		System.out.println("��ݾ� : " + money);
		
		if(account.balance - money < account.creditLimit)
		{
			System.out.println("�ѵ� �ʰ�!");
		}
		else
		{
			account.balance = account.balance - money;
		}
	}
}
