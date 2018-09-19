#pragma once
#include "Account.h"
#include "SavingWithdraw.h"
#include "SavingCalculateInterest.h"

class Saving : public Account
{
public:
	Saving()
	{
		W = new SavingWithdraw();
		CI = new SavingCalculateInterest();
	}
	~Saving() {}
};