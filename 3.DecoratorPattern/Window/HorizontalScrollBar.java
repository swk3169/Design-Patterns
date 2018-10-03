package WindowDecoratorPattern;

public class HorizontalScrollBar extends WindowDecorator
{
	public HorizontalScrollBar(Window w)
	{
		super(w);
	}
	
	public void draw()
	{
		super.draw();	//(위임)
//		draw vertical scoll bar;	// 행동 추가
		System.out.println("horizontals scroll!");
	}
}
