package WeatherObserverPattern;

import java.util.Observable;

public class WeatherData extends Observable
{
	private WeatherInfo weatherInfo;
	
	// ���� ���� ����
	public void measurementsChanged()
	{
		setChanged();
		// pull: if (hasChanged()) { for all observers, update(this, null); clearChanged(); }
		// push: if (hasChanged()) { for all observers, update(this, pushInfo); clearChanged(); }
		notifyObservers(weatherInfo);
	}
	
	// ���û�� ȣ����.
	public void setMeasurements(WeatherInfo weatherInfo)
	{
		this.weatherInfo = weatherInfo;
		
		measurementsChanged();
	}
}
