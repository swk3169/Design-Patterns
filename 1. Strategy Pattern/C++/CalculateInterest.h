#pragma once
#include "Account.h"

class Account;

class CalculateInterest
{
public:
	CalculateInterest() {}
	~CalculateInterest() {}
	virtual int calculateInterest(Account account) = 0;
};