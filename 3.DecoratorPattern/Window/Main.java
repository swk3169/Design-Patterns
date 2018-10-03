package WindowDecoratorPattern;

public class Main
{
	public static void main(String[] args)
	{
		Window w = new SimpleWindow();
		w.draw();
		w = new VerticalScrollBar(w);
		w.draw();
		w = new HorizontalScrollBar(w);
		w.draw();
		w = new SingleBorder(w);
		w.draw();
		w = new DoubleBorder(w);
		w.draw();
	}
}
