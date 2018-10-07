package ChocolateSingletonPattern;

public class ChocolateController
{
	public static void main(String args[]) 
	{
		ChocolateBoiler boiler = ChocolateBoiler.getInstance();
		boiler.fill();
		boiler.boil();
		boiler.drain();
		
		// will return the existing instance
		ChocolateBoiler boiler2 = ChocolateBoiler.getInstance();
		boiler2.fill();
		boiler2.boil();
		boiler2.drain();
	}
}
