#pragma once
#include "CalculateInterest.h"
#include "Account.h"

class NormalCalculateInterest : public CalculateInterest
{
public:
	NormalCalculateInterest() {}
	~NormalCalculateInterest() {}
	int calculateInterest(Account account)
	{
		cout << "ÀÌÀÚ : ";
		return (int)(account.getBalance() * 0.03);	// ÀÜ°íÀÇ +3%
	}
};