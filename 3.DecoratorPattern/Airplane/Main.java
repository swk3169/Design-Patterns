package AirplaneDecoratorPattern;

public class Main
{
	public static void main(String args[])
	{
		Airplane airplane = new FrontAttackAirplane();
		airplane.attack();
		airplane = new SideAttackAirplane(airplane);
		airplane.attack();
		airplane = new RearAttackAirplane(airplane);
		airplane.attack();
	}
}
