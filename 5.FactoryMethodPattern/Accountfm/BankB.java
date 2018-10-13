package AccountFactoryPattern;

public class BankB extends Bank
{
	public BankB()
	{
		System.out.println("BankB »ý¼º");
	}
	
	public Account createAccount(String item)
	{
		Account account = null;
		if(item.equals("Normal"))
		{
			return new NormalAccountB();
		}
		else if(item.equals("Minus"))
		{
			return new MinusAccountB();
		}
		else if(item.equals("Security"))
		{
			return new SecurityAccountB();
		}
		return null;
	}
}
