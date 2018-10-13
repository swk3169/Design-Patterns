package AccountFactoryPattern;

public class NormalAccountB extends Account
{
	public NormalAccountB()
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
