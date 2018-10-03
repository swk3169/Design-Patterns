package WindowDecoratorPattern;

public abstract class WindowDecorator implements Window
{
	protected Window wrappedWindow;	// Composition
	
	public WindowDecorator(Window w)
	{
		this.wrappedWindow = w;
	}
	public void draw()
	{
		wrappedWindow.draw();	// ю╖юс
	}
}
