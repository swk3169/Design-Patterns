package AccountFactoryPattern;

public abstract class Account
{
	protected int balance;
	public int getBalance()
	{
		return balance;
	}
	
	public void deposit(int money)
	{
		System.out.println("�Աݾ� : " + money);
		balance = balance + money;
	}
	
	abstract void withdraw(int money);
}