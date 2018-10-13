package AccountFactoryPattern;

public class BankC extends Bank
{
	public BankC()
	{
		System.out.println("BankC »ý¼º");
	}
	
	public Account createAccount(String item)
	{
		Account account = null;
		if(item.equals("Normal"))
		{
			return new NormalAccountC();
		}
		else if(item.equals("Minus"))
		{
			return new MinusAccountC();
		}
		return null;
	}
}
