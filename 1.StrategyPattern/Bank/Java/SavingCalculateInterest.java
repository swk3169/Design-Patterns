package AccountStrategyPattern;

public class SavingCalculateInterest implements CalculateInterest
{
	public int calculateInterest(Account account)
	{
		System.out.print("���� : ");
		return (int)(account.balance * 0.05);	// �ų� �ܰ��� +5%
	}
}
