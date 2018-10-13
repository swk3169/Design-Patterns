package AccountFactoryPattern;

public class NormalAccountA extends Account
{
	public NormalAccountA()
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