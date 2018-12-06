package onlinebankingsystem;

import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;

import java.io.IOException;
import java.util.ArrayList;

public class AccountFileManager
{
	public void save(AccountDatabase accountDB) throws IOException
	{
		PrintWriter pw = new PrintWriter("Account.txt");
		ArrayList<Account> account_list = accountDB.getAccountList();
		for (int i = 0; i < account_list.size(); i++)
		{
			Account account = account_list.get(i);
			pw.println(account.getAccountNumber() + "," + account.getPIN() + "," + account.getBalance() + ","
					+ account.getClientId());
		}

		pw.close();
	}

	public void load(AccountDatabase accountDB) throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader("Account.txt"));
		while (true)
		{
			String line = br.readLine();
			if (line == null)
				break;

			String array[] = line.split(",");

			int account_number = Integer.parseInt(array[0]);
			int pin = Integer.parseInt(array[1]);
			long balance = Long.parseLong(array[2]);
			int client_id = Integer.parseInt(array[3]);

			Account acc = new Account(pin, balance, client_id);
			acc.setAccountNumber(account_number);

			accountDB.insertAccount(acc);

		}
		br.close();
	}
}
