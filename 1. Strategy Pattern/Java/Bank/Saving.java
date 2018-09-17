package AccountStrategyPattern;

public class Saving extends Account
{
	public Saving()
	{
		W = new SavingWithdraw();
		CI = new SavingCalculateInterest();
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
