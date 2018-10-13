package AccountFactoryPattern;

public class BankA extends Bank
{
	public BankA()
	{
		System.out.println("BankA »ý¼º");
	}
	
	public Account createAccount(String item)
	{
		Account account = null;
		if(item.equals("Normal"))
		{
			return new NormalAccountA();
		}
		else if(item.equals("Minus"))
		{
			return new MinusAccountA();
		}
		else if(item.equals("Security"))
		{
			return new SecurityAccountA();
		}
		return null;
	}
}
