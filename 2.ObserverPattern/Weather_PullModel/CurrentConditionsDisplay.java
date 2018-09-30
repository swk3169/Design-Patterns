package WeatherObserverPattern;

public class CurrentConditionsDisplay implements Observer, DisplayElement
{
	private float temperature;	// ���
	private float humidity;	// ����
	private float pressure;	// �з�
	private float windSpeed;	// ǳ��
	private Subject weatherData;
	
	public CurrentConditionsDisplay(Subject weatherData)
	{
		this.weatherData = weatherData;
		weatherData.registerObserver(this);	// subject�� �����.
	}

	@Override
	public void display()
	{
		// TODO Auto-generated method stub
		System.out.println("Current conditions: " + temperature + "F degrees and " + humidity + "% humidity and " + pressure + "atm pressure and " + windSpeed + "m/s wind speed");
	}

	@Override
	public void update()
	{
		// TODO Auto-generated method stub
		this.temperature = weatherData.getTemperature();
		this.humidity = weatherData.getHumidity();
		this.pressure = weatherData.getPressure();
		this.windSpeed = weatherData.getWindSpeed();
		
		display();
	}
}
