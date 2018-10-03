package CarDecoratorPattern;

public class ReversDrivingCar extends Gear
{
	Car car;
	
	public ReversDrivingCar(Car car)
	{
		this.car = car;
	}
	
	public void drive()
	{
		System.out.println("Revers!");
	}
}
