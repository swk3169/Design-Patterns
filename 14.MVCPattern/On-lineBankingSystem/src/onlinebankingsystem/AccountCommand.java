package onlinebankingsystem;

abstract public class AccountCommand implements Command
{
	protected AccountDatabase accountDB;
	protected TransactionDatabase transactionDB;	
}
