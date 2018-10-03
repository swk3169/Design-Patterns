package AirplaneDecoratorPattern;

public class SideAttackAirplane extends Decorator
{
	Airplane airplane;
	
	public SideAttackAirplane(Airplane airplane)
	{
		this.airplane = airplane;
	}
	
	public void attack()
	{
		airplane.attack();	// Delegation
		System.out.println("Side Attack!");	// 측면 공격
	}
}
