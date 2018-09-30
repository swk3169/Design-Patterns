package AccountStrategyPattern;

public class NormalCalculateInterest implements CalculateInterest
{
	public int calculateInterest(Account account)
	{
		System.out.print("이자 : ");
		return (int)(account.balance * 0.03);	// 잔고의 +3%
	}
}
