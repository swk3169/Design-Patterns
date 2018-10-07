package ClassicSingletonPattern;

public class Singleton
{
	private static Singleton uniqueInstance;
	
	private Singleton() {}	// �����ڸ� private���� �����߱� ������ Singleton������ Ŭ������ �ν��Ͻ��� ���� �� �ִ�.
	
	public static Singleton getInstance()
	{
		if (uniqueInstance == null)	// null�� ��� ���� �ν��Ͻ��� �̻���
		{
			uniqueInstance = new Singleton();	// �ν��Ͻ��� �ʿ��� ��Ȳ�� ����� ������ �ν��Ͻ��� �������� ����. (lazy instantiation)
		}
		return uniqueInstance;	// �ν��Ͻ��� ����
	}
	
	public String getDescription()
	{
		return "I'm a classic Singleton!";
	}
}
