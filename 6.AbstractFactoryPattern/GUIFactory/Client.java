package GUIFactoryPattern;

public class Client
{
	public static void main(String[] args)
	{
		GUIFactory win = new WinFactory();
		Button winButton = win.createButton();
		winButton.paint();
		
		GUIFactory osx = new OSXFactory();
		Button osxButton = osx.createButton();
		osxButton.paint();
	}
}
