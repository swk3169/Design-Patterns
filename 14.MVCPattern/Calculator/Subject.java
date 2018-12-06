package CalculatorMVCPattern;

public interface Subject
{
	public void registerObserver(Observer o);
	public void removeObserver(Observer o);
	public void notifyObservers();
	public void setValue(int value);
	public int getValue();
	public void valueChanged();
}
