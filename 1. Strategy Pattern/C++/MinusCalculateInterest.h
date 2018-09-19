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
		cout << "이자 : ";
		return (int)(account.getBalance() * -0.07);	// 대출금의 -7%
	}
};