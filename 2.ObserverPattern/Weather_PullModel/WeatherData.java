package WeatherObserverPattern;

import java.util.ArrayList;

public class WeatherData implements Subject
{
	private float temperature;	// 기온
	private float humidity;	// 습도
	private float pressure;	// 압력
	private float windSpeed;	// 풍속
	private ArrayList<Observer> observers;	// observer list
	
	public WeatherData() 
	{ 
		observers = new ArrayList<Observer>();
	}

	// Subject 인터페이스 구현
	@Override
	public void registerObserver(Observer o)
	{
		// TODO Auto-generated method stub
		observers.add(o);
	}

	@Override
	public void removeObserver(Observer o)
	{
		// TODO Auto-generated method stub
		int i = observers.indexOf(o);
		if (i >= 0)
		{
			observers.remove(i);
		}
	}

	@Override
	public void notifyObservers()
	{
		// TODO Auto-generated method stub
		for(Observer observer : observers)
		{
			observer.update();
		}
	}
	
	public void measurementsChanged()	// 통지 방법에 융통성을 부여하기 위해.
	{									// (예) if(condition) notifyObservers();
		notifyObservers();
	}
	
	public void setMeasurements(float temperature, float humidity, float pressure, float windSpeed)	// 기상청이 호출함.
	{
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		this.windSpeed = windSpeed;
		measurementsChanged();
	}

	public float getTemperature() { return temperature; }
	public float getHumidity() { return humidity; }
	public float getPressure() { return pressure; }
	public float getWindSpeed() { return windSpeed; }
}
