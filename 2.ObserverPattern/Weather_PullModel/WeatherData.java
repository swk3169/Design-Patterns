package WeatherObserverPattern;

import java.util.ArrayList;

public class WeatherData implements Subject
{
	private float temperature;	// ���
	private float humidity;	// ����
	private float pressure;	// �з�
	private float windSpeed;	// ǳ��
	private ArrayList<Observer> observers;	// observer list
	
	public WeatherData() 
	{ 
		observers = new ArrayList<Observer>();
	}

	// Subject �������̽� ����
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
	
	public void measurementsChanged()	// ���� ����� ���뼺�� �ο��ϱ� ����.
	{									// (��) if(condition) notifyObservers();
		notifyObservers();
	}
	
	public void setMeasurements(float temperature, float humidity, float pressure, float windSpeed)	// ���û�� ȣ����.
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
