package AccountStrategyPattern;

public class SavingCalculateInterest implements CalculateInterest
{
	public int calculateInterest(Account account)
	{
		System.out.print("이자 : ");
		return (int)(account.balance * 0.05);	// 매년 잔고의 +5%
	}
}
