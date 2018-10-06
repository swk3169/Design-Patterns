package WindowDecoratorPattern;

public class VerticalScrollBar extends WindowDecorator
{
	public VerticalScrollBar(Window w)
	{
		super(w);
	}
	
	public void draw()
	{
		// 행동 추가
		System.out.println("vertical scroll!");
		wrappedWindow.draw();
	}
	
	public String getDescription()
	{
		return wrappedWindow.getDescription();
	}
}
