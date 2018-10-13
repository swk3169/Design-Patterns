package AccountFactoryPattern;

public class AccountTestDrive
{
	public static void main(String[] args)
	{
		Bank bankA = new BankA();
		
		Account account = bankA.orderAccount("Normal");
		System.out.println("Bank A Nomal balance : " + account.getBalance());
		System.out.println();
		
		account = bankA.orderAccount("Minus");
		System.out.println("Bank A Minus balance : " + account.getBalance());
		System.out.println();
		
		account = bankA.orderAccount("Security");
		System.out.println("Bank A Security balance : " + account.getBalance());
		System.out.println();
		
		Bank bankB = new BankB();
		
		account = bankB.orderAccount("Normal");
		System.out.println("Bank B Nomal balance : " + account.getBalance());
		System.out.println();
		
		account = bankB.orderAccount("Minus");
		System.out.println("Bank B Minus balance : " + account.getBalance());
		System.out.println();
		
		account = bankB.orderAccount("Security");
		System.out.println("Bank B Security balance : " + account.getBalance());
		System.out.println();
		
		Bank bankC = new BankC();
		
		account = bankC.orderAccount("Normal");
		System.out.println("Bank C Nomal balance : " + account.getBalance());
		System.out.println();
		
		account = bankC.orderAccount("Minus");
		System.out.println("Bank C Minus balance : " + account.getBalance());
		System.out.println();
	}
}
