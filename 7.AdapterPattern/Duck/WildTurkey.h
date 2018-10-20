#pragma once
#include <iostream>
#include "Turkey.h"

class WildTurkey : public Turkey 
{
public:
	void gobble() {
		std::cout << "Gobble gobble" << std::endl;
	}

	void fly() {
		std::cout << "I'm flying a short distance" << std::endl;
	}
};