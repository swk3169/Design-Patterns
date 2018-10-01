package WeatherObserverPattern;

public class WeatherInfo
{
    private float temperature;
    private float humidity;
    private float pressure;
    private float windSpeed;

    public WeatherInfo(float temperature, float humidity, float pressure, float windSpeed) 
    {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        this.windSpeed = windSpeed;
    }

    public float getTemperature() { return temperature; }
    public float getHumidity() { return humidity; }
    public float getPressure() { return pressure; }
    public float getWindSpeed() { return windSpeed; }
}
