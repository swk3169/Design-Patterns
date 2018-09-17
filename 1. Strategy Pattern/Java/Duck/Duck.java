package DuckStrategyPattern;

public abstract class Duck implements FlyBehavior, QuackBehavior
{
	FlyBehavior flyBehavior;
	QuackBehavior quackBehavior;
	
	abstract public void display();
	public void swim() { System.out.println("All ducks float, even decoys!");}
	public void fly() { flyBehavior.fly(); }
	public void quack() { quackBehavior.quack(); }
	// 실행 중 행동 변경도 가능
	public void setFlyBehavior(FlyBehavior fb) { flyBehavior = fb; }
	public void setQuackBehavior(QuackBehavior qb) { quackBehavior = qb; }
}
