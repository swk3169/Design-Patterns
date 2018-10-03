package BeverageDecoratorPattern;

public class Mocha extends CondimentDecorator
{
	public Mocha(Beverage beverage)
	{
		this.beverage = beverage;
	}
	
	public String getDescription()
	{
		return beverage.getDescription() + ", Mocha";
	}
	
	public double cost()
	{
		return 0.20 + beverage.cost();
	}
}
