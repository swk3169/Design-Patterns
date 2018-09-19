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
		cout << "��ݾ� : " << money << endl;

		if (account.getBalance() - money < account.getCreditLimit())
		{
			cout << "�ܾ��� �����մϴ�!" << endl;
		}
		else
		{
			account.setBalance(account.getBalance() - money);
		}
	}
};