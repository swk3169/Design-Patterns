#pragma once
#include "MallardDuck.h"
#include "WildTurkey.h"

class DuckAdapter : public WildTurkey, private MallardDuck 
{
public:
	void gobble() 
	{
		quack();
	}

	void fly() 
	{
		MallardDuck::fly();
	}
};