#pragma once
#include "Account.h"
#include "Withdraw.h"

class MinusWithdraw : public Withdraw
{
public:
	MinusWithdraw() {}
	~MinusWithdraw() {}
	void withdraw(Account account, int money)
	{
		cout << "��ݾ� : " << money << endl;

		if (account.getBalance() - money < account.getCreditLimit())
		{
			cout << "�ѵ� �ʰ�! " << endl;
		}
		else
		{
			account.setBalance(account.getBalance() - money);
		}
	}
};