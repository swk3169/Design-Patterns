package AccountStrategyPattern;

public class Normal extends Account
{
	public Normal()
	{
		W = new NormalWithdraw();
		CI = new NormalCalculateInterest();
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
