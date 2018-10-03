package CarDecoratorPattern;

public class NeutralDrivingCar extends Gear
{
	Car car;
	
	public NeutralDrivingCar(Car car)
	{
		this.car = car;
	}
	
	public void drive()
	{
		System.out.println("Neutral!");
	}
}
