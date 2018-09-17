package AccountStrategyPattern;

public abstract class Account
{
	protected int balance = 0;	// �ܰ�
	protected int expirationDate = 30;	// ��ุ����
	protected int creditLimit = -1000;	// �ſ��ѵ���
	protected Withdraw W;	// ���
	protected CalculateInterest CI;	// ���ڰ��
	
	public abstract int getBalance();
	public abstract void deposit(int money);
	public void withdraw(int money) { W.withdraw(this, money);}
	public int calculateInterest() { return CI.calculateInterest(this);}
}
