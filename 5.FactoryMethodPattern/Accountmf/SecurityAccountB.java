package AccountFactoryPattern;

public class SecurityAccountB extends Account
{
	public SecurityAccountB()
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
