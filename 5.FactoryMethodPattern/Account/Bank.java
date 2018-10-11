package AccountFactoryPattern;

public class Bank
{
	AccountFactory accountFactory;
	
	public Bank(AccountFactory accountFactory)
	{
		this.accountFactory = accountFactory;
	}
	
	public Account orderAccount(String type)
	{
		Account account;
		account = accountFactory.createAccount(type);
		account.deposit(500);
		account.withdraw(1000);
		return account;
	}
}
