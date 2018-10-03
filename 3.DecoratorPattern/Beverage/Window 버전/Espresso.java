package BeverageDecoratorPattern;

public class Espresso implements Beverage
{
	private String description;
	
	public Espresso()
	{
		description = "Expresso";
	}

	public double cost()
	{
		return 1.99;
	}

	@Override
	public String getDescription()
	{
		// TODO Auto-generated method stub
		return description;
	}
}
