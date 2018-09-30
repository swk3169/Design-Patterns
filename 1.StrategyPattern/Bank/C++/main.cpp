#include <iostream>
#include "Account.h"
#include "Minus.h"
#include "Normal.h"
#include "Saving.h"
#include "CalculateInterest.h"
#include "Withdraw.h"

using namespace std;

int main(void)
{
	while (1)
	{
		cout << "-------- Bank --------" << endl;
		cout << "----- 1. normal ------" << endl;
		cout << "----- 2. minus -------" << endl;
		cout << "----- 3. saving ------" << endl;
		cout << "----- 4. exit --------" << endl;
		cout << "¼±ÅÃ : ";

		int select;
		cin >> select;

		switch (select)
		{
		case 1:
		{
			Account *normal = new Normal();
			normal->deposit(400);
			normal->withdraw(300);
			cout << normal->getBalance() << endl;
			cout << normal->calculateInterest() << endl;
		}
		break;
		case 2:
		{
			Account *minus = new Minus();
			minus->deposit(300);
			minus->withdraw(2000);
			cout << minus->getBalance() << endl;
			cout << minus->calculateInterest() << endl;
		}
		break;
		case 3:
		{
			Account *saving = new Saving();
			saving->deposit(500);
			saving->withdraw(400);
			cout << saving->getBalance() << endl;
			cout << saving->calculateInterest() << endl;
		}
		break;
		case 4:
			return 0;
		}
	}

	system("pause");
	return 0;
}