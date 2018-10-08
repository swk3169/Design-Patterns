package FiveInstanceSingletonPattern;

public class ThreadTesting extends Thread
{
	private Singleton threadInstance;
	
	public void run()	// 인스턴스를 가져옴
	{
		threadInstance = Singleton.getInstance();
	}
	
	public String getDescription()	// 문자열로 반환하여 리턴
	{
		return threadInstance.toString();
	}
}
