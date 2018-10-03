package CarDecoratorPattern;

public class DriveDrivingCar extends Gear
{
	Car car;
	
	public DriveDrivingCar(Car car)
	{
		this.car = car;
	}
	
	public void drive()
	{
		System.out.println("Drive Gear!");
	}
}
