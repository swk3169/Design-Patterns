package WeatherObserverPattern;

import java.util.Observable;

public class WeatherData extends Observable
{
	private float temperature;	// ���
	private float humidity;	// ����
	private float pressure;	// �з�
	private float windSpeed;	// ǳ��
	
	public WeatherData(){}

	// for pulling
	public float getTemperature() { return temperature; }
	public float getHumidity() { return humidity; }
	public float getPressure() { return pressure; }
	public float getWindSpeed() { return windSpeed; }
	
	// ���� ���� ����
	public void measurementsChanged()
	{
		setChanged();
		// pull: if (hasChanged()) { for all observers, update(this, null); clearChanged(); }
		// push: if (hasChanged()) { for all observers, update(this, pushInfo); clearChanged(); }
		notifyObservers();
	}
	
	// ���û�� ȣ����.
	public void setMeasurements(float temperature, float humidity, float pressure, float windSpeed)
	{
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		this.windSpeed = windSpeed;
		
		measurementsChanged();
	}
}
