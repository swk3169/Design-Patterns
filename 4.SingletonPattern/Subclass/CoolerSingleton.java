package SubclassSingletonPattern;

public class CoolerSingleton extends Singleton
{
	protected static Singleton uniqueInstance;
	
	private CoolerSingleton()
	{
		super();
	}
}
