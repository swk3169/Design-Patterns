package FiveInstanceSingletonPattern;

public class Singleton
{
	private volatile static Singleton uniqueInstance;	// volatile 키워드를 사용하면 멀티쓰레딩을 쓰더라도 uniqueInstance 변수가 Singleton 인스턴스로 초기화 되는 과정이 올바르게 진행되도록 함
	
	private Singleton() {}
	
	public static Singleton getInstance()
	{
		if(uniqueInstance == null)	// 인스턴스가 있는지 확인, 없으면 동기화 된 블럭으로 이동
		{
			synchronized (Singleton.class)	// 동기화된 블럭
			{
				if(uniqueInstance == null)	// 다시 한번 변수가 null인지 확인 (Double-Checking Locking)
				{
					uniqueInstance = new Singleton();
				}
			}
		}
		return uniqueInstance;
	}
}