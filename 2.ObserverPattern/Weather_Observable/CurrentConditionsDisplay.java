package WeatherObserverPattern;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditionsDisplay implements Observer, DisplayElement
{
	private float temperature;	// ���
	private float humidity;	// ����
	private float pressure;	// �з�
	private float windSpeed;	// ǳ��
	private Observable observable;	// subject
	
	public CurrentConditionsDisplay(Observable observable)
	{
		this.observable = observable;
		observable.addObserver(this);	// ���� �� subject�� �����.
	}

	@Override
	public void display()
	{
		// TODO Auto-generated method stub
		System.out.println("Current conditions: " + temperature + "F degrees and " + humidity + "% humidity and " + pressure + "atm pressure and " + windSpeed + "m/s wind speed");
	}

	@Override
	public void update(Observable o, Object arg)
	{
		// TODO Auto-generated method stub
		if(o instanceof WeatherData)
		{
			WeatherData weatherData = (WeatherData)o;
			this.temperature = weatherData.getTemperature();	// pulling
			this.humidity = weatherData.getHumidity();	// pulling
			this.pressure = weatherData.getPressure();	// pulling
			this.windSpeed = weatherData.getWindSpeed();	// pulling
			display();
		}
	}
}
