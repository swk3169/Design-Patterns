package AccountStrategyPattern;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		while(true)
		{
			System.out.println("-------- Bank --------");
			System.out.println("----- 1. normal ------");
			System.out.println("----- 2. minus ------");
			System.out.println("----- 3. saving ------");
			System.out.println("----- 4. exit ------");
			System.out.print("º±≈√ : ");
			
			int select;
			select = sc.nextInt();
			
			switch(select)
			{
			case 1:
				Account normal = new Normal();
				
				normal.deposit(400);
				normal.withdraw(300);
				System.out.println(normal.getBalance());
				System.out.println(normal.calculateInterest());
				break;
			case 2:
				Account minus = new Minus();
				
				minus.deposit(300);
				minus.withdraw(2000);
				System.out.println(minus.getBalance());
				System.out.println(minus.calculateInterest());
				break;
			case 3:
				Account saving = new Saving();
				
				saving.deposit(500);
				saving.withdraw(400);
				System.out.println(saving.getBalance());
				System.out.println(saving.calculateInterest());
				break;
			case 4:
				System.exit(1);
			}
		}
	}
	
}
