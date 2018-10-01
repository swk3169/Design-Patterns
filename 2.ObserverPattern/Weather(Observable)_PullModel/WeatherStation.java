package WeatherObserverPattern;

public class WeatherStation
{
	public static void main(String[] args)
	{
		// observable (or subject) 积己.
		WeatherData weatherData = new WeatherData();
		
		// Observers 积己.
		CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);
		StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
		ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
		
		// 扁惑没捞 subject 积怕 函版.
		weatherData.setMeasurements(80, 65, 30.4f, 20);
		weatherData.setMeasurements(82, 70, 29.2f, 30);
		weatherData.setMeasurements(78, 90, 29.2f, 50);
	}
}
