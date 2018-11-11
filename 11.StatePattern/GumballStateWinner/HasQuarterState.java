package GumballStateWinner;

import java.util.Random;

public class HasQuarterState implements State
{
	private Random randomWinner = new Random(System.currentTimeMillis());	// 10%�� Ȯ���� ��÷ ���θ� �����ϴ� ���� �߻��⸦ �߰�
	private GumballMachine gumballMachine;

	public HasQuarterState(GumballMachine gumballMachine)
	{
		this.gumballMachine = gumballMachine;
	}

	public void insertQuarter()
	{
		System.out.println("You can't insert another quarter");
	}

	public void ejectQuarter()
	{
		System.out.println("Quarter returned");
		gumballMachine.setState(gumballMachine.getNoQuarterState());
	}

	public void turnCrank()
	{
		System.out.println("You turned...");
		// �����̸� ���� �մ��� ��÷�Ǿ����� Ȯ��
		int winner = randomWinner.nextInt(10);
		if ((winner == 0) && (gumballMachine.getCount() > 1))	// ��÷�� �Ǿ��� �˸��̵� �� �� �̻��̸� WinnerState
		{
			gumballMachine.setState(gumballMachine.getWinnerState());
		} 
		else	// �� ���� �� �ϳ��� �������� ������ �׳� ���� ���������� SoldState
		{
			gumballMachine.setState(gumballMachine.getSoldState());
		}
	}

	public void dispense()
	{
		System.out.println("No gumball dispensed");
	}

	public void refill() {}

	public String toString()
	{
		return "waiting for turn of crank";
	}
}