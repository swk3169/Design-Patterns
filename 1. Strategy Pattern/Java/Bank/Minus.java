package AccountStrategyPattern;

public class Minus extends Account
{
	public Minus() 
	{
		W = new MinusWithdraw();
		CI = new MinusCalculateInterest();
	}
	public int getBalance()
	{
		System.out.print("�ܾ� : ");
		return balance;
	}
	public void deposit(int money)
	{
		System.out.println("�Աݾ� : " + money);
		balance = balance + money;
	}
}
