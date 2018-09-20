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
		cout << "출금액 : " << money << endl;

		if (account.getBalance() - money < account.getCreditLimit())
		{
			cout << "한도 초과! " << endl;
		}
		else
		{
			account.setBalance(account.getBalance() - money);
		}
	}
};