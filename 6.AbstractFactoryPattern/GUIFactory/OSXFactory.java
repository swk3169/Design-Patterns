package GUIFactoryPattern;

public class OSXFactory implements GUIFactory
{
	public Button createButton() { return new OSXButton(); }
}
