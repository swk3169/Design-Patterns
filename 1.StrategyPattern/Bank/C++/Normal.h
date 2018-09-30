#pragma once
#include "Account.h"
#include "NormalWithdraw.h"
#include "NormalCalculateInterest.h"

class Normal : public Account
{
public:
	Normal()
	{
		W = new NormalWithdraw();
		CI = new NormalCalculateInterest();
	}
	~Normal() {}
};