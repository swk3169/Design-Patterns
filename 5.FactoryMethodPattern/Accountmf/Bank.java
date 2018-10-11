package AccountFactoryPattern;

public abstract class Bank
{	
	public Account orderAccount(String type)
	{
		Account account;
		account = createAccount(type);
		account.deposit(500);
		account.withdraw(1000);
		return account;
	}
	
	abstract public Account createAccount(String item);
}
