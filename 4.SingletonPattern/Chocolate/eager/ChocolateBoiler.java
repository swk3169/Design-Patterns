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
	
	private ChocolateBoiler() throws IOException	// 보일러가 비어 있을 때 실행
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
		if (isEmpty())	// 보일러가 비어있을 때만 재료를 집어 넣는다.
		{
			empty = false;
			boiled = false;
			// 보일러에 우유/초콜릿을 혼합한 재료를 집어넣음
		}
	}
	
	public void drain()
	{
		if(!isEmpty() && isBoiled())	// 보일러가 가득 차있고, 다 끓여진 상태에서만 보일러가 들어있는 재료를 다음 단계로 넘긴다.
		{	// 끓인 재료를 다음 단계로 넘김
			empty = true;
		}
	}
	
	public void boil()
	{
		if(!isEmpty() && !isBoiled())	// 보일러가 가득 차 있고 아직 끓지 않은 상태에서만 초콜릿과 우유가 혼합된 재료를 끓인다.
		{	// 재료를 끓임
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
