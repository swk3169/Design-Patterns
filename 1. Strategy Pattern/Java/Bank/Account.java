package AccountStrategyPattern;

public abstract class Account
{
	protected int balance = 0;	// 잔고
	protected int expirationDate = 30;	// 계약만료일
	protected int creditLimit = -1000;	// 신용한도액
	protected Withdraw W;	// 출금
	protected CalculateInterest CI;	// 이자계산
	
	public abstract int getBalance();
	public abstract void deposit(int money);
	public void withdraw(int money) { W.withdraw(this, money);}
	public int calculateInterest() { return CI.calculateInterest(this);}
}
