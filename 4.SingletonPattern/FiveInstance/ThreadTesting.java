package FiveInstanceSingletonPattern;

public class ThreadTesting extends Thread
{
	private Singleton threadInstance;
	
	public void run()	// �ν��Ͻ��� ������
	{
		threadInstance = Singleton.getInstance();
	}
	
	public String getDescription()	// ���ڿ��� ��ȯ�Ͽ� ����
	{
		return threadInstance.toString();
	}
}
