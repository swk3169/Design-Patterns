package WeatherObserverPattern;

import java.util.Observable;

public class WeatherData extends Observable
{
	private float temperature;	// 기온
	private float humidity;	// 습도
	private float pressure;	// 압력
	private float windSpeed;	// 풍속
	
	public WeatherData(){}

	// for pulling
	public float getTemperature() { return temperature; }
	public float getHumidity() { return humidity; }
	public float getPressure() { return pressure; }
	public float getWindSpeed() { return windSpeed; }
	
	// 관심 정보 변경
	public void measurementsChanged()
	{
		setChanged();
		// pull: if (hasChanged()) { for all observers, update(this, null); clearChanged(); }
		// push: if (hasChanged()) { for all observers, update(this, pushInfo); clearChanged(); }
		notifyObservers();
	}
	
	// 기상청이 호출함.
	public void setMeasurements(float temperature, float humidity, float pressure, float windSpeed)
	{
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		this.windSpeed = windSpeed;
		
		measurementsChanged();
	}
}
