package WeatherObserverPattern;

public interface Observer
{
	//push model
	public void update(float temperature, float humidity, float pressure, float windSpeed);
}
