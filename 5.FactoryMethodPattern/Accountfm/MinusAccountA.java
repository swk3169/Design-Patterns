package AccountFactoryPattern;

public class MinusAccountA extends Account
{
	public MinusAccountA() 
	{
		balance = 0;
	}
	
	void withdraw(int money)
	{
		System.out.println("��ݾ� : " + money);
		int max = -1000;
		if(balance - money < max)
		{
			System.out.println("��� ����, �ѵ��ʰ�!");
			return;
		}
		
		balance = balance - money;
	}
}
