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
		cout << "���� : ";
		return (int)(account.getBalance() * 0.05);	// �ų� �ܰ��� +5%
	}
};