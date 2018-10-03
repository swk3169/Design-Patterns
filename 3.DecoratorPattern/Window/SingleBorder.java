package WindowDecoratorPattern;

public class SingleBorder extends WindowDecorator
{
	public SingleBorder(Window w)
	{
		super(w);
	}
	
	public void draw()
	{
		super.draw();	//(위임)
		// 행동 추가
		System.out.println("single border!");
	}
}
