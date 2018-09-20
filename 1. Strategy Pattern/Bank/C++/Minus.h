#pragma once
#include "Account.h"
#include "MinusWithdraw.h"
#include "MinusCalculateInterest.h"

class Minus : public Account
{
public:
	Minus()
	{
		W = new MinusWithdraw();
		CI = new MinusCalculateInterest();
	}
	~Minus() {}
};