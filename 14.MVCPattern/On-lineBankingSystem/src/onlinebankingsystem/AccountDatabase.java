package onlinebankingsystem;

import java.util.ArrayList;

public class AccountDatabase implements Subject
{
	private ArrayList<Observer> observers;
	private ArrayList<Account> account_list;

	public AccountDatabase()
	{
		observers = new ArrayList<Observer>();
		account_list = new ArrayList<Account>();
	}

	public Account findAccount(int account_number) // ���� �޾ƿ���
	{

		for (int i = 0; i < account_list.size(); i++)
		{
			if (account_list.get(i).getAccountNumber() == account_number)
			{
				return account_list.get(i);
			}
		}

		return null;
	}

	public boolean checkAccount(int account_number) // ���°� �ִ��� Ȯ��
	{
		boolean check = false;

		for (int i = 0; i < account_list.size(); i++)
		{
			if (account_list.get(i).getAccountNumber() == account_number)
			{
				check = true;
			}
		}
		return check;
	}

	public void insertAccount(Account acc) // ���� �߰�
	{
		account_list.add(acc);
		accountChanged();
	}

	public void deleteAccount(int account_number) // ���� ����
	{
		for (int i = 0; i < account_list.size(); i++)
		{
			if (account_number == account_list.get(i).getAccountNumber())
			{
				account_list.remove(i);
			}
		}
		accountChanged();
	}

	public void displayAccount() // �������� ���
	{
		// for(int i = 0; i < account_list.size(); i++)
		// {
		// System.out.println("����ȣ: " +
		// findClient(account_list.get(i).getClientId()).getName());
		// System.out.println("���¹�ȣ: " +
		// account_list.get(i).getAccountNumber());
		// System.out.println("�ܰ�: " + account_list.get(i).getBalance());
		// }
	}

	public boolean authenticateUser(int account_number, int pin) // ���� ����
	{
		Account acc = findAccount(account_number);
		return (acc != null) ? acc.validatePIN(pin) : false;
	}

	public ArrayList<Account> getAccountList()
	{
		return account_list;
	}

	public ArrayList<Account> getAccountListByClientID(int client_id)
	{
		int size = account_list.size();
		ArrayList<Account> accountList = new ArrayList<Account>();

		for (int i = 0; i < size; ++i)
		{
			Account acc = account_list.get(i);
			if (acc.getClientId() == client_id)
			{
				accountList.add(acc);
			}
		}
		return accountList;
	}

	public long getBalance(int account_number)
	{
		return findAccount(account_number).getBalance();
	}

	public boolean credit(int account_number, long amount)
	{
		return findAccount(account_number).credit(amount);
		// accountChanged();
	}

	public boolean debit(int account_number, long amount)
	{
		return findAccount(account_number).debit(amount);
		// accountChanged();
	}

	public void accountChanged()
	{
		notifyObservers();
	}

	public void registerObservers(Observer observer)
	{
		// TODO Auto-generated method stub
		observers.add(observer);
	}

	public void removeObservers(Observer observer)
	{
		// TODO Auto-generated method stub
		observers.remove(observer);
	}

	public void notifyObservers()
	{
		// TODO Auto-generated method stub
		for (Observer o : observers)
			o.update(this);
	}
}
