package ChocolateSingletonPattern;

import java.io.IOException;

public class ChocolateBoiler
{
	private boolean empty;
	private boolean boiled;
	private static ChocolateBoiler uniqueInstance;
	
	static
	{
		try
		{
			System.out.println("Creating unique instance of Chocolate Boiler");
			uniqueInstance = new ChocolateBoiler();
		}
		catch(IOException e)
		{
			throw new RuntimeException(e);
		}
	}
	
	private ChocolateBoiler() throws IOException	// ���Ϸ��� ��� ���� �� ����
	{
		empty = true;
		boiled = false;
	}
	
	public static ChocolateBoiler getInstance()
	{
//		if (uniqueInstance == null)
//		{
//			System.out.println("Creating unique instance of Chocolate Boiler");
//			uniqueInstance = new ChocolateBoiler();
//		}
		System.out.println("Returning instance of Chocolate Boiler");
		return uniqueInstance;
	}
	
	public void fill()
	{
		if (isEmpty())	// ���Ϸ��� ������� ���� ��Ḧ ���� �ִ´�.
		{
			empty = false;
			boiled = false;
			// ���Ϸ��� ����/���ݸ��� ȥ���� ��Ḧ �������
		}
	}
	
	public void drain()
	{
		if(!isEmpty() && isBoiled())	// ���Ϸ��� ���� ���ְ�, �� ������ ���¿����� ���Ϸ��� ����ִ� ��Ḧ ���� �ܰ�� �ѱ��.
		{	// ���� ��Ḧ ���� �ܰ�� �ѱ�
			empty = true;
		}
	}
	
	public void boil()
	{
		if(!isEmpty() && !isBoiled())	// ���Ϸ��� ���� �� �ְ� ���� ���� ���� ���¿����� ���ݸ��� ������ ȥ�յ� ��Ḧ ���δ�.
		{	// ��Ḧ ����
			boiled = true;
		}
	}
	
	public boolean isEmpty()
	{
		return empty;
	}
	
	public boolean isBoiled()
	{
		return boiled;
	}
}
