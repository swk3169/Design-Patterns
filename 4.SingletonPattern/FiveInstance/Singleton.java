package FiveInstanceSingletonPattern;

public class Singleton
{
	private volatile static Singleton uniqueInstance;	// volatile Ű���带 ����ϸ� ��Ƽ�������� ������ uniqueInstance ������ Singleton �ν��Ͻ��� �ʱ�ȭ �Ǵ� ������ �ùٸ��� ����ǵ��� ��
	
	private Singleton() {}
	
	public static Singleton getInstance()
	{
		if(uniqueInstance == null)	// �ν��Ͻ��� �ִ��� Ȯ��, ������ ����ȭ �� ������ �̵�
		{
			synchronized (Singleton.class)	// ����ȭ�� ��
			{
				if(uniqueInstance == null)	// �ٽ� �ѹ� ������ null���� Ȯ�� (Double-Checking Locking)
				{
					uniqueInstance = new Singleton();
				}
			}
		}
		return uniqueInstance;
	}
}