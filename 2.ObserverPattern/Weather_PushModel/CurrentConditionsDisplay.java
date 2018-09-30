package WeatherObserverPattern;

public class CurrentConditionsDisplay implements Observer, DisplayElement
{
	private float temperature;	// 기온
	private float humidity;	// 습도
	private float pressure;	// 압력
	private float windSpeed;	// 풍속
	private Subject weatherData;
	
	public CurrentConditionsDisplay(Subject weatherData)
	{
		this.weatherData = weatherData;
		weatherData.registerObserver(this);	// subject에 등록함.
	}

	@Override
	public void display()
	{
		// TODO Auto-generated method stub
		System.out.println("Current conditions: " + temperature + "F degrees and " + humidity + "% humidity and " + pressure + "atm pressure and " + windSpeed + "m/s wind speed");
	}

	@Override
	public void update(float temperature, float humidity, float pressure, float windSpeed)
	{
		// TODO Auto-generated method stub
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		this.windSpeed = windSpeed;
		
		display();
	}
}
