package BeverageDecoratorPattern;

public class HouseBlend extends Beverage
{
	public HouseBlend()
	{
		description = "House Blend Coffe";
	}
	
	public double cost()
	{
		return 0.89;
	}
}
