package WeatherObserverPattern;

import java.util.Observable;

public class WeatherData extends Observable
{
	private WeatherInfo weatherInfo;
	
	// 관심 정보 변경
	public void measurementsChanged()
	{
		setChanged();
		// pull: if (hasChanged()) { for all observers, update(this, null); clearChanged(); }
		// push: if (hasChanged()) { for all observers, update(this, pushInfo); clearChanged(); }
		notifyObservers(weatherInfo);
	}
	
	// 기상청이 호출함.
	public void setMeasurements(WeatherInfo weatherInfo)
	{
		this.weatherInfo = weatherInfo;
		
		measurementsChanged();
	}
}
