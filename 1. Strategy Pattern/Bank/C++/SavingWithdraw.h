#pragma once
#include "Account.h"
#include "Withdraw.h"

class SavingWithdraw : public Withdraw
{
public:
	SavingWithdraw() {}
	~SavingWithdraw() {}
	void withdraw(Account account, int money)
	{
		time_t today;

		struct tm curr_tm;

		today = time(NULL);


		time_t tm_mday = localtime_s(&curr_tm, &today);

		cout << "��ݾ� : " << money << endl;

		if (tm_mday != account.getExpirationDate())
		{
			cout << "��� �Ⱓ�� �ƴմϴ�" << endl;
		}
		else
		{
			account.setBalance(account.getBalance() - money);
		}
	}
};