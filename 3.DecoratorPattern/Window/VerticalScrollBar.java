package WindowDecoratorPattern;

public class VerticalScrollBar extends WindowDecorator
{
	public VerticalScrollBar(Window w)
	{
		super(w);
	}
	
	public void draw()
	{
		super.draw();	//(위임)
//		draw vertical scoll bar;	// 행동 추가
		System.out.println("vertical scroll!");
	}
}
