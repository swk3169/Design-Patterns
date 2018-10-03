package BeverageDecoratorPattern;

public class Decaf implements Beverage
{
	private String description;
	
	public Decaf()
	{
		description = "Decaf Coffee";
	}
	
	public double cost()
	{
		return 1.05;
	}

	@Override
	public String getDescription()
	{
		// TODO Auto-generated method stub
		return description;
	}
}
