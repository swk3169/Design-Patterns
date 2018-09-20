package DuckStrategyPattern;

public class RubberDuck extends Duck
{
	// 생성자에서 자신의 (default) 행동 생성(설정)
	public RubberDuck() 
	{ 
		flyBehavior = new FlyWithWings(); 
		quackBehavior = new QuackWithWings(); 
	}
	
	public void display() { System.out.println("I'm a real Rubber duck"); }
}
