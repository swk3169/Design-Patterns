#pragma once
#include "MallardDuck.h"
#include "WildTurkey.h"

class TurkeyAdapter : public MallardDuck, private WildTurkey 
{
public:
	void quack() 
	{
		gobble();
	}

	void fly() 
	{
		WildTurkey::fly();
	}
};