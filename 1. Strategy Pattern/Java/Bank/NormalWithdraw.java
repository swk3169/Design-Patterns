package AccountStrategyPattern;

public class NormalWithdraw implements Withdraw
{
	public void withdraw(Account account, int money)
	{
		System.out.println("��ݾ� : " + money);
		
		if(account.balance - money < 0)
		{
			System.out.println("�ܾ��� �����մϴ�!");
		}
		else
		{
			account.balance = account.balance - money;
		}
	}
}
