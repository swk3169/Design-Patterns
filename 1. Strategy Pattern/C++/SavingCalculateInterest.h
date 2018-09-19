#pragma once
#include "CalculateInterest.h"
#include "Account.h"

class SavingCalculateInterest : public CalculateInterest
{
public:
	SavingCalculateInterest() {}
	~SavingCalculateInterest() {}
	int calculateInterest(Account account)
	{
		cout << "이자 : ";
		return (int)(account.getBalance() * 0.05);	// 매년 잔고의 +5%
	}
};