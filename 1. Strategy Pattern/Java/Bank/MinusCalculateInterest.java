package AccountStrategyPattern;

public class MinusCalculateInterest implements CalculateInterest
{
	public int calculateInterest(Account account)
	{
		System.out.print("���� : ");
		return (int)(account.balance * -0.07);	// ������� -7%
	}
}
