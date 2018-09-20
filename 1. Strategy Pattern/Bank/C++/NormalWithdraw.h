#pragma once
#include "Account.h"
#include "Withdraw.h"

class NormalWithdraw : public Withdraw
{
public:
	NormalWithdraw() {}
	~NormalWithdraw() {}
	void withdraw(Account account, int money)
	{
		cout << "출금액 : " << money << endl;

		if (account.getBalance() - money < account.getCreditLimit())
		{
			cout << "잔액이 부족합니다!" << endl;
		}
		else
		{
			account.setBalance(account.getBalance() - money);
		}
	}
};