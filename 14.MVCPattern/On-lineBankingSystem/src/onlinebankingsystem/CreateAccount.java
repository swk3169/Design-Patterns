package onlinebankingsystem;

import java.util.Date;

public class CreateAccount extends AccountCommand
{
	private int client_id;
	private String client_mail;
	private int balance;
	private int pin;
	private int kind;

	public CreateAccount(AccountDatabase accountDB, TransactionDatabase transactionDB, int client_id,
			String client_mail, int balance, int pin, int kind)
	{
		super.accountDB = accountDB;
		super.transactionDB = transactionDB;

		this.client_id = client_id;
		this.client_mail = client_mail;
		this.pin = pin;
		this.balance = balance;
		this.kind = kind;
	}

	public void execute()
	{
		// TODO Auto-generated method stub
		Account acc = null;

		// Account(int pin, long amount, int client_id)
		switch (kind)
		{
		case 0:
			acc = new Account(pin, balance, client_id);
			break;

		case 1:
			acc = new FreeAccount(pin, balance, client_id);
			break;

		case 2:
			acc = new MinusAccount(pin, balance, client_id);
			break;
		}

		Transaction transaction = new Transaction("입금", acc.getAccountNumber(), acc.getAccountNumber(), balance,
				new Date(), "");
		StringBuffer text = new StringBuffer();
		text.append("계좌 번호: " + String.valueOf(acc.getAccountNumber()) + "\n");
		text.append("계좌 종류: " + String.valueOf(acc.toString()) + "\n");
		text.append("계좌 비밀번호: " + String.valueOf(acc.getPIN()) + "\n");
		MailingThread mailing = new MailingThread(client_mail, "[계좌 생성 정보]", text.toString());

		accountDB.insertAccount(acc);
		transactionDB.insertTransaction(transaction);

		mailing.start();
	}
}
