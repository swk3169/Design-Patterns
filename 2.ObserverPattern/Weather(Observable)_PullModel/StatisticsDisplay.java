package WeatherObserverPattern;

import java.util.Observable;
import java.util.Observer;

public class StatisticsDisplay implements Observer, DisplayElement
{
	private float maxTemp = 0.0f;
	private float minTemp = 200;
	private float tempSum = 0.0f;
	private int numReadings;

	public StatisticsDisplay(Observable observable)
	{
		observable.addObserver(this);	// 생성 시 subject에 등록함.
	}
	
	public void display()
	{
		System.out.println("Avg/Max/Min temperature = " + (tempSum / numReadings) + "/" + maxTemp + "/" + minTemp);
	}
	
	public void update(Observable o, Object arg)
	{
		if(o instanceof WeatherData)
		{
			WeatherData weatherData = (WeatherData)o;
			float temp = weatherData.getTemperature();
			tempSum += temp;
			numReadings++;
			
			if(temp > maxTemp)
			{
				maxTemp = temp;
			}
			
			if(temp < minTemp)
			{
				minTemp = temp;
			}
			
			display();
		}
	}
}
