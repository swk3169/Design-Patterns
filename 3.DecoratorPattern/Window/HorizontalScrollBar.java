package WindowDecoratorPattern;

public class HorizontalScrollBar extends WindowDecorator
{
	public HorizontalScrollBar(Window w)
	{
		super(w);
	}
	
	public void draw()
	{
		super.draw();	//(����)
//		draw vertical scoll bar;	// �ൿ �߰�
		System.out.println("horizontals scroll!");
	}
}
