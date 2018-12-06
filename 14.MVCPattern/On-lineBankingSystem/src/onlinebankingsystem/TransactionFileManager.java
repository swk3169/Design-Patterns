package onlinebankingsystem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class TransactionFileManager
{
	public void save(TransactionDatabase transactionDB) throws IOException
	{
		PrintWriter pw = new PrintWriter("Transaction.txt");
		ArrayList<Transaction> transaction_list = transactionDB.getTransactionList();

		for (int i = 0; i < transaction_list.size(); i++)
		{
			Transaction transaction = transaction_list.get(i);

			pw.println(
					transaction.getId() + "," + transaction.getTransactionInfo() + "," + transaction.getDepositAccNum()
							+ "," + transaction.getWithdrawAccNum() + "," + transaction.getAmount() + ","
							+ new SimpleDateFormat("yyyyMMdd HH:mm:ss").format(transaction.getDate()) + ","
							+ transaction.getRemarks());
		}
		pw.close();
	}

	public void load(TransactionDatabase transactionDB) throws IOException, ParseException
	{
		BufferedReader br = new BufferedReader(new FileReader("Transaction.txt"));
		while (true)
		{
			String line = br.readLine();
			if (line == null)
				break;
			System.out.println(line);
			String array[] = line.split(",");
			System.out.println(array[0]);
			int id = Integer.parseInt(array[0]);
			String transaction_info = array[1];
			int deposit_acc_num = Integer.parseInt(array[2]);
			int withdraw_acc_num = Integer.parseInt(array[3]);
			long amount = Long.parseLong(array[4]);
			Date date = new SimpleDateFormat("yyyyMMdd HH:mm:ss").parse(array[5]);
			String remarks;
			try
			{
				remarks = array[6];
			} catch (Exception e)
			{
				remarks = "";
			}
			Transaction transac = new Transaction(transaction_info, deposit_acc_num, withdraw_acc_num, amount, date,
					remarks);
			transac.setId(id);

			transactionDB.insertTransaction(transac);

		}
		br.close();
	}
}
