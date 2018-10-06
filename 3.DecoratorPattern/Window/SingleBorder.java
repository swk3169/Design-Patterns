package WindowDecoratorPattern;

public class SingleBorder extends WindowDecorator
{
	public SingleBorder(Window w)
	{
		super(w);
	}
	
	public void draw()
	{
		// 행동 추가
		System.out.println("single border!");
		wrappedWindow.draw();
	}
	
	public String getDescription()
	{
		return wrappedWindow.getDescription();
	}
}
