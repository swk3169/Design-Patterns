package WeatherObserverPattern;

public interface Subject
{
	public void registerObserver(Observer o);
	public void removeObserver(Observer o);
	public void notifyObservers();
	// pull
	public float getTemperature();
	public float getHumidity();
	public float getPressure();
	public float getWindSpeed();
}
