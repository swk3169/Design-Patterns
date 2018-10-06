package WindowDecoratorPattern;

public class VerticalScrollBar extends WindowDecorator
{
	public VerticalScrollBar(Window w)
	{
		super(w);
	}
	
	public void draw()
	{
		// �ൿ �߰�
		System.out.println("vertical scroll!");
		wrappedWindow.draw();
	}
	
	public String getDescription()
	{
		return wrappedWindow.getDescription();
	}
}
