package CalculatorMVCPattern;

import java.util.ArrayList;

public class CalculatorModel implements Subject
{
	private int value = 0;
	private ArrayList<Observer> observers;
	
	public CalculatorModel() { observers = new ArrayList<Observer>(); }
	public void valueChanged() { notifyObservers(); }
	public void registerObserver(Observer o) { observers.add(o); }
	public void removeObserver(Observer o) { observers.remove(o); }
	public void notifyObservers()
	{
		for(int i = 0; i < observers.size(); i++)
		{
			Observer observer = (Observer)observers.get(i);
			observer.update(value);
		}
	}
	public int getValue() { return value; }
	public void setValue(int value) { this.value = value; }
}
