package WindowDecoratorPattern;

public class SimpleWindow implements Window
{
	public void draw()
	{
		System.out.println("draw!");
	}
	
	public String getDescription()
	{
		return "simple window";
	}
}
