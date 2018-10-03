package CarDecoratorPattern;

public class Main
{
	public static void main(String[] args)
	{
		Car car = new DrivingCar();
		car.drive();
		car = new DriveDrivingCar(car);
		car.drive();
		car = new NeutralDrivingCar(car);
		car.drive();
		car = new ReversDrivingCar(car);
		car.drive();
		car = new ParkingDrivingCar(car);
		car.drive();
	}
}