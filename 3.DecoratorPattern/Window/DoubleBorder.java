package WindowDecoratorPattern;

public class DoubleBorder extends WindowDecorator
{
	public DoubleBorder(Window w)
	{
		super(w);
	}
	
	public void draw()
	{
		super.draw();	//(위임)
		// 행동 추가
		System.out.println("double border!");
	}
}
