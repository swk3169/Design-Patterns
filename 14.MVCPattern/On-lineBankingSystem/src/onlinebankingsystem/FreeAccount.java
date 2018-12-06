package onlinebankingsystem;

public class FreeAccount extends Account
{
	private long money;

	public FreeAccount(int pin, long amount, int client_id)
	{
		super(pin, amount, client_id);
	}

	public boolean credit(long amount)
	{
		money = (long) (balance + (amount * 1.02));

		balance -= money;

		return true;
	}

	public boolean debit(long amount)
	{
		if (this.balance >= amount)
		{
			money = (long) (balance - (amount * 1.02));
			balance -= money;
			return true;
		} else
			return false;
	}

	public String toString()
	{
		return "ÀÚÀ¯";
	}
}
