package onlinebankingsystem;

import java.util.Date;

public class Transaction
{
	private static int ID = 0;
	private int id;
	private String transaction_info;
	private int deposit_acc_num;
	private int withdraw_acc_num;
	private long amount;
	private Date date;
	private String remarks;

	Transaction()
	{
		id++;
	}

	Transaction(String transaction_info, int deposit_acc_num, int withdraw_acc_num, long amount, Date date,
			String remarks)
	{
		id = ID++;
		this.transaction_info = transaction_info;
		this.deposit_acc_num = deposit_acc_num;
		this.withdraw_acc_num = withdraw_acc_num;
		this.amount = amount;
		this.date = date;
		this.remarks = remarks;
	}

	public void setId(int id)
	{
		this.id = id;
		Transaction.ID = ++id;
	}

	public int getId()
	{
		return id;
	}

	public String getTransactionInfo()
	{
		return transaction_info;
	}

	public int getDepositAccNum()
	{
		return deposit_acc_num;
	}

	public int getWithdrawAccNum()
	{
		return withdraw_acc_num;
	}

	public long getAmount()
	{
		return amount;
	}

	public Date getDate()
	{
		return date;
	}

	public String getRemarks()
	{
		return remarks;
	}
}