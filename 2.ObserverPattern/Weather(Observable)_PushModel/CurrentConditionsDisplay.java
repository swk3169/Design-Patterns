package WeatherObserverPattern;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditionsDisplay implements Observer, DisplayElement
{
	private float temperature;	// 기온
	private float humidity;	// 습도
	private float pressure;	// 압력
	private float windSpeed;	// 풍속
	private Observable observable;	// subject
	
	public CurrentConditionsDisplay(Observable observable)
	{
		this.observable = observable;
		this.observable.addObserver(this);	// 생성 시 subject에 등록함.
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
		if(arg != null)
		{
			WeatherInfo weatherInfo = (WeatherInfo)arg;
			this.temperature = weatherInfo.getTemperature();
			this.humidity = weatherInfo.getHumidity();
			this.pressure = weatherInfo.getPressure();
			this.windSpeed = weatherInfo.getWindSpeed();
			display();
		}
	}
}
