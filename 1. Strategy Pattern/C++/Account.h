#pragma once
#include <iostream>
#include "Withdraw.h"
#include "CalculateInterest.h"
#include <ctime>

using namespace std;

class Account
{
protected:
	int balance = 0;	// 잔고
	int expirationDate = 30;	// 계약만료일
	int creditLimit = -1000;	// 신용한도액
	Withdraw* W;	// 출금
	CalculateInterest* CI;	// 이자계산
public:
	Account() {}
	~Account() {}
	void deposit(int money)
	{
		cout << "입금액 : " << money << endl;
		balance = balance + money;
	};
	void withdraw(int money) { W->withdraw(*this, money); }
	int calculateInterest() { return CI->calculateInterest(*this); }

	int getBalance() { return balance; }
	int getExpirationDate() { return expirationDate; }
	int getCreditLimit() { return creditLimit; }

	void setBalance(int balance) { this->balance = balance; }
};