package ClassicSingletonPattern;

public class Singleton
{
	private static Singleton uniqueInstance;
	
	private Singleton() {}	// 생성자를 private으로 선언했기 때문에 Singleton에서만 클래스의 인스턴스를 만들 수 있다.
	
	public static Singleton getInstance()
	{
		if (uniqueInstance == null)	// null인 경우 아직 인스턴스가 미생성
		{
			uniqueInstance = new Singleton();	// 인스턴스가 필요한 상황이 생기기 전에는 인스턴스가 생성되지 않음. (lazy instantiation)
		}
		return uniqueInstance;	// 인스턴스를 리턴
	}
	
	public String getDescription()
	{
		return "I'm a classic Singleton!";
	}
}
