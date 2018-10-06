package WindowDecoratorPattern;

public class DoubleBorder extends WindowDecorator
{
	public DoubleBorder(Window w)
	{
		super(w);
	}
	
	public void draw()
	{
		// �ൿ �߰�
		System.out.println("double border!");
		wrappedWindow.draw();
	}
	
	public String getDescription()
	{
		return wrappedWindow.getDescription();
	}
}
