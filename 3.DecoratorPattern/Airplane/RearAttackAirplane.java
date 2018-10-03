package AirplaneDecoratorPattern;

public class RearAttackAirplane extends Decorator
{
	Airplane airplane;
	
	public RearAttackAirplane(Airplane airplane)
	{
		this.airplane = airplane;
	}
	
	public void attack()
	{
		airplane.attack();
		System.out.println("Rear Attack!");
	}
}
