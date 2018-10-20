#pragma once
#include <iostream>
#include "Duck.h"

class MallardDuck : public Duck 
{
public:
	void quack() {
		std::cout << "Quack!" << std::endl;
	}

	void fly() {
		std::cout << "I am flying" << std::endl;
	}
};