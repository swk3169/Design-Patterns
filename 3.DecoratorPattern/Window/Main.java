package WindowDecoratorPattern;

public class Main
{
	public static void main(String[] args)
	{
		Window window = new SimpleWindow();
		window = new VerticalScrollBar(window);
//		window = new HorizontalScrollBar(window);
//		
//		window = new DoubleBorder(window);
//		window.draw();
		
		window = new SingleBorder(window);
		window.draw();
	}
}
