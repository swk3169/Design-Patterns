package AccountFactoryPattern;

public class SecurityAccount extends Account
{
	public SecurityAccount()
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
