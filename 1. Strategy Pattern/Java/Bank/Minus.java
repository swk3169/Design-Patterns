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
		System.out.print("잔액 : ");
		return balance;
	}
	public void deposit(int money)
	{
		System.out.println("입금액 : " + money);
		balance = balance + money;
	}
}
