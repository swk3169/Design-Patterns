package BeverageDecoratorPattern;

public class DarkRoast implements Beverage
{
	private String description;
	
	public DarkRoast()
	{
		description = "Dark Roast Coffee";
	}
	
	public double cost()
	{
		return 0.99;
	}

	@Override
	public String getDescription()
	{
		// TODO Auto-generated method stub
		return description;
	}
}
