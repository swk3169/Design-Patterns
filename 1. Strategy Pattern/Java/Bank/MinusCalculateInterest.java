package AccountStrategyPattern;

public class MinusCalculateInterest implements CalculateInterest
{
	public int calculateInterest(Account account)
	{
		System.out.print("이자 : ");
		return (int)(account.balance * -0.07);	// 대출금의 -7%
	}
}
