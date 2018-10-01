package WeatherObserverPattern;

import java.util.Observable;
import java.util.Observer;

public class ForecastDisplay implements Observer, DisplayElement
{
	private float currentPressure = 29.92f;
	private float lastPressure;
	
	public ForecastDisplay(Observable observable)
	{
		observable.addObserver(this);	// 생성 시 subject에 등록함.
	}
	
	public void display()
	{
		System.out.print("Forecast: ");
		if(currentPressure > lastPressure)
		{
			System.out.println("Improving weather on the way!");
		}
		else if(currentPressure == lastPressure)
		{
			System.out.println("More of the same");
		}
		else if(currentPressure < lastPressure)
		{
			System.out.println("Watch out for cooler, rainy weather");
		}
	}
	
	public void update(Observable o, Object arg)
	{
		if(arg != null)
		{
			WeatherInfo weatherInfo = (WeatherInfo)arg;
			
			lastPressure = currentPressure;
			currentPressure = weatherInfo.getPressure();
			
			display();
		}
	}
}
