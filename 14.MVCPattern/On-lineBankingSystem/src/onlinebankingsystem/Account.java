package onlinebankingsystem;

public class Account
{
	static protected int ACC_NUMBER = 0;

	protected int account_number;
	protected long balance;

	private int pin;

	// private Client client;
	private int client_id;

	public Account()
	{
	}

	public Account(int pin, long balance, int client_id)
	{
		this.account_number = ACC_NUMBER++;
		this.pin = pin;
		this.balance = balance;
		this.client_id = client_id;
	}

	public boolean validatePIN(int pin)
	{
		return (this.pin == pin) ? true : false;
	}

	public int getAccountNumber()
	{
		return account_number;
	}

	public int getPIN()
	{
		return pin;
	}

	public long getBalance()
	{
		return balance;
	}

	public int getClientId()
	{
		return client_id;
	}

	public void setAccountNumber(int account_number)
	{
		this.account_number = account_number;
		Account.ACC_NUMBER = ++account_number;
	}

	public boolean credit(long amount)
	{
		this.balance += amount;
		return true;
	}

	public boolean debit(long amount)
	{
		if (this.balance >= amount)
		{
			this.balance -= amount;
			return true;
		} else
		{
			return false;
		}
	}

	public String toString()
	{
		return "¿œπ›";
	}
}
