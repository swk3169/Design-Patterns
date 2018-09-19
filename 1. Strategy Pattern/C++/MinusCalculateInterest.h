#pragma once
#include "CalculateInterest.h"
#include "Account.h"

class MinusCalculateInterest : public CalculateInterest
{
public:
	MinusCalculateInterest() {}
	~MinusCalculateInterest() {}
	int calculateInterest(Account account)
	{
		cout << "���� : ";
		return (int)(account.getBalance() * -0.07);	// ������� -7%
	}
};