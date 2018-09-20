#pragma once
#include <iostream>
#include "Withdraw.h"
#include "CalculateInterest.h"
#include <ctime>

using namespace std;

class Account
{
protected:
	int balance = 0;	// �ܰ�
	int expirationDate = 30;	// ��ุ����
	int creditLimit = -1000;	// �ſ��ѵ���
	Withdraw* W;	// ���
	CalculateInterest* CI;	// ���ڰ��
public:
	Account() {}
	~Account() {}
	void deposit(int money)
	{
		cout << "�Աݾ� : " << money << endl;
		balance = balance + money;
	};
	void withdraw(int money) { W->withdraw(*this, money); }
	int calculateInterest() { return CI->calculateInterest(*this); }

	int getBalance() { return balance; }
	int getExpirationDate() { return expirationDate; }
	int getCreditLimit() { return creditLimit; }

	void setBalance(int balance) { this->balance = balance; }
};