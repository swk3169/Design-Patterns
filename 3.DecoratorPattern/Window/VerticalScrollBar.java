package WindowDecoratorPattern;

public class VerticalScrollBar extends WindowDecorator
{
	public VerticalScrollBar(Window w)
	{
		super(w);
	}
	
	public void draw()
	{
		super.draw();	//(����)
//		draw vertical scoll bar;	// �ൿ �߰�
		System.out.println("vertical scroll!");
	}
}
