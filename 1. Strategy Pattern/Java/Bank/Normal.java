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
		System.out.print("잔액 : ");
		return balance;
	}
	public void deposit(int money)
	{
		System.out.println("입금액 : " + money);
		balance = balance + money;
	}
}
