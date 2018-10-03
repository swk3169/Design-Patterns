package BeverageDecoratorPattern;

public class HouseBlend implements Beverage
{
	private String description;
	
	public HouseBlend()
	{
		description = "House Blend Coffe";
	}
	
	public double cost()
	{
		return 0.89;
	}

	@Override
	public String getDescription()
	{
		// TODO Auto-generated method stub
		return description;
	}
}
