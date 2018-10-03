package WindowDecoratorPattern;

public class SingleBorder extends WindowDecorator
{
	public SingleBorder(Window w)
	{
		super(w);
	}
	
	public void draw()
	{
		super.draw();	//(����)
		// �ൿ �߰�
		System.out.println("single border!");
	}
}
