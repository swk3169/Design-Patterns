package AccountFactoryPattern;

public class MinusAccountA extends Account
{
	public MinusAccountA() 
	{
		balance = 0;
	}
	
	void withdraw(int money)
	{
		System.out.println("출금액 : " + money);
		int max = -1000;
		if(balance - money < max)
		{
			System.out.println("출금 실패, 한도초과!");
			return;
		}
		
		balance = balance - money;
	}
}
