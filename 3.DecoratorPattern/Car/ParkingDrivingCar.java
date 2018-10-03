package CarDecoratorPattern;

public class ParkingDrivingCar extends Gear
{
	Car car;
	
	public ParkingDrivingCar(Car car)
	{
		this.car = car;
	}
	
	public void drive()
	{
		System.out.println("Parking!");
	}
}
