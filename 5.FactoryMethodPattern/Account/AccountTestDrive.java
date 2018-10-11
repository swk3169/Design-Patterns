package AccountFactoryPattern;

public class AccountTestDrive
{
	public static void main(String[] args)
	{
		AccountFactory accountFactory = new AccountFactory();
		Bank bank = new Bank(accountFactory);
		
		Account account = bank.orderAccount("Normal");
		System.out.println("Normal balance : " + account.getBalance());
		System.out.println();
		
		account = bank.orderAccount("Minus");
		System.out.println("Minus balance : " + account.getBalance());
		System.out.println();
		
		account = bank.orderAccount("Security");
		System.out.println("Security balance : " + account.getBalance());
		System.out.println();
	}
}
