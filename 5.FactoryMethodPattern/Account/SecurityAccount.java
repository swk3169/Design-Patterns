package AccountFactoryPattern;

public class SecurityAccount extends Account
{
	public SecurityAccount()
	{
		balance = 0;
	}
	
	void withdraw(int money)
	{
		System.out.println("��ݾ� : " + money);
		if(balance - money < 0)
		{
			System.out.println("��� ����, �ܾ׺���!");
			return;
		}
		
		balance = balance - money;
	}
}
