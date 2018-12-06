package onlinebankingsystem;

public class MinusAccount extends Account
{
	private long money;

	public MinusAccount(int pin, long amount, int client_id)
	{
		super(pin, amount, client_id);
	}

	public boolean credit(long amount)
	{
		money = balance + amount;
		if (money > 0)
		{
			money = (long) (money * 1.01);
			balance += money;
		} else
		{
			money = (long) (money * 1.05);
			balance += money;
		}

		return true;
	}

	public boolean debit(long amount)
	{
		money = balance - amount;
		if (money > 0)
		{
			money = (long) (money * 1.01);
			balance -= money;
		} else
		{
			money = (long) (money * 1.05);
			balance -= money;
		}

		return false;
	}

	public String toString()
	{
		return "마이너스";
	}
}
