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
		cout << "���� : ";
		return (int)(account.getBalance() * 0.03);	// �ܰ��� +3%
	}
};