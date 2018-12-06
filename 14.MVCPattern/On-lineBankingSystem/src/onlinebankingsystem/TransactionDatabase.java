package onlinebankingsystem;

import java.util.ArrayList;
import java.util.Date;

public class TransactionDatabase implements Subject
{
	ArrayList<Observer> observers;
	ArrayList<Transaction> transaction_list;

	TransactionDatabase()
	{
		observers = new ArrayList<Observer>();
		transaction_list = new ArrayList<Transaction>();
	}

	private Transaction findTransaction(int id)
	{

		for (int i = 0; i < transaction_list.size(); i++)
		{
			if (transaction_list.get(i).getId() == id)
			{
				return transaction_list.get(i);
			}
		}

		return null;
	}

	public boolean checkTransaction(int id)
	{
		boolean check = true;

		for (int i = 0; i < transaction_list.size(); i++)
		{
			if (transaction_list.get(i).getId() == id)
			{
				check = false;
			}
		}
		return check;
	}

	public void insertTransaction(Transaction transaction)
	{
		transaction_list.add(transaction);
		transactionChanged();
	}

	public void deleteTransaction(int id)
	{
		for (int i = 0; i < transaction_list.size(); i++)
		{
			if (id == transaction_list.get(i).getId())
			{
				transaction_list.remove(i);
			}
		}
		transactionChanged();
	}

	public void displayTransaction()
	{
		// for(int i = 0; i < transaction_list.size(); i++)
		// {
		// System.out.println("°í°´¹øÈ£: " +
		// findClient(account_list.get(i).getClientId()).getName());
		// System.out.println("°èÁÂ¹øÈ£: " +
		// account_list.get(i).getAccountNumber());
		// System.out.println("ÀÜ°í: " + account_list.get(i).getBalance());
		// }
	}

	public ArrayList<Transaction> getTransactionList()
	{
		return transaction_list;
	}

	public String getTransactionInfo(int id)
	{
		return findTransaction(id).getTransactionInfo();
	}

	public int getDepositAccNum(int id)
	{
		return findTransaction(id).getDepositAccNum();
	}

	public int getWithdrawAccNum(int id)
	{
		return findTransaction(id).getWithdrawAccNum();
	}

	public long getAmount(int id)
	{
		return findTransaction(id).getAmount();
	}

	public Date getDate(int id)
	{
		return findTransaction(id).getDate();
	}

	public void transactionChanged()
	{
		notifyObservers();
	}

	public ArrayList<Transaction> getTransactionList(int account_number)
	{
		ArrayList<Transaction> acc_transaction_list = new ArrayList<Transaction>();

		int size = transaction_list.size();
		for (int i = 0; i < size; ++i)
		{
			Transaction transaction = transaction_list.get(i);

			if (transaction.getWithdrawAccNum() == account_number || transaction.getDepositAccNum() == account_number)
			{
				acc_transaction_list.add(transaction);
			}
		}

		return acc_transaction_list;
	}

	public ArrayList<Transaction> getTransactionListInDuration(int account_number, int days)
	{
		ArrayList<Transaction> acc_transaction_list = new ArrayList<Transaction>();

		int size = transaction_list.size();
		Date cur = new Date();
		long curTime = cur.getTime();

		for (int i = 0; i < size; ++i)
		{
			Transaction transaction = transaction_list.get(i);

			if (transaction.getWithdrawAccNum() == account_number || transaction.getDepositAccNum() == account_number)
			{
				Date transactionDate = transaction.getDate();
				long transactionTime = transactionDate.getTime();

				long diffTime = curTime - transactionTime;
				long diffDays = diffTime / (1000 * 60 * 60 * 24);
				System.out.println(diffDays);
				if (diffDays < days)
				{
					acc_transaction_list.add(transaction);
				}
			}
		}
		return acc_transaction_list;
	}

	public void notifyObservers()
	{
		for (Observer o : observers)
		{
			o.update(this);
		}
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
}
