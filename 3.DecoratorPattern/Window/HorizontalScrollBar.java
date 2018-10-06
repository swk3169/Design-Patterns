package WindowDecoratorPattern;

public class HorizontalScrollBar extends WindowDecorator
{
	public HorizontalScrollBar(Window w)
	{
		super(w);
	}
	
	public void draw()
	{
		// 행동 추가
		System.out.println("horizontals scroll!");
		wrappedWindow.draw();
	}
	
	public String getDescription()
	{
		return wrappedWindow.getDescription();
	}
}
