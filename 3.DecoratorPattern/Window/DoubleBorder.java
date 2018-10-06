package WindowDecoratorPattern;

public class DoubleBorder extends WindowDecorator
{
	public DoubleBorder(Window w)
	{
		super(w);
	}
	
	public void draw()
	{
		// 행동 추가
		System.out.println("double border!");
		wrappedWindow.draw();
	}
	
	public String getDescription()
	{
		return wrappedWindow.getDescription();
	}
}
