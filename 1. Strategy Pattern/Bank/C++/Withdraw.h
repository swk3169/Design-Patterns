#pragma once
#include "Account.h"

class Account;

class Withdraw
{
public:
	Withdraw() {}
	~Withdraw() {}
	virtual void withdraw(Account account, int money) = 0;
};