package DuckStrategyPattern;

public class Main
{
	public static void main(String[] args) 
	{
		Duck[] ducks = {
				new MallardDuck(),
				new RubberDuck()
		};
		
		for(int i = 0; i < 2; i++)
		{
			ducks[i].display();
			ducks[i].fly();
			ducks[i].quack();
			System.out.println("天天天天天天天天天天天天天天天");
		}
		
	}
}
