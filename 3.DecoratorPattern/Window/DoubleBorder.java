package WindowDecoratorPattern;

public class DoubleBorder extends WindowDecorator
{
	public DoubleBorder(Window w)
	{
		super(w);
	}
	
	public void draw()
	{
		super.draw();	//(����)
		// �ൿ �߰�
		System.out.println("double border!");
	}
}
