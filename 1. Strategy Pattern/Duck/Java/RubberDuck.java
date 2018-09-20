package DuckStrategyPattern;

public class RubberDuck extends Duck
{
	// �����ڿ��� �ڽ��� (default) �ൿ ����(����)
	public RubberDuck() 
	{ 
		flyBehavior = new FlyWithWings(); 
		quackBehavior = new QuackWithWings(); 
	}
	
	public void display() { System.out.println("I'm a real Rubber duck"); }
}
