#include "TurkeyAdapter.h"
#include "DuckAdapter.h"

using namespace std;

int main()
{
	cout << "The TurkeyAdapter says..." << endl;
	Duck* duck = new TurkeyAdapter();
	duck->quack();
	duck->fly();
	cout << "The DuckAdapter says..." << endl;
	Turkey* turkey = new DuckAdapter();
	turkey->gobble();
	turkey->fly();

	system("pause");
	return 0;
}