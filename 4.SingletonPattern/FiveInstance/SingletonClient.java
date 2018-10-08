package FiveInstanceSingletonPattern;

public class SingletonClient
{
	public static void main(String[] args)
	{
		ThreadTesting test[] = new ThreadTesting[5];
		for(int i=0; i<5; i++)
		{
			test[i] = new ThreadTesting();
			test[i].start();
		}
		
		for(int i=0; i<5; i++)	// �����尡 ����� ������ ���
		{
			try
			{
				test[i].join();
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		for(ThreadTesting singleton : test)	// ���
		{
			System.out.println(singleton.getDescription());
		}
	}
}
