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
		System.out.print("�ܾ� : ");
		return balance;
	}
	
	public void deposit(int money)
	{
		System.out.println("�Աݾ� : " + money);
		balance = balance + money;
	}
}
