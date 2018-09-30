package WeatherObserverPattern;

public class StatisticsDisplay implements Observer, DisplayElement
{
	private float maxTemp = 0.0f;
	private float minTemp = 200;
	private float tempSum = 0.0f;
	private int numReadings;
	private WeatherData weatherData;
	
	public StatisticsDisplay(WeatherData weatherData)
	{
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}
	
	public void display()
	{
		System.out.println("Avg/Max/Min temperature = " + (tempSum / numReadings) + "/" + maxTemp + "/" + minTemp);
	}
	
	public void update(float temperature, float humidity, float pressure, float windSpeed)
	{
		tempSum += temperature;
		numReadings++;
		
		if(temperature > maxTemp)
		{
			maxTemp = temperature;
		}
		
		if(temperature < minTemp)
		{
			minTemp = temperature;
		}
		
		display();
	}
}
