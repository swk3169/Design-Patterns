package DuckStrategyPattern;

public class MallardDuck extends Duck
{
	// �����ڿ��� �ڽ��� (default) �ൿ ����(����)
	public MallardDuck() 
	{ 
		flyBehavior = new FlyWithWings(); 
		quackBehavior = new QuackWithWings(); 
	}
	
	public void display() { System.out.println("I'm a real Mallard duck"); }
}
