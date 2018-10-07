package ChocolateSingletonPattern;

public class ChocolateBoiler
{
	private boolean empty;
	private boolean boiled;
	
	private ChocolateBoiler()	// ���Ϸ��� ��� ���� �� ����
	{
		empty = true;
		boiled = false;
	}
	
	private static class Holder
	{
		public static ChocolateBoiler uniqueInstance = new ChocolateBoiler();
	}
	
	public static ChocolateBoiler getInstance()
	{
		ChocolateBoiler uniqueInstance = Holder.uniqueInstance;
		
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
