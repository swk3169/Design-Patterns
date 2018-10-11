package AccountFactoryPattern;

public class NormalAccountA extends Account
{
	public NormalAccountA()
	{
		balance = 0;
	}
	
	void withdraw(int money)
	{
		System.out.println("출금액 : " + money);
		if(balance - money < 0)
		{
			System.out.println("출금 실패, 잔액부족!");
			return;
		}
		
		balance = balance - money;
	}
}