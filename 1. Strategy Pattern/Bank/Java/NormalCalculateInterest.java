package AccountStrategyPattern;

public class NormalCalculateInterest implements CalculateInterest
{
	public int calculateInterest(Account account)
	{
		System.out.print("���� : ");
		return (int)(account.balance * 0.03);	// �ܰ��� +3%
	}
}
